package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Task;
import com.example.demo.modal.TaskStatus;
import com.example.demo.modal.UserDto;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;

@RestController
public class HomeController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public ResponseEntity<String> getAssignedUsersTask() throws Exception{
		
		return new ResponseEntity<>("Welcome to task service",HttpStatus.OK);
	}
}
