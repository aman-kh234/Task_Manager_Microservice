package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Task;
import com.example.demo.modal.TaskStatus;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskServiceImplementation implements TaskService{
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task createTask(Task task, String requesterRole) throws Exception {
		if(!requesterRole.equals("Admin"))
		{
			throw new Exception("Only Admin can create a task.");
		}
		
		task.setStatus(TaskStatus.PENDING);
		task.setCreatedAt(LocalDateTime.now());
		return taskRepository.save(task);
	}

	@Override
	public Task getTaskById(Long id) throws Exception {

		return taskRepository.findById(id).orElseThrow(()->new Exception("task not found with id "+id));
	}

	@Override
	public List<Task> getAllTask(TaskStatus status) {
		List<Task> allTask = taskRepository.findAll();
		
		List<Task> filteredTask = allTask.stream().filter(task->status==null || task.getStatus().name().equalsIgnoreCase(status.toString())).collect(Collectors.toList());
		return filteredTask;
	}

	@Override
	public Task updateTask(Long id, Task updatedTask, Long userId) throws Exception {
		Task existingTask = getTaskById(id);
		
		if(updatedTask.getTitle()!=null) {
			existingTask.setTitle(updatedTask.getTitle());
		}
		if(updatedTask.getDescription()!=null) {
			existingTask.setDescription(updatedTask.getDescription());
		}
		if(updatedTask.getImage()!=null) {
			existingTask.setImage(updatedTask.getImage());
		}
		if(updatedTask.getStatus()!=null) {
			existingTask.setStatus(updatedTask.getStatus());
		}
		if(updatedTask.getDeadLine()!=null) {
			existingTask.setDeadLine(updatedTask.getDeadLine());
		}
		
		return taskRepository.save(existingTask);
	}

	@Override
	public void deleteTask(Long id) throws Exception {
		 getTaskById(id);
		 taskRepository.deleteById(id);
	}

	@Override
	public Task assignedToUser(Long userId, Long taskId) throws Exception {
		Task task = getTaskById(taskId);
		task.setAssignedUserId(userId);
		task.setStatus(TaskStatus.DONE);
		return taskRepository.save(task);
	}

	@Override
	public List<Task> assignedUsersTask(Long userId, TaskStatus status) {
		List<Task> allTask = taskRepository.findByAssignedUserId(userId);
		List<Task> filteredTask = allTask.stream().filter(task->status==null || task.getStatus().name().equalsIgnoreCase(status.toString())).collect(Collectors.toList());
        
		return filteredTask;
	}

	@Override
	public Task completeTask(Long taskId) throws Exception {
		Task task = getTaskById(taskId);
		task.setStatus(TaskStatus.DONE);
		return taskRepository.save(task);
	}
	
}
