package com.novy.email.microservice.sender.service

import org.codemonkey.simplejavamail.Email
import org.codemonkey.simplejavamail.Mailer

/**
 * Created by novy on 17.02.15.
 */
class SenderServiceOnSimpleMessageTest extends SenderServicePreconfiguredTestCase {

    def "should convert Message to Email using EmailFactory"() {

        when:
        objectUnderTest.send(message, configuration)

        then:
        1 * emailFactoryMock.fromMessage(message)
    }

    def "should retrieve Mailer from MailerFactory using given Configuration"() {

        when:
        objectUnderTest.send(message, configuration)

        then:
        1 * mailerFactoryMock.fromConfiguration(configuration)
    }

    def "should pass retrieved Email and Mailer down to Sender"() {

        when:
        objectUnderTest.send(message, configuration)

        then:
        1 * senderMock.send(_ as Mailer, _ as Email)
    }
}
