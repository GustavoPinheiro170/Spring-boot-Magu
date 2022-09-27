package br.com.magu.magu;

import com.mercadopago.MercadoPagoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class

})
public class MaguApplication {

	public static void main(String[] args) {
		MercadoPagoConfig.setAccessToken("TEST-1111532151519208-112707-af85addc21cb7eb4eaf4438217a2c95b-248275892");
		SpringApplication.run(MaguApplication.class, args);
	}

}
