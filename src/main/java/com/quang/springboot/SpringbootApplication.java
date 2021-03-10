package com.quang.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        //Applicationtext chính là containe, chứa toàn bộ các bean khi run chương trình
        ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);

        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.

        //Lấy Bean ra bằng cách
//        Vì interface k khởi tạo đc đối tượng, n chỉ lấy đc các thể hiện của nó là Bikini
        Outfit outfit = context.getBean(Outfit.class);
        System.out.println(outfit);
        //xài hàm wear
        outfit.wear();

        Girl girl = context.getBean(Girl.class); // Girl cũng là Bean dc đưa vào container

        System.out.println("Girl Instance: " + girl);

        System.out.println("Girl Outfit: " + girl.outfit); // vì đối tượng outfit được đưa vào container rồi nên dc gọi ra đây lần nữa
        girl.outfit.wear();

        // Kiểm tra 2 đối tượng
        System.out.println((girl.outfit == outfit));

        Test t = context.getBean(Test.class);
        t.he();
        System.out.println(t);

        Bikini bk = context.getBean(Bikini.class);
        System.out.println(bk);



    }

}
