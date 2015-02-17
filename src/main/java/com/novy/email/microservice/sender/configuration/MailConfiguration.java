package com.novy.email.microservice.sender.configuration;

import com.novy.email.microservice.sender.message.EmailAddress;

/**
 * Created by novy on 17.02.15.
 */
public class MailConfiguration {

    private final DomainConfiguration domainConfiguration;
    private final String username;
    private final String password;

    public MailConfiguration(EmailAddress senderAddress, String password) {
        domainConfiguration = SupportedDomains.from(
                senderAddress.domain()
        );

        this.username = senderAddress.username();
        this.password = password;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String smtpServer() {
        return domainConfiguration.host();
    }

    public Integer tlsPort() {
        return domainConfiguration.tlsPort();
    }
}
