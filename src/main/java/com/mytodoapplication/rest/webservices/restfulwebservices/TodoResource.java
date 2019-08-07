package com.mytodoapplication.rest.webservices.restfulwebservices;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

	@Autowired
	private TodoHardCodedService todoHardCodedService;

	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoHardCodedService.findAll();
	}

	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodos(@PathVariable String username, @PathVariable long id) {
		return todoHardCodedService.findById(id);
	}

	@DeleteMapping("/users/{username}/todos/{todo_id}")
	public ResponseEntity<Void> deletoTodo(@PathVariable String username, @PathVariable("todo_id") long id) {
		Todo todo = todoHardCodedService.deleteById(id);
		if (todo != null) {
			return ResponseEntity.noContent().build();
		} else
			return ResponseEntity.notFound().build();
	}

	@PutMapping("/users/{username}/todos/{todo_id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable("todo_id") long id,
			@RequestBody Todo todo) {

		Todo todoUpdated = todoHardCodedService.save(todo);
		// return todoUpdated;
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable("username") String username, @RequestBody Todo todo) {

		Todo todoCreated = todoHardCodedService.save(todo);
		// return todoUpdated;

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoCreated.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
