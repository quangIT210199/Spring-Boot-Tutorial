package com.example.springboot9thymeleafexpression;

/*
* Class này dùng để lưu trữ Thông tin
* */

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Info {
    String key;
    String value;
}
