package com.todo.demo.service;

import com.todo.demo.domain.ToDo;
import com.todo.demo.repository.ToDoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public ToDo findToDoById(UUID id) {
        return  toDoRepository
                .findById(id)
                .orElse(null);
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public String saveToDo(ToDo toDo) {
        toDoRepository.save(toDo);
        return "ToDo is created successfully!";
    }

    public String deleteToDoById(UUID id) {
        toDoRepository.deleteById(id);
        return "ToDo is deleted successfully!";
    }

    public String updateToDoById(UUID id, boolean completed) {
        Optional<ToDo> toDoOptional = toDoRepository.findById(id);
        if(toDoOptional.isPresent()){
            ToDo todo = toDoOptional.get();
            todo.setCompleted(completed);
            toDoRepository.save(todo);
        }
        return "ToDo is updated successfully.";
    }
}
