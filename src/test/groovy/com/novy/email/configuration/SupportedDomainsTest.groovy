package com.novy.email.configuration

import com.novy.email.microservice.sender.configuration.SupportedDomains
import spock.lang.Specification

/**
 * Created by novy on 17.02.15.
 */
class SupportedDomainsTest extends Specification {

    def "from method should return gmail configuration given gmail.com domain"() {

        when:
        def configuration = SupportedDomains.from("gmail.com")

        then:
        configuration == SupportedDomains.GMAIL

    }

    def "should throw an exception given unsupported domain"() {

        when:
        SupportedDomains.from("unsupported.domain")

        then:
        thrown(IllegalArgumentException.class)

    }
}
