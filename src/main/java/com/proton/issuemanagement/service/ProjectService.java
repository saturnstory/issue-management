package com.proton.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.proton.issuemanagement.dto.ProjectDto;
import com.proton.issuemanagement.entity.Project;
import com.proton.issuemanagement.util.TPage;

public interface ProjectService {
	
	ProjectDto save(ProjectDto project);
	
	ProjectDto getById(Long id);
	
	ProjectDto getByProjectCode(String projectCode);
	
	List<Project> getByProjectCodeContains(String projectCode);
	
	TPage<ProjectDto> getAllPageable(Pageable pageable);
	
	Boolean delete(Long id);
	
	ProjectDto update (Long id, ProjectDto project);
	
}
