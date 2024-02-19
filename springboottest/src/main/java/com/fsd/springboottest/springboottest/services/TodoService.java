package com.fsd.springboottest.springboottest.services;

import com.fsd.springboottest.springboottest.entities.Product;
import com.fsd.springboottest.springboottest.entities.ToDo;
import com.fsd.springboottest.springboottest.exections.EntitynotFoundException;
import com.fsd.springboottest.springboottest.respositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<ToDo> getAll(){
        return  todoRepository.findAll();
    }

    public ToDo getTodo(Long id){
        Optional<ToDo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            return optionalTodo.get();
        }
        throw new EntitynotFoundException("Product with given id not found");
    }

    public ToDo createTodo(ToDo toDo){
        ToDo newToDo = todoRepository.save(toDo);
        return newToDo;
    }

    public ToDo updateTodo(ToDo updatedTodo){
        Optional<ToDo> optionalToDo = todoRepository.findById(updatedTodo.getId());
        ToDo newToDo = optionalToDo.get();
        newToDo.setTitle(updatedTodo.getTitle());
        newToDo.setDescription(updatedTodo.getDescription());
        newToDo.setStatus(updatedTodo.getStatus());
        newToDo.setId(updatedTodo.getId());
        if(optionalToDo.isPresent()){
            todoRepository.save(newToDo);
            return newToDo;
        }
        throw new EntitynotFoundException("Product with given id not found");
    }

    public void deleteTodo(Long id){
        Optional<ToDo> optionalToDo = todoRepository.findById(id);
        if(optionalToDo.isPresent()){
            todoRepository.delete(optionalToDo.get());
        }
        throw new EntitynotFoundException("Product with given id not found");
    }
}
