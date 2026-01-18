package com.jothmart.todobackend.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.jothmart.todobackend.entity.Todo;
import com.jothmart.todobackend.service.TodoService;

@RestController
@RequestMapping("/api")
public class TodoResource {

@Autowired    
private TodoService todoService;

@GetMapping(path="/users/{username}/todos")
public List<Todo> getAllTodos(@PathVariable String username){
    return todoService.getUserTodos(username);
}

/* @DeleteMapping(path="/users/{username}/todos/{todo_id}")
public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable Long todo_id){
     if(todoService.deleteById(username, todo_id))
        return ResponseEntity.noContent().build();
     return ResponseEntity.notFound().build();
} */

//DELETE /users/{username}/todos/{id}
@DeleteMapping(path = "/users/{username}/todos/{todo_id}")
public ResponseEntity<Void> deleteTodo(
          @PathVariable String username, @PathVariable long todo_id){
     
     Todo todo = todoService.deleteById(todo_id);
     
     if(todo!=null) {
          return ResponseEntity.noContent().build();
     }
     
     return ResponseEntity.notFound().build();
}


@PutMapping(path="/users/{username}/todos/{todo_id}")
public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable Long todo_id,
        @RequestBody Todo todo){

     Todo updatedTodo = todoService.save(todo);
     return new ResponseEntity<Todo>(updatedTodo,HttpStatus.OK);
}


@PostMapping(path="/users/{username}/todos")
public ResponseEntity<Todo> saveTodo(@PathVariable String username, @RequestBody Todo todo){

     Todo createdTodo = todoService.save(todo);

     // Location
     // Get current resource uri
     // {id}

     URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

     return ResponseEntity.created(uri).build();
}

@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id){
		return todoService.findById(id);
	}

}
