package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Country;

public interface CountryService {

	Country saveCounty(Country country);

	Country getCountryById(Long id);

	List<Country> getAllCountry();

	Country updateCountry(Country country);

	void deleteCountry(Country country);

}
