package com.proton.issuemanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proton.issuemanagement.dto.IssueDto;
import com.proton.issuemanagement.entity.Issue;
import com.proton.issuemanagement.util.TPage;

public interface IssueService {
	
	IssueDto save(IssueDto issue);
	
	IssueDto getById(Long id);
	
	TPage<IssueDto> getAllPageable(Pageable pageable);
	
	Boolean delete (Long id);
	
	IssueDto update(Long id, IssueDto issue);
}
