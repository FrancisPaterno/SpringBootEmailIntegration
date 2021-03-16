package com.example.EmailDemo;

import javax.validation.ValidationException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component("mailtrap")
public class FeedbackDAOImpl implements FeedbackDAO {

	private EmailCfg emailCfg;
	
	public FeedbackDAOImpl(EmailCfg emailCfg) {
		super();
		this.emailCfg = emailCfg;
	}

	@Override
	public void sendFeedback(Feedback feedback, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new ValidationException("Feedback is not valid");
		}
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(emailCfg.getHost());
		mailSender.setPort(emailCfg.getPort());
		mailSender.setUsername(emailCfg.getUsername());
		mailSender.setPassword(emailCfg.getPassword());
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(feedback.getEmail());
		mailMessage.setTo("rc@feedback.com");
		mailMessage.setSubject("New feedback from " + feedback.getName());
		mailMessage.setText(feedback.getFeedback());
		mailSender.send(mailMessage);
		System.out.println("Send message using mailtrap");
	}

}
