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
class ExternalServiceImpl implements ExternalService {
    
    @Autowired
	final CountryDao countryDao
	
    @Autowired
	final CurrencyDao currencyDao
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());    

    @Override
	void feedData()
    {
        Country country        
        Set<Currency> currencies
        Currency currency
        String textResponse;

        try{
            log.info "calling https://restcountries.eu/rest/v2/all..."
            textResponse = new URL("https://restcountries.eu/rest/v2/all")
            .getText("UTF-8")
        }catch (all)
        {
            log.warn "service not available", all
        }

        def jsonSlurper = new JsonSlurper() 
        def jsonParsed = jsonSlurper.parseText(textResponse)

        jsonParsed.each { c ->
            try{
                currencies = []
                c.currencies.each { curr ->
                    log.info("finding ${curr.code} (${curr.name}) for country ${c.name}")
                    if ( curr.name == null || curr.code == "(none)")
                    {
                        return;
                    }
                    currency = currencyDao.findByCode(curr.code)
                    if ( !currency)
                    {
                        log.info("not found, create it!")
                        currency = new Currency(
                            code: curr.code,
                            name: curr.name
                        )
                        currencyDao.save(currency)
                    }
                    log.info("Adding currency: ${currency}")
                    currencies.add (currency)
                }				
                country = new Country (name: c.name, currencies: currencies);
                log.info("Creating country: ${country}")
                country = countryDao.save(country)                
                
            } catch (all)
            {
                log.warn("error in saving country ${country}", all)
            }
        }
    }
}