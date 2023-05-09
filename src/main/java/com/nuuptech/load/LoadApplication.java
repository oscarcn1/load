package com.nuuptech.load;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:/config/application.properties")
public class LoadApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadApplication.class, args);
	}

}
