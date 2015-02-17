package com.novy.email.microservice.sender;

/**
 * Created by novy on 16.02.15.
 */

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 * Created by novy on 16.02.15.
 */
// todo: REFACTOR
public class Sender {

    private MimeMessageFactory mimeMessageFactory;

    public Sender(MimeMessageFactory mimeMessageFactory) {
        this.mimeMessageFactory = mimeMessageFactory;
    }

    public void send(Message message, MailConfiguration configuration) throws MessagingException {
        final Session session = configuration.session();

        final MimeMessage mimeMessage = mimeMessageFactory.fromMessage(
                message, session
        );

        Transport transport = session.getTransport("smtp");

        transport.connect(configuration.smtpServer(), configuration.username(), configuration.password());
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();

    }
}
