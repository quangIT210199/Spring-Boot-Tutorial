package com.quang.springboot13.controller;

import com.quang.springboot13.model.Todo;
import com.quang.springboot13.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
//Nếu sử dụng @RestController hoặc @ReponseBody thì sẻ trả về text, thay vì view

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;
    /*
    @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
    Nó sẽ gán dữ liệu của param-name tương ứng vào biến
    * */
    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit){
        //Trả về đối tượng todoList
        model.addAttribute("todoList", todoService.findAll(limit));
        //trả về view
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model){
        //Truyền 1 đối tượng todo lên view để cho Form POST
        model.addAttribute("todo", new Todo());

        return "addTodo";
    }

    /*
    @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
    */
    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        return Optional.ofNullable(todoService.add(todo))
                .map(t -> "success") // Trả về success nếu save thành công
                .orElse("failed"); // Trả về failed nếu không thành công

    }
}
