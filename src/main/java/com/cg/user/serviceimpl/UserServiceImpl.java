package com.cg.user.serviceimpl;

import java.util.List;

import com.cg.user.dao.UserDAO;
import com.cg.user.daoImpl.UserDAOImpl;
import com.cg.user.domain.User;
import com.cg.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	public UserServiceImpl()
	{
		userDAO = new UserDAOImpl();
	}
	public void createUser(User user) {
		// TODO Auto-generated method stub

		userDAO.save(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

		userDAO.update(user);
	}

	public void removeUser(int id) {
		// TODO Auto-generated method stub
		userDAO.delete(id);

	}

	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userDAO.findall();
	}

}
