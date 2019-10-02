package com.proton.issuemanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proton.issuemanagement.entity.User;
import com.proton.issuemanagement.repository.UserRepository;
import com.proton.issuemanagement.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		//Bussiness logic
		if(user.getEmail()==null) {
			throw new IllegalArgumentException("Username cannot be null");
		}
		
		user = userRepository.save(user);
		return user;
	}

	@Override
	public User getById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public Page<User> getAllPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public User getByUserName(String username) {
		return null;
		//return userRepository.findByUserName(username);
	}

}
