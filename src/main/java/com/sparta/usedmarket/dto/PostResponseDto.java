package com.sparta.usedmarket.dto;

import com.sparta.usedmarket.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public PostResponseDto(Post savePost) {
        this.id = savePost.getId();
        this.username = savePost.getUsername();
        this.title = savePost.getTitle();
        this.content = savePost.getContent();
        this.price = savePost.getPrice();
    }
}
