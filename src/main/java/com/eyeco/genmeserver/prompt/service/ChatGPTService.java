package com.eyeco.genmeserver.prompt.service;

import com.eyeco.genmeserver.common.config.ChatGPTConfig;
import com.eyeco.genmeserver.dto.*;
import com.eyeco.genmeserver.entity.SetUpAnswer;
import com.eyeco.genmeserver.setup.repository.SetUpAnswerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatGPTService {
    private final ChatGPTConfig chatGPTConfig;
    private final SetUpAnswerRepository setUpAnswerRepository;


    @Value("${openai.url.prompt}")
    private String promptUrl;

    @Value("${openai.url.legacy-prompt}")
    private String legacyPromptUrl;

    public Map<String, Object> legacyPrompt(CompletionDto completionDto) {
        log.debug("[+] 레거시 프롬프트를 수행합니다.");

        HttpHeaders headers = chatGPTConfig.httpHeaders();

        HttpEntity<CompletionDto> requestEntity = new HttpEntity<>(completionDto, headers);
        ResponseEntity<String> response = chatGPTConfig
                .restTemplate()
                .exchange(legacyPromptUrl, HttpMethod.POST, requestEntity, String.class);

        Map<String, Object> resultMap = new HashMap<>();
        try {
            ObjectMapper om = new ObjectMapper();
            resultMap = om.readValue(response.getBody(), new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            log.debug("JsonMappingException :: " + e.getMessage());
        } catch (RuntimeException e) {
            log.debug("RuntimeException :: " + e.getMessage());
        }
        return resultMap;
    }


    /**
     * 신규 모델에 대한 프롬프트
     *
     * @param request {}
     * @return chatCompletionDto
     */


    public PromptingResponse prompt(PromptingRequest request) {
        log.debug("[+] 신규 프롬프트를 수행합니다.");
        ObjectMapper objectMapper = new ObjectMapper();


        SetUpAnswer setUpAnswer = setUpAnswerRepository.findByNickname(request.getNickname());
        String setUp = setUpAnswer.getAnswerContent();

        List<ChatRequestDto> questions = new ArrayList<>();

        ChatRequestDto setUpParam = new ChatRequestDto(setUp);
        ChatRequestDto question = new ChatRequestDto(request.getQuestion());
        questions.add(setUpParam);
        questions.add(question);

        ChatCompletionDto test = new ChatCompletionDto(questions);

        HttpHeaders headers = chatGPTConfig.httpHeaders();

        HttpEntity<ChatCompletionDto> requestEntity = new HttpEntity<>(test, headers);
        ResponseEntity<String> response = chatGPTConfig
                .restTemplate()
                .exchange(promptUrl, HttpMethod.POST, requestEntity, String.class);
        String content = "";
        try {
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            content = rootNode.path("choices").get(0).path("message").path("content").asText();
        } catch (JsonProcessingException e) {
            log.debug("JsonMappingException :: " + e.getMessage());
        } catch (RuntimeException e) {
            log.debug("RuntimeException :: " + e.getMessage());
        }
        return new PromptingResponse(content);
    }
}