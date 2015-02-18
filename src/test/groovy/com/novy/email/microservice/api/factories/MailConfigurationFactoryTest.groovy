package com.novy.email.microservice.api.factories

import com.novy.email.builders.SendEmailRequestBuilder
import com.novy.email.microservice.api.SendEmailRequest
import spock.lang.Specification

/**
 * Created by novy on 18.02.15.
 */
class MailConfigurationFactoryTest extends Specification {

    def "created MailConfiguration should have exact same username and password"() {

        given:
        final objectUnderTest = new MailConfigurationFactory()

        when:
        final SendEmailRequest request =
                SendEmailRequestBuilder.newSendEmailRequest()
                        .sender("sender@gmail.com")
                        .password("fancyPassword")
                        .build()

        final actualConfiguration = objectUnderTest.fromRequest(request)

        then:
        actualConfiguration.username() == "sender"
        actualConfiguration.password() == "fancyPassword"
    }
}
