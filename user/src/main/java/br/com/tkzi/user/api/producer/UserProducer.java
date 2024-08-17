package br.com.tkzi.user.api.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.tkzi.user.configuration.BrokerProperties;
import br.com.tkzi.user.domain.dto.EmailDto;
import br.com.tkzi.user.domain.model.User;

@Component
public class UserProducer {

	
	private final RabbitTemplate rabbitTemplate;
	private final BrokerProperties brokerProperties;
	
	
	private String routingKey;
	
	
	
	public UserProducer(RabbitTemplate rabbitTemplate, BrokerProperties brokerProperties) {
		this.rabbitTemplate = rabbitTemplate;
		this.brokerProperties = brokerProperties;
		this.routingKey = brokerProperties.getEmail().getName();
	}
	

	
	public void publishMessageEmail(User user) {
		var emailDto = new EmailDto();
		emailDto.setUserId(user.getUserId());
		emailDto.setEmailTo(user.getEmail());
		emailDto.setSubject("Cadastro realizado com sucesso!");
		emailDto.setText(user.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora");
		
		rabbitTemplate.convertAndSend("", routingKey, emailDto);
	}
	
	
	
}
