package com.example.demo.service;

import java.util.List;

import com.example.demo.modal.Task;
import com.example.demo.modal.TaskStatus;

public interface TaskService {
	Task createTask(Task task, String requestedRole)throws Exception;
	
	Task getTaskById(Long id)throws Exception;
	
	List<Task> getAllTask(TaskStatus status);
	
	Task updateTask(Long id,Task updatedTask, Long userId) throws Exception;
	
	void deleteTask(Long id) throws Exception;
	
	Task assignedToUser(Long userId, Long taskId) throws Exception;
	
	List<Task> assignedUsersTask(Long userId, TaskStatus status);
	
	Task completeTask(Long taskId)throws Exception;
}
