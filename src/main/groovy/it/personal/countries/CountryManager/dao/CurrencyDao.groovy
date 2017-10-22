package it.personal.countries.CountryManager.dao

import org.springframework.data.repository.CrudRepository;
import it.personal.countries.CountryManager.domain.Currency

interface CurrencyDao extends CrudRepository<Currency,Integer> {
    Currency findByName(String name);
    Currency findByCode(String code);
}