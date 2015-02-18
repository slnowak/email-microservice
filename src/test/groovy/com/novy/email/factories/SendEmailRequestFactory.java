package com.novy.email.factories;

import com.novy.email.microservice.api.SendEmailRequest;

import java.util.Collections;

/**
 * Created by novy on 18.02.15.
 */
public class SendEmailRequestFactory {

    public static SendEmailRequest withoutAnyRecipient() {
        return new SendEmailRequest(
                Collections.emptyList(),
                "sender",
                "password",
                "subject",
                "content"
        );
    }
}
