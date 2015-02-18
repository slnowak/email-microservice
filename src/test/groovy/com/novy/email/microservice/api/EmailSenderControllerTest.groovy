package com.novy.email.microservice.api

import com.novy.email.microservice.api.factories.MailConfigurationFactory
import com.novy.email.microservice.api.factories.MessageFactory
import com.novy.email.microservice.sender.configuration.MailConfiguration
import com.novy.email.microservice.sender.message.Message
import com.novy.email.microservice.sender.service.SenderService
import spock.lang.Specification

/**
 * Created by novy on 18.02.15.
 */
class EmailSenderControllerTest extends Specification {

    private EmailSenderController objectUnderTest
    private SenderService senderServiceMock
    private MessageFactory messageFactoryMock
    private MailConfigurationFactory mailConfigurationFactoryMock

    private SendEmailRequest requestMock

    void setup() {

        senderServiceMock = Mock(SenderService.class)
        messageFactoryMock = Mock(MessageFactory.class)
        mailConfigurationFactoryMock = Mock(MailConfigurationFactory.class)
        requestMock = Mock(SendEmailRequest.class)

        messageFactoryMock.fromRequest(requestMock) >> Mock(Collection.class);
        mailConfigurationFactoryMock.fromRequest(requestMock) >> Mock(MailConfiguration.class)

        objectUnderTest = new EmailSenderController(
                senderServiceMock, messageFactoryMock, mailConfigurationFactoryMock
        )

    }

    def "should retrieve Messages from MessageFactory using given Request"() {

        when:
        objectUnderTest.handle(requestMock)

        then:
        1 * messageFactoryMock.fromRequest(requestMock)
    }

    def "should retrieve Configuration from ConfigurationFactory using Given Request"() {

        when:
        objectUnderTest.handle(requestMock)

        then:
        1 * mailConfigurationFactoryMock.fromRequest(requestMock)
    }

    def "should invoke proper method on SenderService"() {

        when:
        objectUnderTest.handle(requestMock)

        then:
        1 * senderServiceMock.send(_ as Collection<Message>, _ as MailConfiguration)
    }
}
