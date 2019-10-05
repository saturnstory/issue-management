package com.proton.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proton.issuemanagement.dto.IssueHistoryDto;
import com.proton.issuemanagement.entity.IssueHistory;

public interface IssueHistoryService {
	
	IssueHistory save(IssueHistory issueHistory);
	
	IssueHistory getById(Long id);
	
	Page<IssueHistory> getAllPageable(Pageable pageable);
	
	Boolean delete (IssueHistory issueHistory);
	
	List<IssueHistoryDto> getByIssueId(Long id);
	
	
}
