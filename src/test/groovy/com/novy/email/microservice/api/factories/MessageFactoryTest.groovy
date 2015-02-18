package com.novy.email.microservice.api.factories

import com.novy.email.builders.MessageBuilder
import com.novy.email.builders.SendEmailRequestBuilder
import com.novy.email.factories.SendEmailRequestFactory
import spock.lang.Specification

/**
 * Created by novy on 18.02.15.
 */
class MessageFactoryTest extends Specification {

    def "should create messages differing by recipient"() {

        given:
        final objectUnderTest = new MessageFactory()

        final sendEmailRequest = SendEmailRequestBuilder
                .newSendEmailRequest()
                .recipient("firstRecipient@gmail.com")
                .recipient("secondRecipient@gmail.com")
                .recipient("thirdRecipient@gmail.com")
                .build()

        when:
        final actualMessages = objectUnderTest.fromRequest(sendEmailRequest)

        then:
        final expectedMessages = [
                MessageBuilder.newMessage()
                        .recipient("firstRecipient@gmail.com")
                        .sender(sendEmailRequest.getSender())
                        .subject(sendEmailRequest.getSubject())
                        .content(sendEmailRequest.getContent())
                        .build(),

                MessageBuilder.newMessage()
                        .recipient("secondRecipient@gmail.com")
                        .sender(sendEmailRequest.getSender())
                        .subject(sendEmailRequest.getSubject())
                        .content(sendEmailRequest.getContent())
                        .build(),

                MessageBuilder.newMessage()
                        .recipient("thirdRecipient@gmail.com")
                        .sender(sendEmailRequest.getSender())
                        .subject(sendEmailRequest.getSubject())
                        .content(sendEmailRequest.getContent())
                        .build(),
        ]

        actualMessages == expectedMessages
    }

    def "should throw an illegal argument exception given request without recipients"() {

        given:
        final objectUnderTest = new MessageFactory()

        when:
        objectUnderTest.fromRequest(SendEmailRequestFactory.withoutAnyRecipient())

        then:
        thrown(IllegalArgumentException.class)
    }
}
