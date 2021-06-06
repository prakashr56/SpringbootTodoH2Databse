package com.prakash.todo.controller;

import java.util.List;
import java.util.Optional;

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

import com.prakash.todo.entity.TodoItem;
import com.prakash.todo.repository.TodoRepo;

@RestController
@RequestMapping("/todo")
public class TodoController
{
	
	@Autowired
	TodoRepo todoRepo;
	
	@PostMapping("/add")
	public ResponseEntity<TodoItem> save(@RequestBody TodoItem todoItem)
	{
		try 
		{
			return new ResponseEntity<>(todoRepo.save(todoItem), HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@PutMapping("/update")
	public ResponseEntity<TodoItem> updateCustomer(@RequestBody TodoItem todoItem) 
	{
		try
		{
			return new ResponseEntity<>(todoRepo.save(todoItem), HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		try
		{
			Optional<TodoItem> todo = todoRepo.findById(id);
			if (todo.isPresent())
			{
				todoRepo.delete(todo.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<TodoItem>> getAllTodo() {
		try 
		{
			List<TodoItem> todoList = todoRepo.findAll();
			if (todoList.isEmpty() || todoList.size() == 0)
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(todoList, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TodoItem> getAllTodoById(@PathVariable Long id) 
	{
		try 
		{
			Optional<TodoItem> todoList = todoRepo.findById(id);
			
			if (todoList.isPresent())
			{
				return new ResponseEntity<>(todoList.get() , HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return null;
	}
}
