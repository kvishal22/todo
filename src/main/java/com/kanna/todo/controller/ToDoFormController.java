package com.kanna.todo.controller;

import com.kanna.todo.model.ToDoItem;
import com.kanna.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ToDoFormController {

    private final ToDoService service;

    @GetMapping("/create-todo")
    public String todoForm(ToDoItem toDoItem){
        return  "new-todo-item";
    }
    @PostMapping("/todo")
    public String addTodo(ToDoItem toDoItem, BindingResult result,Model model){
        ToDoItem toDoItem1 = new ToDoItem();
        toDoItem1.setDescription(toDoItem.getDescription());
        toDoItem1.setIsComplete(toDoItem.getIsComplete());
        service.save(toDoItem1);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        ToDoItem toDoItem = service
                .getById(id)
                .orElseThrow(() ->new IllegalArgumentException("ToDoItem id:" + id +"not found"));
        service.delete(toDoItem);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        ToDoItem toDoItem = service
                .getById(id)
                .orElseThrow(() ->new IllegalArgumentException("ToDoItem id:" + id +"not found"));
        model.addAttribute("todo", toDoItem);
        return "edit-todo-item";
    }
    @PostMapping("/todo/{id}")
    public String update(@PathVariable Long id, ToDoItem toDoItem, BindingResult result, Model model){
        ToDoItem toDoItem1 = service
                .getById(id)
                .orElseThrow(() ->new IllegalArgumentException("ToDoItem id:" + id +"not found"));
        toDoItem1.setIsComplete(toDoItem.getIsComplete());
        toDoItem1.setDescription(toDoItem.getDescription());
        service.save(toDoItem1);
        return "redirect:/";
    }
}
