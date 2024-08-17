package br.com.tkzi.email.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "broker.queue")
public class BrokerProperties {

	
	private Email email = new Email();
	
	@Getter
	@Setter
	public static class Email{
		private String name;
	}
}
