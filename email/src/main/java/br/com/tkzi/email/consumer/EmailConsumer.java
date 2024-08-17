package br.com.tkzi.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.tkzi.email.dtos.EmailRecordDto;
import br.com.tkzi.email.model.EmailModel;
import br.com.tkzi.email.service.EmailService;

@Component
public class EmailConsumer {
	
	private final EmailService emailService;
	
	public EmailConsumer(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto) {
		var emailModel = new EmailModel();
		BeanUtils.copyProperties(emailRecordDto, emailModel);
		emailService.sendEmail(emailModel);
		
	}
	
	

}
