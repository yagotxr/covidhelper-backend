package com.ferry.covidhelper;

import com.ferry.covidhelper.properties.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class CovidhelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidhelperApplication.class, args);
	}

}
