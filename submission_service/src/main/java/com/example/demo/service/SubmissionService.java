package com.example.demo.service;

import java.util.List;

import com.example.demo.modal.Submission;

public interface SubmissionService {
	 Submission submitTask(Long taskId,String githubLink,Long userId,String jwt)throws Exception;
	 
	 Submission getTaskSubmissionById(Long SubmissionId) throws Exception;
	 
	 List<Submission> getAllTaskSubmission();
	 
	 List<Submission> getTaskSubmissionByTaskId(Long taskId);
	 
	 Submission acceptDeclineSubmission(Long is,String status) throws Exception;
}
