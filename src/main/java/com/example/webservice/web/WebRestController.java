package com.example.webservice.web;

import com.example.webservice.domain.Posts;
import com.example.webservice.domain.PostsRepository;
import com.example.webservice.dto.posts.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
public class WebRestController {

    private final PostsRepository postsRepository;
    private final Environment env; // 프로젝트의 환경설정 값을 다루는 Bean

    @GetMapping("/hello")
    public String helloPage() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public ResponseEntity<?> savePosts(@RequestBody PostsSaveRequestDto dto) {
        return ResponseEntity.ok(postsRepository.save(dto.toEntity()));
    }

    /**
     * 실행중인 프로젝트의 Profile 이 뭔지 확인할 수 있는 API
     */
    @GetMapping("/profile")
    public String getProfile() {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
}
