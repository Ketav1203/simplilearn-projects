package org.LearnersAcademy.dao;

import org.LearnersAcademy.entities.User;

public interface UserDao {
	void insert(User user);
	User get(String username,String password);
	void update(User user);
}
