package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CountryDto;
import com.example.demo.model.Country;

@Component
public class CountryMapper {

	public Country dtoToEntity(CountryDto countryDto) {
		Country country = new Country();
		if(countryDto != null) {
			BeanUtils.copyProperties(countryDto, country);
		}
		return country;
	}
	
	public CountryDto entityToDto(Country country) {
		CountryDto countryDto = new CountryDto();
		if(country != null) {
			BeanUtils.copyProperties(country, countryDto);
		}
		return countryDto;
	}
	
	public List<CountryDto> entityToDtoList(List<Country> cList){
		List<CountryDto> countryDtoList = new ArrayList<CountryDto>();
		cList.forEach((temp)->{
			CountryDto countryDto = new CountryDto();
			BeanUtils.copyProperties(temp, countryDto);
			countryDtoList.add(countryDto);
		});
		return countryDtoList;
	}
}
