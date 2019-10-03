package com.proton.issuemanagement.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proton.issuemanagement.entity.IssueHistory;
import com.proton.issuemanagement.repository.IssueHistoryRepository;
import com.proton.issuemanagement.service.IssueHistoryService;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {
	
	private final IssueHistoryRepository issueHistoryRepository;
	
	public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
		this.issueHistoryRepository = issueHistoryRepository;
	}

	@Override
	public IssueHistory save(IssueHistory issueHistory) {
		
		if(issueHistory.getDate() == null) {
			throw new IllegalArgumentException("issue cannot be null");
		}
		
		issueHistory = issueHistoryRepository.save(issueHistory);
		return issueHistory;
	}

	@Override
	public IssueHistory getById(Long id) {
		return issueHistoryRepository.getOne(id);
	}

	@Override
	public Page<IssueHistory> getAllPageable(Pageable pageable) {
		return issueHistoryRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(IssueHistory issueHistory) {
		return null;
	}

}
