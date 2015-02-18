package com.novy.email.microservice.api;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by novy on 17.02.15.
 */
public class EmailSenderApplication extends Application<EmailSenderConfiguration> {

    @Override
    public void run(EmailSenderConfiguration configuration, Environment environment) throws Exception {
        final EmailSenderController controller = configuration.emailSenderController();

        environment.jersey().register(controller);
    }

    public static void main(String[] args) throws Exception {
        new EmailSenderApplication().run(args);
    }
}
