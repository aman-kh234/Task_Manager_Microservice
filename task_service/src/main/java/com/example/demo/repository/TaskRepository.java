package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	public List<Task> findByAssignedUserId(Long userId); 
}
