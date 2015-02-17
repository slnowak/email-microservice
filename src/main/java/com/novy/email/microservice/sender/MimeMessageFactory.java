package com.novy.email.microservice.sender;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by novy on 16.02.15.
 */
public class MimeMessageFactory {

    public MimeMessage fromMessage(Message message, Session session) throws MessagingException {
        MimeMessage mimeMessage = new MimeMessage(session);

        mimeMessage.addFrom(
                InternetAddress.parse(message.sender())
        );

        mimeMessage.addRecipients(
                javax.mail.Message.RecipientType.TO, InternetAddress.parse(message.recipient())
        );

        mimeMessage.setSubject(
                message.subject()
        );

        mimeMessage.setText(
                message.content(), "utf-8"
        );

        return mimeMessage;
    }
}
