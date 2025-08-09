package com.jothmart.todobackend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.jothmart.todobackend.entities.Todo;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(idCounter++,"jothmart", "description 1", new Date(),true));
        todos.add(new Todo(idCounter++,"jothmart", "description 2", new Date(),false));
        todos.add(new Todo(idCounter++,"jothmart", "description 3", new Date(),true));
        todos.add(new Todo(idCounter++,"jothmart", "description 4", new Date(),false));
    }

    public  List<Todo> getUserTodos(String username){
        return todos;
    }

    public  boolean deleteById(String username, Long todo_id){
        return this.todos.removeIf(obj -> obj.getId() == todo_id);
    }

    /* public Todo findById(Long todo_id){
        Optional<Todo> foundObjectOptional = this.todos.stream()
        .filter(obj -> obj.getId() == todo_id)
        .findFirst();
        if (foundObjectOptional.isPresent()) {
            Todo foundObject = foundObjectOptional.get();
            return foundObject;
        } 
        return null;
    } */

    public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		
		return null;
	}

}
