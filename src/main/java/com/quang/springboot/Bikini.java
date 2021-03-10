package com.quang.springboot;

import org.springframework.stereotype.Component;

/*-Đánh dấu class bằng @Component
Class này Spring boot hiểu là 1 Bean (hoặc dependency)
Sẻ dc spring boot quản lý trong Application context
 */
@Component
// @Scope("prototype") //bỏ cơ chế Singleton
public class Bikini implements Outfit{
    @Override
    public void wear() {
        System.out.println("Mặc Bikini");
    }
}
