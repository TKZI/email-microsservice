package br.com.tkzi.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.tkzi.email.configuration.BrokerProperties;

@SpringBootApplication
@EnableConfigurationProperties(BrokerProperties.class)
public class EmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

}
