package com.kanna.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDoItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private Boolean isComplete;
    private Instant createdAt;
    private Instant updatedAt;



}
