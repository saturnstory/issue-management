package com.proton.issuemanagement.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proton.issuemanagement.dto.UserDto;
import com.proton.issuemanagement.service.impl.UserServiceImpl;
import com.proton.issuemanagement.util.ApiPaths;
import com.proton.issuemanagement.util.TPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.UsersCtrl.CTRL)

@Api(value=ApiPaths.UsersCtrl.CTRL, description = "Users API Endpoint")
public class UserController {
	private final UserServiceImpl userServiceImpl;
	
	public UserController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	
	@GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = UserDto.class)
    public ResponseEntity<TPage<UserDto>> getAllByPagination(Pageable pageable) {
        TPage<UserDto> data = userServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }
	
	@GetMapping()
    @ApiOperation(value = "Get All By Operation", response = UserDto.class)
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> data = userServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }
	
	
	@GetMapping("/{id}")
	@ApiOperation(value="Get By Id Operation", response=UserDto.class)
	public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) {
		UserDto userDto = userServiceImpl.getById(id);
		return ResponseEntity.ok(userDto);
	}
	
	@PostMapping()
	@ApiOperation(value="Create Operation", response=UserDto.class)
	public ResponseEntity<UserDto> createProject(@Valid @RequestBody UserDto userDto) {
		return ResponseEntity.ok(userServiceImpl.save(userDto));
	}	
}
