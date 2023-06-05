package com.kanna.todo.repo;

import com.kanna.todo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends JpaRepository<ToDoItem, Long> {
}
