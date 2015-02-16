package com.novy.email.builders;

import com.novy.email.microservice.sender.EmailAddress;
import com.novy.email.microservice.sender.Message;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by novy on 17.02.15.
 */

@Accessors(chain = true, fluent = true)
@NoArgsConstructor(staticName = "newMessage")
public class MessageBuilder {

    private EmailAddress recipient = EmailAddress.of("recipient@gmail.com");
    private EmailAddress sender = EmailAddress.of("sender@gmail.com");

    @Setter
    private String subject = "subject";
    @Setter
    private String content = "content";

    public MessageBuilder recipient(String recipient) {
        this.recipient = EmailAddress.of(recipient);
        return this;
    }

    public MessageBuilder sender(String sender) {
        this.sender = EmailAddress.of(sender);
        return this;
    }

    public Message build() {
        return new Message(
                recipient, sender, subject, content
        );
    }
}
