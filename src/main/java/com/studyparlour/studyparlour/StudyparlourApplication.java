package com.studyparlour.studyparlour;

import com.studyparlour.studyparlour.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class StudyparlourApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyparlourApplication.class, args);
	}

}
