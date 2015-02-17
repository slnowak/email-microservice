package com.novy.email.builders;

import com.novy.email.microservice.sender.message.EmailAddress;
import com.novy.email.microservice.sender.configuration.MailConfiguration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by novy on 17.02.15.
 */

@Accessors(chain = true, fluent = true)
@NoArgsConstructor(staticName = "newMailConfiguration")
public class MailConfigurationBuilder {

    private EmailAddress senderAddress = EmailAddress.of("sender@gmail.com");

    @Getter
    private String password = "password";

    public MailConfigurationBuilder senderAddress(String senderAddress) {
        this.senderAddress = EmailAddress.of(senderAddress);
        return this;
    }

    public MailConfiguration build() {
        return new MailConfiguration(
                senderAddress, password
        );
    }
}
