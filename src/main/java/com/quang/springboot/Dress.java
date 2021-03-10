package com.quang.springboot;

import org.springframework.stereotype.Component;

@Component("Dress")
public class Dress implements Outfit{
    @Override
    public void wear() {
        System.out.println("Dang mac vay");
    }
}
