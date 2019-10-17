package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	User saveUser(User user);

	User getUserById(Long id);

	List<User> getAllUser();

	User updateUser(User user);

	void deleteUser(User user);

}
