package com.proton.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proton.issuemanagement.dto.ProjectDto;
import com.proton.issuemanagement.entity.Project;
import com.proton.issuemanagement.repository.ProjectRepository;
import com.proton.issuemanagement.service.ProjectService;
import com.proton.issuemanagement.util.TPage;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository projectRepository;
	private final ModelMapper modelMapper;
	
	public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
		this.projectRepository = projectRepository;
		this.modelMapper = modelMapper;
	}
	
	
	@Override
	public ProjectDto save(ProjectDto project) {
		Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
		if(projectCheck != null) {
			throw new IllegalArgumentException("Project Code  Already Exists");
		}
		
		
		Project p = modelMapper.map(project, Project.class);
		p = projectRepository.save(p);
		project.setId(p.getId());
		return project;
	}

	@Override
	public ProjectDto getById(Long id) {
		Project project =  projectRepository.getOne(id);
		return modelMapper.map(project, ProjectDto.class);
	}

	@Override
	public ProjectDto getByProjectCode(String projectCode) {
		return null;
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		return null;
	}
	
	@Override
	public TPage<ProjectDto> getAllPageable(Pageable pageable) {
		Page<Project> data = projectRepository.findAll(pageable);
		TPage<ProjectDto> respnose = new TPage<ProjectDto>();
		respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
		return respnose;
	}

	@Override
	public Boolean delete(Long id) {
		projectRepository.deleteById(id);
		return true;
	}

	@Override
	public ProjectDto update(Long id, ProjectDto project) {
		Project projectDb = projectRepository.getOne(id);
		
		if(projectDb == null) {
			throw new IllegalArgumentException("Project Does Not Exist ID :"+ id);
		}
		
		
		Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);
		if(projectCheck != null) {
			throw new IllegalArgumentException("Project Code  Already Exists");
		}
		
		projectDb.setProjectCode(project.getProjectCode());
		projectDb.setProjectName(project.getProjectName());
		
		projectRepository.save(projectDb);
		
		return modelMapper.map(projectDb, ProjectDto.class);
		
		
	}

}
