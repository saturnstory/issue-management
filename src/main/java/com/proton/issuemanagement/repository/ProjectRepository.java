package com.proton.issuemanagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proton.issuemanagement.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	Project getByProjectCode(String projectCode);
	
	Project getByProjectCodeAndIdNot(String projectCode, Long id);
	
	List<Project> getByProjectCodeContains(String projectCode);
	
	Page<Project> findAll(Pageable pageable);
	
	List<Project> findAll(Sort sort);
	
	
	
}
