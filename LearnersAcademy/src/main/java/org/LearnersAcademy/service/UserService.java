package org.LearnersAcademy.service;

import org.LearnersAcademy.entities.User;

public interface UserService {
	void insert(User user);

	User get(String username, String password);
	void updatePassword(String username,String password,String newPassword);
}
