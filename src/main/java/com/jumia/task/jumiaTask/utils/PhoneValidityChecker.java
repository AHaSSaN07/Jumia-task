package com.jumia.task.jumiaTask.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class PhoneValidityChecker {

    Environment environment;

    @Autowired
    PhoneValidityChecker(Environment env){
        this.environment =env;
    }

    public Boolean ValidatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty())
            return false;

        //(212)698054317 => 212
        String countryCode = phoneNumber.substring(1,phoneNumber.indexOf(')'));
        if(countryCode.isEmpty() || countryCode.length() ==0)
            return false;

        String correspondingRegex = environment.getProperty(countryCode.toString());
        if(correspondingRegex.isEmpty() || correspondingRegex == null)
            return false;

        return phoneNumber.matches(correspondingRegex);
    }
}
