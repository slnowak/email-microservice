package com.novy.email.microservice.sender;

/**
 * Created by novy on 16.02.15.
 */

import com.google.common.collect.ImmutableList;
import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;

import java.util.Collection;

/**
 * Created by novy on 16.02.15.
 */
public class Sender {

    public void send(Mailer mailer, Email email) {
        send(mailer, ImmutableList.of(email));
    }

    public void send(Mailer mailer, Collection<Email> emails) {
        for (Email email : emails) {
            mailer.sendMail(email);
        }
//        emails.forEach(
//                mailer::sendMail
//        );
    }

}
