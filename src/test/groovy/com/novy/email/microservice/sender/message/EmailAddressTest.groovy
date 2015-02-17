package com.novy.email.microservice.sender.message

import com.novy.email.microservice.sender.message.EmailAddress
import spock.lang.Specification

/**
 * Created by novy on 16.02.15.
 */
class EmailAddressTest extends Specification {

    def "should not be able to create invalid email"() {

        when:
        EmailAddress.of(emailString)

        then:
        thrown(IllegalArgumentException.class)

        where:
        emailString << [
                "without@domain",
                "",
                "randomString",
                "@without.user.name",
                "with.too.short.domain@p.c"
        ]


    }

    def "should be able to create valid email address"() {

        given:
        def validEmailAddress = "validEmailAddresss@gmail.com"

        when:
        def email = EmailAddress.of(validEmailAddress)

        then:
        email.emailString() == validEmailAddress
    }

    def "should properly separate username from domain"() {

        given:
        def validEmailAddress = "username@gmail.com"

        when:
        def email = EmailAddress.of(validEmailAddress)

        then:
        email.username() == "username"
        email.domain() == "gmail.com"
    }
}
