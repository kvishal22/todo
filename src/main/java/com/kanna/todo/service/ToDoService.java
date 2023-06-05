package com.kanna.todo.service;

import com.kanna.todo.model.ToDoItem;
import com.kanna.todo.repo.ToDoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepo repo;

    public Iterable<ToDoItem> getAll(){
        return  repo.findAll();
    }
    public Optional<ToDoItem> getById(Long id){
        return repo.findById(id);
    }
    public ToDoItem save(ToDoItem toDoItem){
        if(toDoItem.getId() == null){
            toDoItem.setCreatedAt(Instant.now());
        }
        toDoItem.setUpdatedAt(Instant.now());
        return repo.save(toDoItem);
    }
    public void delete(ToDoItem toDoItem){
        repo.delete(toDoItem);
    }
}
