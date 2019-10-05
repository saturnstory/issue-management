package com.proton.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proton.issuemanagement.dto.IssueDetailDto;
import com.proton.issuemanagement.dto.IssueDto;
import com.proton.issuemanagement.dto.IssueHistoryDto;
import com.proton.issuemanagement.entity.Issue;
import com.proton.issuemanagement.repository.IssueRepository;
import com.proton.issuemanagement.repository.ProjectRepository;
import com.proton.issuemanagement.repository.UserRepository;
import com.proton.issuemanagement.service.IssueHistoryService;
import com.proton.issuemanagement.service.IssueService;
import com.proton.issuemanagement.util.TPage;

@Service
public class IssueServiceImpl implements IssueService {

	private final IssueRepository issueRepository;
	private final UserRepository userRepository;
	private final ProjectRepository projectRepository;
	private final IssueHistoryService issueHistoryService;
	private final ModelMapper modelMapper;

	public IssueServiceImpl(IssueRepository issueRepository, ProjectRepository projectRepository,
			UserRepository userRepository, IssueHistoryService issueHistoryService, ModelMapper modelMapper) {
		this.issueRepository = issueRepository;
		this.modelMapper = modelMapper;
		this.issueHistoryService = issueHistoryService;
		this.userRepository = userRepository;
		this.projectRepository = projectRepository;
	}

	@Override
	public IssueDto save(IssueDto issue) {
		if (issue.getDate() == null) {
			throw new IllegalArgumentException("Issue Date connot be null");
		}

		Issue issueDb = modelMapper.map(issue, Issue.class);
		issueDb = issueRepository.save(issueDb);
		return modelMapper.map(issueDb, IssueDto.class);
	}

	@Override
	public IssueDto getById(Long id) {
		Issue issue = issueRepository.getOne(id);
		return modelMapper.map(issue, IssueDto.class);
	}

	public IssueDetailDto getByIdWithDetails(Long id) {
		Issue issue = issueRepository.getOne(id);
		IssueDetailDto detailDto = modelMapper.map(issue, IssueDetailDto.class);
		List<IssueHistoryDto> issueHistoryDtos = issueHistoryService.getByIssueId(issue.getId());
		detailDto.setIssueHistories(issueHistoryDtos);
		return detailDto;	
	}

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> data = issueRepository.findAll(pageable);
		TPage page = new TPage<IssueDto>();
		IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
		page.setStat(data, Arrays.asList(dtos));
		return page;
	}

	@Override
	public Boolean delete(Long id) {
		issueRepository.deleteById(id);
		return true;
	}

	@Override
	public IssueDto update(Long id, IssueDto issue) {

		return null;
	}

}
