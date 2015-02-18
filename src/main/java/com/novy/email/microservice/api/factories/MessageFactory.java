package com.novy.email.microservice.api.factories;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.novy.email.microservice.api.SendEmailRequest;
import com.novy.email.microservice.sender.message.EmailAddress;
import com.novy.email.microservice.sender.message.Message;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by novy on 18.02.15.
 */
public class MessageFactory {

    public Collection<Message> fromRequest(SendEmailRequest request) {
        Preconditions.checkArgument(request.hasAnyRecipient(), "No recipients provided!");

        final Message messageToClone = getMessageToClone(request);

        return clonedForEachRecipient(messageToClone, request.getRecipients());

    }

    private Collection<Message> clonedForEachRecipient(Message messageToClone, Collection<String> recipients) {
        return recipients
                .stream()
                .map(
                        recipient -> messageToClone.withRecipient(
                                EmailAddress.of(recipient)
                        )
                )
                .collect(Collectors.toList());
    }

    private Message getMessageToClone(SendEmailRequest request) {
        final Collection<String> recipients = request.getRecipients();

        return new Message(
                EmailAddress.of(Iterables.getFirst(recipients, "default")),
                EmailAddress.of(request.getSender()),
                request.getSubject(),
                request.getContent()
        );
    }
}
