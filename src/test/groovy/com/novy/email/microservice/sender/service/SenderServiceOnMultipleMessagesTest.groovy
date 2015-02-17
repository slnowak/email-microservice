package com.novy.email.microservice.sender.service

import com.novy.email.microservice.sender.Message
import org.codemonkey.simplejavamail.Email
import org.codemonkey.simplejavamail.Mailer

/**
 * Created by novy on 17.02.15.
 */
class SenderServiceOnMultipleMessagesTest extends SenderServicePreconfiguredTestCase {

    final int n = 10
    Collection<Message> messages

    void setup() {
        messages = Collections.nCopies(n, message)
    }

    def "should retrieve Mailer exactly once"() {

        when:
        objectUnderTest.send(message, configuration)

        then:
        1 * mailerFactoryMock.fromConfiguration(configuration)

    }

    def "should user EmailFactory for each Message"() {

        when:
        objectUnderTest.send(messages, configuration)

        then:
        10 * emailFactoryMock.fromMessage(message)
    }

    def "should invoke sender for each Message"() {

        when:
        objectUnderTest.send(messages, configuration)

        then:
        n * senderMock.send(_ as Mailer, _ as Email)
    }

}