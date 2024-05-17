package com.eyeco.genmeserver.service;

import com.eyeco.genmeserver.common.config.ChatGPTConfig;
import com.eyeco.genmeserver.dto.*;
import com.eyeco.genmeserver.entity.SetUpAnswer;
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
//    private final SetUpAnswerRepository setUpAnswerRepository;


    @Value("${openai.url.model}")
    private String modelUrl;

    @Value("${openai.url.model-list}")
    private String modelListUrl;

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
     * @param chatCompletionDto {}
     * @return chatCompletionDto
     */


    public PromptingResponse prompt(PromptingRequest request) {
        log.debug("[+] 신규 프롬프트를 수행합니다.");
        ObjectMapper objectMapper = new ObjectMapper();


//        SetUpAnswer setUpAnswer = setUpAnswerRepository.findByNickname(request.getNickname());
//
//        String setUp = setUpAnswer.getAnswerContent();

        String setUp = "```넌 내가 설명하는 사람이야. 설명을 듣고 질문에 나와 대화하듯이 친절하게 말해줘! \n 스택: 피그마 \n MBTI:INTJ \n 주요 활동지: 신촌 \n 나를 소개해주세요: 안녕하세요! 저는 UX/UI 디자이너 문주예요 편집디자인, 그래픽디자인을 거쳐 UX/UI 디자인으로 이직 준비를 하고 있어요 2개의 프로젝트에서 개발자, 기획자, 마케터 분들과의 협업 경험이 있어요. \n 취미와 관심사 : K-POP을 좋아해요 K-POP 고인물이라 다양한 노동요 플레이리스트를 엄선해서 틀어드릴 수 있어요 그룹 솔로 상관없이 가사가 좋은 K-POP을 찾아 다녀요. \n```너는 내가 위에 보낸 캐릭터라고 생각하고 나의 다음 질문에 대해 대답해줘.";
        List<ChatRequestDto> questions = new ArrayList<>();

        ChatRequestDto setUpParam = new ChatRequestDto(setUp);
        ChatRequestDto question = new ChatRequestDto(request.getQuestion());
        questions.add(setUpParam);
        questions.add(question);

        ChatCompletionDto test = new ChatCompletionDto(questions);



        Map<String, Object> resultMap = new HashMap<>();

        HttpHeaders headers = chatGPTConfig.httpHeaders();

        HttpEntity<ChatCompletionDto> requestEntity = new HttpEntity<>(test, headers);
        ResponseEntity<String> response = chatGPTConfig
                .restTemplate()
                .exchange(promptUrl, HttpMethod.POST, requestEntity, String.class);
        String content = "";
        try {

            ObjectMapper om = new ObjectMapper();

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