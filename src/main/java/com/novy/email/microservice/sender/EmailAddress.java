package com.novy.email.microservice.sender;


import com.google.common.base.Preconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * Created by novy on 16.02.15.
 */
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
public class EmailAddress {

    private static final String VALIDATION_MESSAGE = "Invalid email string!";

    private final String username;
    private final String domain;

    private EmailAddress(String emailString) {
        Preconditions.checkArgument(isValid(emailString), VALIDATION_MESSAGE);

        final String[] emailTokens = emailString.split("@");
        this.username = emailTokens[0];
        this.domain = emailTokens[1];
    }

    public static EmailAddress of(String emailString) {
        return new EmailAddress(emailString);
    }

    private boolean isValid(String emailString) {
        return EmailValidator
                .getInstance()
                .isValid(emailString);
    }

    public String emailString() {
        return username + "@" + domain;
    }
}