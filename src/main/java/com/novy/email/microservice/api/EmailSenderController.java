package com.novy.email.microservice.api;

import com.novy.email.microservice.api.factories.MailConfigurationFactory;
import com.novy.email.microservice.api.factories.MessageFactory;
import com.novy.email.microservice.sender.configuration.MailConfiguration;
import com.novy.email.microservice.sender.message.Message;
import com.novy.email.microservice.sender.service.SenderService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by novy on 17.02.15.
 */

@Path("/emailservice/")
@Produces(MediaType.APPLICATION_JSON)
public class EmailSenderController {

    private final SenderService senderService;
    private final MessageFactory messageFactory;
    private final MailConfigurationFactory mailConfigurationFactory;

    public EmailSenderController(SenderService senderService,
                                 MessageFactory messageFactory,
                                 MailConfigurationFactory mailConfigurationFactory) {
        this.senderService = senderService;
        this.messageFactory = messageFactory;
        this.mailConfigurationFactory = mailConfigurationFactory;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void handle(SendEmailRequest request) {

        final Collection<Message> messages = messageFactory.fromRequest(request);
        final MailConfiguration configuration = mailConfigurationFactory.fromRequest(request);

        senderService.send(messages, configuration);
    }
}
