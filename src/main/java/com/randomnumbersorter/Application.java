package com.randomnumbersorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class to initialize Spring configurations using spring-boot
 * 
 * @author Raja Asthana
 * @since Dec-2017
 *
 */
@SpringBootApplication
public class Application {

	/**
	 * Spring boot Application starting point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
