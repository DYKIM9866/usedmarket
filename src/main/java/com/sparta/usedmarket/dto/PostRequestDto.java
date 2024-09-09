package com.sparta.usedmarket.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String username;
    private String title;
    private String content;
    private int price;
}
