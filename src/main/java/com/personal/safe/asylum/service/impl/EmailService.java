package com.personal.safe.asylum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void prepareAndSend(String recipient, String message) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom("rahulgoyal0220@gmail.com");
			messageHelper.setTo(recipient);
			messageHelper.setSubject("Sample mail subject");
			messageHelper.setText(message);
		};
		try {
			mailSender.send(messagePreparator);
		} catch (MailException e) {
			// runtime exception; compiler will not force you to handle it
		}
	}
}
