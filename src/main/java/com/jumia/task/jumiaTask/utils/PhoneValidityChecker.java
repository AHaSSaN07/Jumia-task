package com.jumia.task.jumiaTask.utils;
import com.jumia.task.jumiaTask.exceptions.PropNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class PhoneValidityChecker {

    Environment environment;

    @Autowired
    public PhoneValidityChecker(Environment env) {
        this.environment = env;
    }


    public Boolean ValidatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty())
            return false;

        //(212)698054317 => 212
        String countryCode = phoneNumber.substring(1, phoneNumber.indexOf(')'));
        if (countryCode.isEmpty() || countryCode == null)
            return false;


        String correspondingRegex = environment.getProperty(countryCode);
        if (correspondingRegex == null)throw new PropNotFound(countryCode);


        Pattern pattern = Pattern.compile(correspondingRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        while (matcher.find()) {
            return true;
        }
        return false;
    }
}
