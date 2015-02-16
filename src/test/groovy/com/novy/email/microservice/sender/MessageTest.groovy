package com.novy.email.microservice.sender

import com.novy.email.builders.MessageBuilder
import spock.lang.Specification

/**
 * Created by novy on 17.02.15.
 */
class MessageTest extends Specification {

    def "should be able to create copy of message with different recipient"() {

        given:
        def originalMessage = MessageBuilder
                .newMessage()
                .recipient("recipieng@gmail.com")
                .build();

        when:
        def withDifferentRecipient = originalMessage.withRecipient(
                EmailAddress.of("differentRecipient@gmail.com")
        )

        then:
        def expectedMessage = MessageBuilder
                .newMessage()
                .recipient("differentRecipient@gmail.com")
                .build();

        expectedMessage == withDifferentRecipient

    }
}
