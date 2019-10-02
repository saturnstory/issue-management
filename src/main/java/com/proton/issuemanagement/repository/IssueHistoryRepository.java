package com.proton.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proton.issuemanagement.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long>{

}
