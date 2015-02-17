package com.novy.email.microservice.sender;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SenderTest {

    private final Sender objectUnderTest = new Sender();

    @Mock
    private Email emailMock;

    @Mock
    private Mailer mailerMock;

    @Test
    public void shouldInvokeSendEmailMethodOnMailerGivenEmailMessage() throws Exception {

        objectUnderTest.send(mailerMock, emailMock);

        verify(mailerMock, times(1)).sendMail(emailMock);
    }

    @Test
    public void shouldInvokeSendEmailMethodNTimesGivenCollectionOfEmails() throws Exception {

        final int n = 10;

        objectUnderTest.send(mailerMock, Collections.nCopies(n, emailMock));

        verify(mailerMock, times(n)).sendMail(emailMock);
    }
}