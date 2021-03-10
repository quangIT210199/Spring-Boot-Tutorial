package com.quang.springboot15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Chúng ta sẽ xử lý exception trong Spring boot
# @RestControllerAdvice & @ControllerAdvice + @ExceptionHandler
* -@RestControllerAdvice gắn trên các Class giúp xen vô quá trình xử lý của @RestController

@ResponseStatus là một cách định nghĩa Http Status trả về cho người dùng.
Nếu bạn không muốn sử dụng ResponseEntity thì có thể dùng @ResponseStatus đánh dấu trên Object trả về.
* */

@SpringBootApplication
public class SpringBoot15Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot15Application.class, args);
    }

}
