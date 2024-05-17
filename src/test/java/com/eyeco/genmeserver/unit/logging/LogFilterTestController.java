package com.eyeco.genmeserver.unit.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("test")
public class LogFilterTestController {
	@GetMapping("/log")
	public ResponseEntity<?> getLogTest() {
		log.info("get 테스트 실행되었습니다.");
		return ResponseEntity.status(HttpStatus.OK).body("정상적으로 처리되었습니다.");
	}

	@PostMapping("/log")
	public ResponseEntity<?> postLogTest(@RequestBody LogFilterTestDto logFilterTestDto) {
		log.info("post 테스트 실행되었습니다.");
		log.info("logFilterTestDto : {}", logFilterTestDto);
		if (logFilterTestDto == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("memberRegisterDto가 없습니다.");
		}
		return ResponseEntity.status(HttpStatus.OK).body("정상적으로 처리되었습니다.");
	}
}
