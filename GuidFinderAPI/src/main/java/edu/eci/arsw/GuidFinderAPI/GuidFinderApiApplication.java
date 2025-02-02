package edu.eci.arsw.GuidFinderAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class GuidFinderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuidFinderApiApplication.class, args);
	}
	
}
