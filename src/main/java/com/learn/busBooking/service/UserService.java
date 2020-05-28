package com.learn.busBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.busBooking.dto.UserDto;
import com.learn.busBooking.exception.InvalidCredentials;
import com.learn.busBooking.exception.UserNotFoundException;
import com.learn.busBooking.model.User;
import com.learn.busBooking.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User getUser(UserDto userDto) throws UserNotFoundException {

		User user = userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
		if (user != null) {
			return user;
		} else {
			throw new InvalidCredentials("incorrect email or password");
		}

	}

	public User UpdateUser(User user) throws UserNotFoundException {
		if (user != null) {
			return userRepository.save(user);
		} else {
			throw new UserNotFoundException("user object should not be empty");
		}
	}
	
}
