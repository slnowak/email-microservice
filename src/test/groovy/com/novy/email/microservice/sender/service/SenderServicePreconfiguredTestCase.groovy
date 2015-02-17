package com.novy.email.microservice.sender.service

import com.novy.email.builders.MailConfigurationBuilder
import com.novy.email.builders.MessageBuilder
import com.novy.email.microservice.sender.configuration.MailConfiguration
import com.novy.email.microservice.sender.message.Message
import com.novy.email.microservice.sender.Sender
import com.novy.email.microservice.sender.factories.EmailFactory
import com.novy.email.microservice.sender.factories.MailerFactory
import org.codemonkey.simplejavamail.Email
import org.codemonkey.simplejavamail.Mailer
import spock.lang.Specification


/**
 * Created by novy on 17.02.15.
 */
abstract class SenderServicePreconfiguredTestCase extends Specification {

    SenderService objectUnderTest

    Sender senderMock
    EmailFactory emailFactoryMock
    MailerFactory mailerFactoryMock

    Message message
    MailConfiguration configuration

    void setup() {
        senderMock = Mock(Sender.class)
        emailFactoryMock = Mock(EmailFactory.class)
        mailerFactoryMock = Mock(MailerFactory.class)

        message = MessageBuilder
                .newMessage()
                .build()

        configuration = MailConfigurationBuilder
                .newMailConfiguration()
                .build()

//        evil code here, but just to avoid using two unchecked wildcards
        emailFactoryMock.fromMessage(message) >> Mock(Email.class)
        mailerFactoryMock.fromConfiguration(configuration) >> Mock(Mailer.class)

        objectUnderTest = new SenderService(senderMock, emailFactoryMock, mailerFactoryMock)
    }

}