package com.novy.email.microservice.sender;

import javax.mail.Session;
import java.util.Properties;

/**
 * Created by novy on 17.02.15.
 */
// todo: refactor
public class MailConfiguration {

    private final DomainConfiguration domainConfiguration;
    private final String username;
    private final String password;

    public MailConfiguration(EmailAddress senderAddress,  String password) {
        domainConfiguration = SupportedDomains.from(
                senderAddress.domain()
        );

        this.username = senderAddress.username();
        this.password = password;
    }

    public Session session() {
        final Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", domainConfiguration.host());
        properties.put("mail.smtp.user", username);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.port", domainConfiguration.port());
        properties.put("mail.smtp.auth", domainConfiguration.auth());

        return Session.getDefaultInstance(properties);
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
}
