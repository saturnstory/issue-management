package com.proton.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.proton.issuemanagement.dto.UserDto;
import com.proton.issuemanagement.util.TPage;

public interface UserService {
	
	UserDto save(UserDto userDto);
	
	UserDto getById(Long id);
	
	TPage<UserDto> getAllPageable(Pageable pageable);
	
	UserDto getByUserName(String username);
	
	List<UserDto> getAll();
	
	
}
