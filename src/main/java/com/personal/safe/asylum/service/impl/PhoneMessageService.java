package com.personal.safe.asylum.service.impl;

import org.springframework.stereotype.Component;

import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.creator.api.v2010.account.MessageCreator;
import com.twilio.sdk.exception.TwilioException;
import com.twilio.sdk.type.PhoneNumber;

@Component
public class PhoneMessageService {

	public static final String ACCOUNT_SID = "AC1af918078b68e4e68a909497360d2c5c";
	public static final String AUTH_TOKEN = "621ca4a4528fb2ae7248effe2482dd64";
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
