package com.proton.issuemanagement.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proton.issuemanagement.dto.IssueDetailDto;
import com.proton.issuemanagement.dto.IssueDto;
import com.proton.issuemanagement.service.impl.IssueServiceImpl;
import com.proton.issuemanagement.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)

@Api(value = ApiPaths.IssueCtrl.CTRL, description = "Issue API Test")
public class IssueController {
	private final IssueServiceImpl issueServiceImpl;

	public IssueController(IssueServiceImpl issueServiceImpl) {
		this.issueServiceImpl = issueServiceImpl;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id) {
		IssueDto issueDto = issueServiceImpl.getById(id);
		return ResponseEntity.ok(issueDto);
	}

	@PostMapping()
	@ApiOperation(value = "Create Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue) {
		return ResponseEntity.ok(issueServiceImpl.save(issue));
	}

	@GetMapping("/detail/{id}")
	@ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
	public ResponseEntity<IssueDetailDto> getByIdWithDetails(@PathVariable(value = "id", required = true) Long id) {
		IssueDetailDto detailDto = issueServiceImpl.getByIdWithDetails(id);
		return ResponseEntity.ok(detailDto);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id,
			@Valid @RequestBody IssueDto issue) {
		return ResponseEntity.ok(issueServiceImpl.update(id, issue));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Operation", response = Boolean.class)
	public ResponseEntity<Boolean> projectDelete(@PathVariable(value = "id", required = true) Long id) {
		return ResponseEntity.ok(issueServiceImpl.delete(id));
	}

}
