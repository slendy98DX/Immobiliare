package org.example.utility;

import org.example.entity.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Value("${spring.mail.username}")
	private String mailFrom;
	
	public void sendRegistrationEmail(Utente utente) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(mailFrom);
		simpleMailMessage.setReplyTo(mailFrom);
		simpleMailMessage.setSubject("Registration completed");
		simpleMailMessage.setText("Ciao " + utente.getUsername() + ", conferma la tua mail inserendo il codice: " + utente.getActivationCode());
		simpleMailMessage.setTo(utente.getEmail());
		javaMailSender.send(simpleMailMessage);
	}
	
}
