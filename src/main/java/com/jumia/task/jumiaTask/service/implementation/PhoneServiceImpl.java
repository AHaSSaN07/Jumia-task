package com.jumia.task.jumiaTask.service.implementation;

import com.jumia.task.jumiaTask.dto.PhoneDto;
import com.jumia.task.jumiaTask.repo.CustomerRepository;
import com.jumia.task.jumiaTask.service.PhoneService;
import com.jumia.task.jumiaTask.utils.PhoneValidityChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class PhoneServiceImpl implements PhoneService {

    CustomerRepository customerRepository;
    PhoneValidityChecker phoneValidityChecker;
    Environment environment;

    @Autowired
    PhoneServiceImpl(CustomerRepository customerRepository, PhoneValidityChecker phoneValidityChecker, Environment environment) {
        this.customerRepository = customerRepository;
        this.phoneValidityChecker = phoneValidityChecker;
        this.environment = environment;
    }


    @Override
    public List<String> getAllValidPhoneNumbers() {

        //fetches all phone numbers stored in db, converts to a stream then filters by phone validator as a predicate.
        List<String> phoneNumbers = this.customerRepository.getAllPhoneNumbers();
        phoneNumbers.forEach(System.out::println);
        return phoneNumbers.stream()
                .filter(num -> this.phoneValidityChecker.ValidatePhoneNumber(num))
                .collect(Collectors.toList());
    }



    @Override
    public List<PhoneDto> getAllPhoneNumbersWithStatusAndCountries() {
        List<String> phoneNumbers = this.customerRepository.getAllPhoneNumbers();
        List<PhoneDto> response = new ArrayList<>();
        for(String number : phoneNumbers){
            Boolean isValid = this.phoneValidityChecker.ValidatePhoneNumber(number);
            String country =getCountryName(getCountryCode(number));

            PhoneDto phoneDto = new PhoneDto();
            phoneDto.setStatus(isValid);
            phoneDto.setPhone(number);
            phoneDto.setCountry(country);

            response.add(phoneDto);
        }
        return response;
    }

    //these to throw exceptions and to be caught in exception handling.
    private String getCountryCode(String number){
        String code =  number.substring(1, number.indexOf(')'));
        return code.isEmpty()?null:code;
    }
    private String getCountryName(String code){
        String name =environment.getProperty(code+ "_name");
        return name.isEmpty()?null:name;
    }

}
