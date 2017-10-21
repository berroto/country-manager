package it.personal.countries.CountryManager.bootstrap;

import it.personal.countries.CountryManager.domain.Country
import it.personal.countries.CountryManager.dao.CountryDao

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(Bootstrap.getClass());     

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("**** COUNTRY MANAGER APPLICATION STARTED ****")
    }
}