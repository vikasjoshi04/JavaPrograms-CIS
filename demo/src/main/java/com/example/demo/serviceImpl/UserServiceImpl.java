package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> uOptional = userRepository.findById(id);
		return uOptional.isPresent() ? uOptional.get() : null;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {

		userRepository.delete(user);

	}

}
