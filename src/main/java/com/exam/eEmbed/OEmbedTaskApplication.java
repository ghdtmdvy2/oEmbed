package com.exam.eEmbed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OEmbedTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(OEmbedTaskApplication.class, args);
	}

}
