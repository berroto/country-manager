package it.personal.countries.CountryManager.service

import it.personal.countries.CountryManager.domain.Country
import it.personal.countries.CountryManager.domain.Currency
import it.personal.countries.CountryManager.dao.CountryDao
import it.personal.countries.CountryManager.dao.CurrencyDao

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import groovy.json.JsonSlurper
import java.net.URL

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
class CountryServiceImpl implements CountryService {

    @Autowired
	final ExternalService externalService

	@Autowired
	final CountryDao countryDao
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());    

	@Override
	Page<Country> listAllByPage(Pageable pageable) {
		int count = countryDao.count();
        if ( count <= 0)
        {
            log.info "Database is empty, calling the Exxternal Service"
			externalService.feedData()
        }

		return countryDao.findAll(pageable)
	}
}