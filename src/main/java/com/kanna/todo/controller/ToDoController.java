package com.kanna.todo.controller;

import com.kanna.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService service;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", service.getAll());
        return modelAndView;
    }
}
