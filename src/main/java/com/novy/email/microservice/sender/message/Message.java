package com.novy.email.microservice.sender.message;

import com.google.common.base.Preconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by novy on 16.02.15.
 */


@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class Message {

    private final EmailAddress recipient;
    private final EmailAddress sender;

    @Getter
    private final String subject;
    @Getter
    private final String content;

    public Message(EmailAddress recipient, EmailAddress sender, String subject, String content) {
        checkForNulls(recipient, sender, subject, content);

        Preconditions.checkArgument(!subject.isEmpty(), "Title cannot be empty!");
        Preconditions.checkArgument(!content.isEmpty(), "Content cannot be empty!");

        this.recipient = recipient;
        this.sender = sender;
        this.subject = subject;
        this.content = content;
    }

    private void checkForNulls(EmailAddress recipient, EmailAddress sender, String title, String content) {
        Preconditions.checkNotNull(recipient);
        Preconditions.checkNotNull(sender);
        Preconditions.checkNotNull(title);
        Preconditions.checkNotNull(content);
    }

    public Message withRecipient(EmailAddress newRecipient) {
        return new Message(newRecipient, sender, subject, content);
    }

    public String sender() {
        return sender.emailString();
    }

    public String recipient() {
        return recipient.emailString();
    }
}
