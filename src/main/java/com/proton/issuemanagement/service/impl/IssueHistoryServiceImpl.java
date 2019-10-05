package com.proton.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proton.issuemanagement.dto.IssueHistoryDto;
import com.proton.issuemanagement.entity.IssueHistory;
import com.proton.issuemanagement.repository.IssueHistoryRepository;
import com.proton.issuemanagement.service.IssueHistoryService;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {
	
	private final IssueHistoryRepository issueHistoryRepository;
	private final ModelMapper modelMapper;
	
	public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper) {
		this.issueHistoryRepository = issueHistoryRepository;
		this.modelMapper = modelMapper;
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
	
    @Override
    public List<IssueHistoryDto> getByIssueId(Long id) {
        return Arrays.asList(modelMapper.map(issueHistoryRepository.getByIssueIdOrderById(id), IssueHistoryDto[].class));
    }

}
