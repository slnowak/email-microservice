package com.novy.email.builders;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.novy.email.microservice.api.SendEmailRequest;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collection;

/**
 * Created by novy on 18.02.15.
 */

@Accessors(chain = true, fluent = true)
@NoArgsConstructor(staticName = "newSendEmailRequest")
public class SendEmailRequestBuilder {

    private Collection<String> defaultRecipients = ImmutableList.of(
            "recipient1@gmail.com", "recipient2@gmail.com"
    );

    private Collection<String> recipients = Lists.newArrayList();

    @Setter
    private String sender = "sender@gmail.com";

    @Setter
    private String password = "password";

    @Setter
    private String subject = "subject";

    @Setter
    private String content = "content";

    public SendEmailRequestBuilder recipient(String recipient) {
        recipients.add(recipient);
        return this;
    }

    public SendEmailRequest build() {
        Collection<String> recipientsToUse = recipients.isEmpty() ? defaultRecipients: recipients;

        return new SendEmailRequest(
                recipientsToUse,
                sender,
                password,
                subject,
                content
        );
    }

}
