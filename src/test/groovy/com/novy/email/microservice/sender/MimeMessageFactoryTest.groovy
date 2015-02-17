package com.novy.email.microservice.sender

import com.novy.email.builders.MessageBuilder
import spock.lang.Specification

import javax.mail.Session
import javax.mail.internet.MimeMessage

/**
 * Created by novy on 17.02.15.
 */
class MimeMessageFactoryTest extends Specification {

    private final MimeMessageFactory objectUnderTest = new MimeMessageFactory()

    def "should create proper MimeMessage from given Message"() {

        given:
        def session = unnecessarySession()

        def message = MessageBuilder
                .newMessage()
                .build()

        when:
        def mimeMessage = objectUnderTest.fromMessage(
                message, session
        )

        then:
        mimeMessage.getSubject() == message.subject()
        extractSender(mimeMessage) == message.sender()
        extractRecipientFrom(mimeMessage) == message.recipient()

    }

    private Session unnecessarySession() {
        Session.getDefaultInstance(new Properties())
    }

    private String extractRecipientFrom(MimeMessage mimeMessage) {
        mimeMessage.getAllRecipients()[0].toString()
    }

    private String extractSender(MimeMessage mimeMessage) {
        mimeMessage.getFrom()[0].toString()
    }
}
