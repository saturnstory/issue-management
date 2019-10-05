package com.proton.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proton.issuemanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserName(String username);

	
	


}
