package com.quang.springsecurityhibernate;

import com.quang.springsecurityhibernate.user.User;
import com.quang.springsecurityhibernate.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


/*
* Để phục vụ demo, mỗi khi chạy chương trình, chúng ta cần insert một User vào database.

Có thể làm việc này bằng cách sử dụng CommandLineRunner. Một interface của Spring cung cấp, có tác dụng thực hiện một nhiệm vụ khi Spring khởi chạy lần đầu.
*
* */

@SpringBootApplication
public class SpringSecurityHibernateApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityHibernateApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Khi chương trình chạy
        // Insert vào csdl một user.
        User user = new User();
        user.setUsername("quang");
        user.setPassword(passwordEncoder.encode("1"));
        userRepository.save(user);
        System.out.println(user);
    }
}
