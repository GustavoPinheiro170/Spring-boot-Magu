package br.com.magu.magu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MaguApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaguApplication.class, args);
	}

}
