package com.novy.email.microservice.sender;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by novy on 17.02.15.
 */
public enum SupportedDomains implements DomainConfiguration {

    GMAIL {

        @Override
        public String host() {
            return "smtp.gmail.com";
        }
        @Override
        public String port() {
            return "587";
        }

        @Override
        public String auth() {
            return "true";
        }
    };

    private static final Map<String, SupportedDomains> mapping;
    static {
        mapping = ImmutableMap.of(
                "gmail.com", GMAIL
        );
    }

    public static DomainConfiguration from(String domain) {
        Preconditions.checkArgument(mapping.containsKey(domain), "Unsupported domain!");
        return mapping.get(domain);
    }
}
