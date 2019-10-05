package com.proton.issuemanagement.service.impl;

import com.proton.issuemanagement.dto.RegistrationRequest;
import com.proton.issuemanagement.dto.UserDto;
import com.proton.issuemanagement.entity.User;
import com.proton.issuemanagement.repository.UserRepository;
import com.proton.issuemanagement.service.UserService;
import com.proton.issuemanagement.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserServiceImpl(UserRepository userRepository,ModelMapper modelMapper,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDto save(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user = userRepository.save(user);
		userDto.setId(user.getId());
		return userDto;
	}

	@Override
	public UserDto getById(Long id) {
		User user =  userRepository.getOne(id);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public TPage<UserDto> getAllPageable(Pageable pageable) {
		Page<User> users = userRepository.findAll(pageable);
		TPage<UserDto> response = new TPage<UserDto>();
		response.setStat(users, Arrays.asList(modelMapper.map(users.getContent(), UserDto[].class)));
		return response;
	}

	@Override
	public UserDto getByUserName(String username) {
		User user = userRepository.findByUserName(username);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAll() {
		List<User> users = userRepository.findAll();
		return Arrays.asList(modelMapper.map(users, UserDto[].class));
	}
	
	
	@Transactional
    public Boolean register(RegistrationRequest registrationRequest) {
        try {
            User user = new User();
            user.setEmail(registrationRequest.getEmail());
            user.setNameSurname(registrationRequest.getNameSurname());
            user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            user.setUserName(registrationRequest.getUsername());
            userRepository.save(user);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("REGISTRATION=>", e);
            return Boolean.FALSE;
        }
        
        
    }
	
	


}
