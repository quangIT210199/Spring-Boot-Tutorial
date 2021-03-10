package com.quang.springbootsecurityjwt.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class RandomStuff {
    private String message;

    public RandomStuff(String message) {
        this.message = message;
    }
}
