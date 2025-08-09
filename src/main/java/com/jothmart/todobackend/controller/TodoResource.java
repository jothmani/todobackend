package com.jothmart.todobackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.jothmart.todobackend.entities.Todo;
import com.jothmart.todobackend.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from this origin
// @RequestMapping("/api")
public class TodoResource {

@Autowired    
private TodoService todoService;

@GetMapping(path="/users/{username}/todos")
public List<Todo> getAllTodos(@PathVariable String username){
    return todoService.getUserTodos(username);
}

@DeleteMapping(path="/users/{username}/todos/{todo_id}")
public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable Long todo_id){
     if(todoService.deleteById(username, todo_id))
        return ResponseEntity.noContent().build();
     return ResponseEntity.notFound().build();
}


@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id){
		return todoService.findById(id);
	}

}
