package com.fsd.springboottest.springboottest.controllers;

import com.fsd.springboottest.springboottest.entities.Product;
import com.fsd.springboottest.springboottest.entities.ToDo;
import com.fsd.springboottest.springboottest.services.ProductService;
import com.fsd.springboottest.springboottest.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/todo")
public class ToDoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTod(@PathVariable Long id){

        ToDo toDo =  todoService.getTodo(id);
        return new ResponseHandler().generateResponse("Todo Found ", HttpStatus.OK,toDo);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createTod(@RequestBody ToDo toDo){

        ToDo todNew =  todoService.createTodo(toDo);
        return new ResponseHandler().generateResponse("Todo created ", HttpStatus.CREATED,todNew);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateTodo( @RequestBody ToDo todo){

        ToDo toDoNew =  todoService.updateTodo(todo);
        return new ResponseHandler().generateResponse("Todo updated ", HttpStatus.OK,todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return new ResponseHandler().generateResponse("Product Deleted ", HttpStatus.OK,null);
    }

}
