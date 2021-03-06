package it.personal.countries.CountryManager.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.ManyToOne
import javax.persistence.ManyToMany

import javax.persistence.Column;
import javax.persistence.FetchType;
import groovy.transform.ToString 
import javax.persistence.CascadeType

@Entity
@ToString
class Currency {
	@Id @GeneratedValue
	Long id

	@Column(unique = true)
	String code
	
	@Column
    String name
}