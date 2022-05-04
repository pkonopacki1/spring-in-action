package com.konopackipio1.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//-----Entry point class-----//

// Very important annotation combining @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan
@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

}
