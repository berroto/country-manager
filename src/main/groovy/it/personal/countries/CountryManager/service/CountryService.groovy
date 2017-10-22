package it.personal.countries.CountryManager.service

import it.personal.countries.CountryManager.domain.Country

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

interface CountryService {
	Page<Country> listAllByPage(Pageable pageable)
}