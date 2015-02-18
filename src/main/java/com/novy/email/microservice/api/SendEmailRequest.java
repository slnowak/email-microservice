package com.novy.email.microservice.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * Created by novy on 17.02.15.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SendEmailRequest {

    private Collection<String> recipients;

    private String sender;
    private String password;

    private String subject;
    private String content;

    public boolean hasAnyRecipient() {
        return !recipients.isEmpty();
    }

}
