package com.sparta.usedmarket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TextResponseDto {
    private String msg;

    public TextResponseDto(String msg) {
        this.msg = msg;
    }
}
