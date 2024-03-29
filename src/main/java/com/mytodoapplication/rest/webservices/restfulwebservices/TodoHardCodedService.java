package com.mytodoapplication.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {

	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	static {
		todos.add(new Todo(++idCounter, "Nitish", "Complete Angular7 Course", false, new Date()));
		todos.add(new Todo(++idCounter, "Pankaj", "Complete Apcahe Bike Service", false, new Date()));
		todos.add(new Todo(++idCounter, "Ashish", "Complete Saturday Classes", false, new Date()));
		todos.add(new Todo(++idCounter, "Gaurav", "Complete Kolkata Trip", false, new Date()));
		

	} 

	public List<Todo> findAll() {

		return todos;
	}
	public Todo save(Todo todo)
	{
		if(todo.getId()==-1 ||todo.getId()==0 )
		{
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else
		{
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null)
			return null;
		if (todos.remove(todo)) {
			return todo;
		}
		return null;

	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
