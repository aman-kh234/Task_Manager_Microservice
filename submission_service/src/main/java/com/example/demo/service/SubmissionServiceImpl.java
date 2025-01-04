package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Submission;
import com.example.demo.modal.TaskDto;
import com.example.demo.modal.UserDto;
import com.example.demo.repository.SubmissionRepository;

@Service
public class SubmissionServiceImpl implements SubmissionService{
	@Autowired
	private SubmissionRepository submissionRepo;
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	
	@Override
	public Submission submitTask(Long taskId, String githubLink, Long userId, String jwt) throws Exception {
		TaskDto task = taskService.getTaskById(taskId, jwt);
		if(task!=null) {
			Submission submission = new Submission();
			submission.setTaskId(taskId);
			submission.setUserId(userId);
			submission.setGithubLink(githubLink);
			submission.setSubmissionTime(LocalDateTime.now());
			return submissionRepo.save(submission);
		}

		throw new Exception("Task not found with id : "+taskId);
	}

	@Override
	public Submission getTaskSubmissionById(Long SubmissionId) throws Exception {
		return submissionRepo.findById(SubmissionId).orElseThrow(()->new Exception("Task Submission not found with id "+SubmissionId));
	}

	@Override
	public List<Submission> getAllTaskSubmission() {
		
		return submissionRepo.findAll();
	}

	@Override
	public List<Submission> getTaskSubmissionByTaskId(Long taskId) {
		return submissionRepo.findByTaskId(taskId);
	}

	@Override
	public Submission acceptDeclineSubmission(Long id,String status) throws Exception {
		Submission submission = getTaskSubmissionById(id);
		submission.setStatus(status);
		if(status.equals("ACCEPT"))
		taskService.completeTask(submission.getTaskId());
		
		return submissionRepo.save(submission);
	}
	
	
}
