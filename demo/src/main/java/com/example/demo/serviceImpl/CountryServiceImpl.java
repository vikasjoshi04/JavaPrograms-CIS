package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public Country saveCounty(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country getCountryById(Long id) {
		Optional<Country> cOptional = countryRepository.findById(id);
		return cOptional.isPresent() ? cOptional.get() : null;
	}

	@Override
	public List<Country> getAllCountry() {
		return countryRepository.findAll();
	}

	@Override
	public Country updateCountry(Country country) {
		
		return countryRepository.save(country);
	}

	@Override
	public void deleteCountry(Country country) {
		
		countryRepository.delete(country);
	}

}
