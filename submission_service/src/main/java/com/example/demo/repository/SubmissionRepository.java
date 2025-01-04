package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long>{
	List<Submission> findByTaskId(Long id);
}
