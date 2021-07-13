package com.cg.user.dao;

import java.util.List;

import com.cg.user.domain.User;

public interface UserDAO {

	
	public void save(User user);
	
	public void update(User user);
	
	public void delete(int id);
	
	public List<User> findall();
	
}
