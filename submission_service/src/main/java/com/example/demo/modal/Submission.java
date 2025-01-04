package com.example.demo.modal;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Submission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long taskId;
	
	private String githubLink;
	
	private Long userId;
	
	private String status="PENDING";
	
	private LocalDateTime submissionTime;
	
	
	
	public Submission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Submission(Long id, Long taskId, String githubLink, Long userId, String status,
			LocalDateTime submissionTime) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.githubLink = githubLink;
		this.userId = userId;
		this.status = status;
		this.submissionTime = submissionTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(LocalDateTime submissionTime) {
		this.submissionTime = submissionTime;
	}
	
	
}
