package com.quang.springboot12.repository;

import com.quang.springboot12.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    //Tra ve list, tim kiem theo atk
    List<User> findAllByAtk(int atk);

    List<User> findAllByAgiBetween(int start, int end);
    //Tim theo hp va ODER theo stamina
    List<User> findByHpOrderByStaminaAsc(int hp);

    //Khi su dung @Query thi ten method k con tac dung.
    //Với cách sử dụng @Query, bạn sẽ có thể sử dụng câu truy vấn JPQL (Hibernate) hoặc raw SQL.
    //Sử dụng ?1 ?2 là kiểu ?{number}
    //k thì dùng @Param
    @Query("SELECT u FROM User u WHERE u.def = :def")
    User findUserByDefQuery(@Param("def") Integer def);

    List<User> findAllByAgiGreaterThan(int agiThreshold);
}
