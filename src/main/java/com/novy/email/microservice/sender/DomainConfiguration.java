package com.novy.email.microservice.sender;

/**
 * Created by novy on 17.02.15.
 */
public interface DomainConfiguration {

    String host();
    String port();
    String auth();

}
