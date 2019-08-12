package com.thiagobrito.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService{

	@Autowired
	private MailSender mailsender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final Logger LOG  = org.slf4j.LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		
		LOG.info("Enviando email...");
		mailsender.send(msg);
		LOG.info("Email enviado");
		
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		
		LOG.info("Enviando email...");
		javaMailSender.send(msg);
		LOG.info("Email enviado");
	}

}
