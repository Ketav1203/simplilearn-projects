package org.LearnersAcademy.service;

import org.LearnersAcademy.dao.UserDao;
import org.LearnersAcademy.dao.UserDaoImpl;
import org.LearnersAcademy.entities.User;

public class UserServiceImpl implements UserService{
	UserDao dao=new UserDaoImpl();
	@Override
	public void insert(User user) {
		dao.insert(user);
	}

	@Override
	public User get(String username, String password) {
		return dao.get(username, password);
	}

	@Override
	public void updatePassword(String username,String password,String newPassword) {
		User user=dao.get(username, newPassword);
		user.setPassword(newPassword);
		dao.update(user);
	}
	
}
