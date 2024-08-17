package br.com.tkzi.email.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Configuration
public class RabbitMQConfig {
	
	@Autowired
	private BrokerProperties brokerProperties;
	
	
	private String queue;
	
	@PostConstruct
	public void init() {
		queue = brokerProperties.getEmail().getName();
	}
	
	@Bean
	public Queue queue() {
		return new Queue(queue, true);
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
		return new Jackson2JsonMessageConverter(objectMapper);
	}

}
