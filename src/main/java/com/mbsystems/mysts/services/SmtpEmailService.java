package com.mbsystems.mysts.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import com.mbsystems.mysts.domain.Pedido;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email...");
		mailSender.send(msg);
		LOG.info("Email enviado");
	}

	// @Override
//	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
	//	// TODO Auto-generated method stub

//	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de email...");
		javaMailSender.send(msg);
		LOG.info("Email evniado");
	}

}
