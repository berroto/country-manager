package it.personal.countries.CountryManager

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
class CountryManagerApplication extends SpringBootServletInitializer {

	static void main(String[] args) {
		SpringApplication.run CountryManagerApplication, args
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<CountryManagerApplication> applicationClass = CountryManagerApplication.class;
}
