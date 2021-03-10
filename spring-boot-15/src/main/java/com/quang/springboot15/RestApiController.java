package com.quang.springboot15;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
    private List<Todo> todoList;

    @PostConstruct
    public void init(){
        todoList = IntStream.range(0, 10)
                .mapToObj(i -> new Todo("title-" + i, "detail" + i))
                .collect(Collectors.toList());
    }

    @GetMapping("/todo/{todoId}")
    public ResponseEntity<?> getTodo(@PathVariable(name = "todoId") Integer todoId){
        //@PathVariable lấy biến trong URl truyền request tới server
        return new ResponseEntity(todoList.get(todoId), HttpStatus.OK);
    }
}
