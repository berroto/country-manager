package it.personal.countries.CountryManager.dao

import org.springframework.data.repository.PagingAndSortingRepository
import it.personal.countries.CountryManager.domain.Country

interface CountryDao extends PagingAndSortingRepository<Country,Integer> {

}