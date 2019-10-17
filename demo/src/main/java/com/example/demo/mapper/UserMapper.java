package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CountryDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Country;
import com.example.demo.model.User;

@Component
public class UserMapper {
	
	public User dtoToEntity(UserDto userDto) {
		User user = new User();
		Country country = new Country();
		if(userDto != null) {
			BeanUtils.copyProperties(userDto.getCountry(), country);
			user.setCountry(country);
			BeanUtils.copyProperties(userDto, user);
		}
		return user;
	}
	
	public UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		CountryDto countryDto = new CountryDto();
		if(user != null) {
			BeanUtils.copyProperties(user.getCountry(), countryDto);
			userDto.setCountry(countryDto);
			BeanUtils.copyProperties(user, userDto);
		}
		return userDto;
	}
	
	public List<UserDto> entityToDtoList(List<User> userList){
		List<UserDto> userDtos = new ArrayList<UserDto>();
		userList.forEach((temp)->{
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(temp, userDto);
			userDtos.add(userDto);
		});
		return userDtos;
	}
}
