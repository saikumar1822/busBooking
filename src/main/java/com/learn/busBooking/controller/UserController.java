package com.learn.busBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.busBooking.dto.ResponseDto;
import com.learn.busBooking.dto.UserDto;
import com.learn.busBooking.exception.UserNotFoundException;
import com.learn.busBooking.model.User;
import com.learn.busBooking.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<ResponseDto> userLogin(@RequestBody UserDto userDto) throws UserNotFoundException {
		User user = new User();
		ResponseDto loginResponseDto = new ResponseDto();
		user = userService.getUser(userDto);
		user.setActivated(true);
		userService.UpdateUser(user);
		loginResponseDto.setMessage("logged in successfully");
		return new ResponseEntity<ResponseDto>(loginResponseDto, HttpStatus.OK);
	}

}
