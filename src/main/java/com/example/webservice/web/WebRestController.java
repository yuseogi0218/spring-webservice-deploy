package com.example.webservice.web;

import com.example.webservice.domain.Posts;
import com.example.webservice.domain.PostsRepository;
import com.example.webservice.dto.posts.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WebRestController {

    private final PostsRepository postsRepository;

    @GetMapping("/hello")
    public String helloPage() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public ResponseEntity<?> savePosts(@RequestBody PostsSaveRequestDto dto){
        return ResponseEntity.ok(postsRepository.save(dto.toEntity()));
    }
}
