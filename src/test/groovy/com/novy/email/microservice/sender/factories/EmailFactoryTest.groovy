package com.novy.email.microservice.sender.factories

import com.novy.email.builders.MessageBuilder
import com.novy.email.microservice.sender.factories.EmailFactory
import org.codemonkey.simplejavamail.Email
import spock.lang.Specification

/**
 * Created by novy on 17.02.15.
 */
class EmailFactoryTest extends Specification {

    private final EmailFactory objectUnderTest = new EmailFactory()

    def "should create proper Email from given Message"() {

        given:
        def message = MessageBuilder
                .newMessage()
                .build()

        when:
        def email = objectUnderTest.fromMessage(message)

        then:
        email.getSubject() == message.subject()
        email.getText() == message.content()
        extractSenderFrom(email) == message.sender()
        extractRecipientFrom(email) == message.recipient()

    }

    private String extractRecipientFrom(Email emailMessage) {
        emailMessage.getRecipients()
                .first()
                .getAddress()
    }

    private String extractSenderFrom(Email emailMessage) {
        emailMessage.getFromRecipient().getAddress()
    }
}
