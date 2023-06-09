package com.services;

import java.util.List;

import com.model.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUser();

	User getUser(String userId);
	
	
}
