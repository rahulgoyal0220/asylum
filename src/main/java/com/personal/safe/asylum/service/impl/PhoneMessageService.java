package com.personal.safe.asylum.service.impl;

import org.springframework.stereotype.Component;

import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.creator.api.v2010.account.MessageCreator;
import com.twilio.sdk.exception.TwilioException;
import com.twilio.sdk.type.PhoneNumber;

@Component
public class PhoneMessageService {

	public static final String ACCOUNT_SID = "ACCOUNT_SID";
	public static final String AUTH_TOKEN = "AUTH_TOKEN";
	public static final String TWILIO_NUMBER = "+15796000867";

	public void sendSMS(String to, String body) {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		MessageCreator messageCreator = new MessageCreator(ACCOUNT_SID, new PhoneNumber(to),
				new PhoneNumber(TWILIO_NUMBER), body);
		try {
			messageCreator.execute(client);
		} catch (TwilioException e) {

		}
	}
}
