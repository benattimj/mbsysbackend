package com.mbsystems.mysts.services;

import org.springframework.mail.SimpleMailMessage;

import com.mbsystems.mysts.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msgl);
	
	
}
