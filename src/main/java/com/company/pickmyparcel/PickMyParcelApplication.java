package com.company.pickmyparcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PickMyParcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickMyParcelApplication.class, args);
		System.out.println("pick my parcel backend service has been started");
	}


}
