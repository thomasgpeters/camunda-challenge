package com.camunda.tgp;

import org.json.simple.parser.ParseException;

public class InvalidUserResponseException extends RuntimeException {
    public InvalidUserResponseException(ParseException pe) {
        System.out.println("An exception occurred while Parsing the response.");
        pe.printStackTrace();
    }

}
