package com.proton.issuemanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proton.issuemanagement.dto.ProjectDto;
import com.proton.issuemanagement.service.impl.ProjectServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/versioning")

@Api(value="/versioning", description = "Project APIs")
public class ProjectVersionedApi {
	
	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	@GetMapping(value = "/{id}", params="version=1")
	@ApiOperation(value="Get By Id Operation", response=ProjectDto.class)
	public ResponseEntity<ProjectDto> getByIdV1(@PathVariable("id") Long id) {
		ProjectDto projectDto = projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}
	
	@GetMapping(value = "/{id}",params="version=2")
	@ApiOperation(value="Get By Id Operation", response=ProjectDto.class)
	public ResponseEntity<ProjectDto> getByIdV2(@PathVariable("id") Long id) {
		ProjectDto projectDto = projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}
	
	

}
