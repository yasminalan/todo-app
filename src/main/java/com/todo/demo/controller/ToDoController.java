package com.todo.demo.controller;

import com.todo.demo.domain.ToDo;
import com.todo.demo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/:id")
    public ToDo getToDo(@PathVariable UUID id) {
        return toDoService.findToDoById(id);
    }

    @GetMapping
    public List<ToDo> getAllToDos() {
        List<ToDo> allToDos = toDoService.getAllToDos();
        return allToDos;
    }

    @PostMapping
    public String createToDo(@RequestBody ToDo toDo) {
        return toDoService.saveToDo(toDo);
    }

    @DeleteMapping("/{id}")
    public String deleteToDo(@PathVariable("id") UUID id) {
        return toDoService.deleteToDoById(id);
    }

    @PutMapping
    public String updateToDo() {
        return toDoService.updateToDo();
    }

}
