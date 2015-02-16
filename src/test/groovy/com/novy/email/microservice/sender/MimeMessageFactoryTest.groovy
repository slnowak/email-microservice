package com.novy.email.microservice.sender

import com.novy.email.builders.MessageBuilder
import spock.lang.Specification

import javax.mail.Session
import javax.mail.internet.MimeMessage

/**
 * Created by novy on 17.02.15.
 */
class MimeMessageFactoryTest extends Specification {

    def "should create proper MimeMessage from given Message"() {

        given:
        def session = Session.getDefaultInstance(new Properties())

        def message = MessageBuilder
                .newMessage()
                .build()

        when:
        def mimeMessage = MimeMessageFactory.fromMessage(
                message, session
        )

        then:
        mimeMessage.getSubject() == message.subject()
        extractSender(mimeMessage) == message.sender()
        extractRecipientFrom(mimeMessage) == message.recipient()

    }

    private String extractRecipientFrom(MimeMessage mimeMessage) {
        mimeMessage.getAllRecipients()[0].toString()
    }

    private String extractSender(MimeMessage mimeMessage) {
        mimeMessage.getFrom()[0].toString()
    }
}
