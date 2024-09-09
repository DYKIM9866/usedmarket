package com.sparta.usedmarket.service;

import com.sparta.usedmarket.dto.PostRequestDto;
import com.sparta.usedmarket.dto.PostResponseDto;
import com.sparta.usedmarket.dto.TextResponseDto;
import com.sparta.usedmarket.entity.Post;
import com.sparta.usedmarket.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto create(PostRequestDto requestDto) {
        Post post = new Post(requestDto);

        Post savePost = postRepository.save(post);

        return new PostResponseDto(savePost);
    }

    public List<PostResponseDto> list() {
        return postRepository.findAll()
                .stream()
                .map(PostResponseDto::new).toList();
    }

    @Transactional
    public PostResponseDto update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 ID의 포스트는 존재하지 않습니다."));

        post.update(requestDto);

        return new PostResponseDto(post);
    }

    public TextResponseDto delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 ID의 포스트는 존재하지 않습니다."));

        postRepository.delete(post);

        return new TextResponseDto("삭제완료");
    }
}
