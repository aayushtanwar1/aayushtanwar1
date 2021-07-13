package com.cg.user.service;

import java.util.List;

import com.cg.user.domain.User;

public interface UserService {

	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public void removeUser(int id);
	
	public List<User> listUser();
}
