package it.personal.countries.CountryManager.web

import it.personal.countries.CountryManager.domain.Country
import it.personal.countries.CountryManager.dao.CountryDao
import it.personal.countries.CountryManager.service.CountryService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.ui.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
class CountryController {
	
    @Autowired
	final CountryService countryService

    @Autowired
    final CountryDao countryDao

    private final Logger log = LoggerFactory.getLogger(this.getClass());    
    
	@RequestMapping(value="/countries")
	public String list( Pageable pageable, Model model){
        log.info("getting list of country")
       
		Page<Country> countries = countryService.listAllByPage(pageable)
         model.put("countries", countries)
		"countries"
	}

    @RequestMapping(value="/api/countries",method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Page<Country> list( Pageable pageable){
        log.info("getting list of country")

        Page<Country> countries = countryService.listAllByPage(pageable)
        countries
    }
}