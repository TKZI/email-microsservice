package br.com.tkzi.email.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.tkzi.email.enums.StatusEmail;
import br.com.tkzi.email.model.EmailModel;
import br.com.tkzi.email.repositores.EmailRepository;
import jakarta.transaction.Transactional;

@Service
public class EmailService {
	
	private final EmailRepository emailRepository;
	
	private final JavaMailSender emailSender;
	
	public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
		this.emailRepository = emailRepository;
		this.emailSender = emailSender;
	}

	@Value("${spring.mail.username}")
	private String emailFrom;
	
	@SuppressWarnings("finally")
	@Transactional
	public EmailModel sendEmail(EmailModel emailModel) {
		try {
			emailModel.setSendDateEmail(LocalDateTime.now());
			emailModel.setEmailFrom(emailFrom);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			emailSender.send(message);
			
			
			emailModel.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			emailModel.setStatusEmail(StatusEmail.ERROR);
		}finally {
			return emailRepository.save(emailModel);
		}
	}
	
}
