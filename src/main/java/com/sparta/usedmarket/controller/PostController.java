package com.sparta.usedmarket.controller;

import com.sparta.usedmarket.dto.PostRequestDto;
import com.sparta.usedmarket.dto.PostResponseDto;
import com.sparta.usedmarket.dto.TextResponseDto;
import com.sparta.usedmarket.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostResponseDto create(@RequestBody PostRequestDto requestDto){
        return postService.create(requestDto);
    }

    @GetMapping
    public List<PostResponseDto> list(){
        return postService.list();
    }

    @PutMapping("/{id}")
    public PostResponseDto update(@PathVariable("id") Long id
            , @RequestBody PostRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public TextResponseDto delete(@PathVariable("id") Long id){
        return postService.delete(id);
    }
}