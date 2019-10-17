package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JsonObjectHelper;
import com.example.demo.dto.CountryDto;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.model.Country;
import com.example.demo.service.CountryService;

@RestController
@RequestMapping("/")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	CountryMapper countryMapper;
	
	@PostMapping(value = "/addcountry")
	public ResponseEntity<JsonObjectHelper> saveCountry(@RequestBody CountryDto countryDto){
		JsonObjectHelper jsonObjectHelper = new JsonObjectHelper(true, "Country Not Added");
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Country country = countryService.saveCounty(countryMapper.dtoToEntity(countryDto));
		if(country != null) {
			jsonObjectHelper = new JsonObjectHelper(false, "Country Added Successfully", countryMapper.entityToDto(country));
			status = HttpStatus.OK;
		}
		
		return new ResponseEntity<>(jsonObjectHelper, status);
	}

}
