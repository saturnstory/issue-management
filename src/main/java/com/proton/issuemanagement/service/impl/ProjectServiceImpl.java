package com.proton.issuemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proton.issuemanagement.entity.Project;
import com.proton.issuemanagement.repository.ProjectRepository;
import com.proton.issuemanagement.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository projectRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	
	@Override
	public Project save(Project project) {
		if(project.getProjectCode()==null) {
			throw new IllegalArgumentException("Project code cannot be null !");
		}
		return projectRepository.save(project);
	}

	@Override
	public Project getById(Long id) {
		return projectRepository.getOne(id);
	}

	@Override
	public List<Project> getByProjectCode(String projectCode) {
		return null;
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		return null;
	}

	@Override
	public Page<Project> getAllPageable(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(Project project) {
		return null;
	}

}
