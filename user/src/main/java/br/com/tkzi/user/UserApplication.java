package br.com.tkzi.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.tkzi.user.configuration.BrokerProperties;

@SpringBootApplication
@EnableConfigurationProperties(BrokerProperties.class)
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
