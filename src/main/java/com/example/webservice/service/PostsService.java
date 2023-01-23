package com.example.webservice.service;

import com.example.webservice.domain.PostsRepository;
import com.example.webservice.dto.posts.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsService postsService;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
