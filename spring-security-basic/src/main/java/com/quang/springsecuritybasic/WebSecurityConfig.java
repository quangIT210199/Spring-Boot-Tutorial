package com.quang.springsecuritybasic;

//Để kích hoạt tính năng Spring Security trên ƯD web, cần gắn annonation trên 1 bean bất kì

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService; //? @@
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//WebSecurityConfigurerAdapter, chúng ta override lại
// method protected void configure(HttpSecurity http) để thực hiện việc phân quyền.
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //Tạo user trong bộ nhớ
        //Cách này chỉ minh hoạt => còn thực tế ta phải ktra trong CSDL

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder() // sử dụng mã hóa password đơn giản
                    .username("quang")
                    .password("quang")
                    .roles("USER") // phân quyền
                    .build()
        );

        return manager;
    }
//WebSecurityConfigurerAdapter là một interface tiện ích
// của Spring Security giúp chúng ta cài đặt các thông tin dễ dàng hơn.

    //userDetailsService() có tác dụng cung cấp thông tin user cho Spring Security,
    // chúng ta Override lại method này và cung cấp cho nó một User là quang


    //Phân quyền truy cập
    //ở trong WebSecurityConfigurerAdapter,
    //override lại method protected void configure(HttpSecurity http) để thực hiện việc phân quyền
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/","/home").permitAll() // cho phép tất cả mn truy cập vào đ/c này
                    .anyRequest().authenticated()//Tất cả các request khác đều cần phải xác thực mới được truy cập
                    .and()
                .formLogin()// Cho phép người dùng xác thực bằng form login
                    .defaultSuccessUrl("/hello") // success thì vô /hello
                    .permitAll()// Tất cả đều được truy cập vào địa chỉ này
                    .and()
                .logout()// Cho phép logout
                    .permitAll();
    }
    //HttpSecurity là đối tượng chính của Spring Security cho phép cấu hình bảo mật
    //được xây dựng dưới design pattern giống với Builder Pattern, nên mọi cài đặt thông qua toán tử "."
    //Muốn cho phép xài method .permit() , còn cấm hoặc y/c xác thực thì authenticated

    /*
    * Khi gọi .formLogin() thì chúng ta cấu hình cho phép người dùng đăng nhập,
    * thông qua địa chỉ mặc định /login do Spring Security tự tạo ra
    * (Cái này có thể custom theo ý mình được, nhưng chúng ta sẽ tiếp cận ở bài sau).
    * */

    /*Tương tự .logout() cho phép người dùng logout, Nếu không nói gì thêm,
    Spring Security sẽ mặc định tự tạo ra một trang logout với địa chỉ /logout.
    * */
}
