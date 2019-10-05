package com.proton.issuemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proton.issuemanagement.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long>{
	 List<IssueHistory> getByIssueIdOrderById(Long id);
}
