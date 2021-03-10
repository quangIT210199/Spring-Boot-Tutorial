package com.quang.springboot12;

import com.quang.springboot12.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//Ở bài này giới thiệu về「Spring Boot #12」 Spring JPA Method + @Query
//Để cải thiện hibernate, Spring Data đã wrapper lên hibernate tk được gọi là Spring JPA
//Để dễ dàng thao tác giữa tầng Ứng dụng và Database
@SpringBootApplication
public class SpringBoot12Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBoot12Application.class, args);

        //Quy tắc đặt tên method trong Spring JPA
        //find…By, read…By, query…By, count…By, và get…By.

        UserRepository userRepository = context.getBean(UserRepository.class);//Lấy Bean trong container
        System.out.println("Tìm user với Agi trong khoảng (25 - 30)");
        System.out.println("findAllByAgiBetween: ");

        userRepository.findAllByAgiBetween(25,30).forEach(System.out::println);

        System.out.println("===========================================");
        System.out.println("Tìm user với Agi trong lớn hơn 97");
        System.out.println("findAllByAgiGreaterThan: ");
        userRepository.findAllByAgiGreaterThan(97)
                .forEach(System.out::println);

        // Tìm kiếm tất cả theo Atk = 74
        System.out.println("===========================================");
        System.out.println("Tìm user với Atk = 74");
        System.out.println("findAllByAtk: ");
        userRepository.findAllByAtk(74)
                .forEach(System.out::println);

        System.out.println("===========================================");
        System.out.println("Tìm User với def = 49");
        System.out.println("SELECT u FROM User u WHERE u.def = :def");
        User user = userRepository.findUserByDefQuery(49);
        System.out.println("User: " + user);

        userRepository.findByHpOrderByStaminaAsc(12).forEach(System.out::println);
    }

}
