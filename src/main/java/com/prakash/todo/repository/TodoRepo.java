package com.prakash.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prakash.todo.entity.TodoItem;

@Repository
public interface TodoRepo extends JpaRepository<TodoItem, Long> {
	

}
