package com.proton.issuemanagement.dto;

import java.util.Date;

import com.proton.issuemanagement.entity.IssueStatus;

import lombok.Data;

@Data
public class IssueDto {
	
	private Long id;
	
	private String descripton;
	
	private String details;
	
	private Date date;
	
	private IssueStatus issueStatus;
	
	private UserDto assignee;
	
	private ProjectDto project;
	
	
	
}
