package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JsonObjectHelper;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@PostMapping(value="/adduser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<JsonObjectHelper> addCustomer(@RequestBody UserDto userDto){
		JsonObjectHelper jsObjectHelper = new JsonObjectHelper(true, "Failure");
		HttpStatus status = HttpStatus.BAD_REQUEST;
		User user = userMapper.dtoToEntity(userDto);
		if(user != null) {
			jsObjectHelper = new JsonObjectHelper(false, "User Saved Success",userMapper.entityToDto(user));
			status = HttpStatus.OK;
		}
		
		return new ResponseEntity<>(jsObjectHelper,status);
	}
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<JsonObjectHelper> getuserById(@PathVariable("id") Long id){
		JsonObjectHelper jsObjectHelper = new JsonObjectHelper(true, "Failure");
		HttpStatus status = HttpStatus.BAD_REQUEST;
		User user = userService.getUserById(id);
		if(user != null) {
			jsObjectHelper = new JsonObjectHelper(false, "User Saved Success",userMapper.entityToDto(user));
			status = HttpStatus.OK;
		}
		
		return new ResponseEntity<>(jsObjectHelper,status);
	}
	
}
