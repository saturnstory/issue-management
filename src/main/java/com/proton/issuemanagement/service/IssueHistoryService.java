package com.proton.issuemanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proton.issuemanagement.entity.IssueHistory;

public interface IssueHistoryService {
	
	IssueHistory save(IssueHistory issueHistory);
	
	IssueHistory getById(Long id);
	
	Page<IssueHistory> getAllPageable(Pageable pageable);
	
	Boolean delete (IssueHistory issueHistory);
}
