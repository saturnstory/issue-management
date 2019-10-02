package com.proton.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proton.issuemanagement.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long>{

}
