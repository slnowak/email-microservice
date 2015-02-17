package com.novy.email.microservice.sender.factories;

import com.novy.email.microservice.sender.message.Message;
import org.codemonkey.simplejavamail.Email;

/**
 * Created by novy on 16.02.15.
 */
public class EmailFactory {

    public Email fromMessage(Message message) {
        Email email = new Email();

        email.setFromAddress(message.sender(), message.sender());

        email.addRecipient("", message.recipient(), javax.mail.Message.RecipientType.TO);

        email.setSubject(message.subject());

        email.setText(message.content());

        return email;
    }
}
