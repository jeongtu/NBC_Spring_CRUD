package com.sparta.boardjwt1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResultDto extends DtoBase{

    private int code;
    private String message;

    public ResultDto(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
