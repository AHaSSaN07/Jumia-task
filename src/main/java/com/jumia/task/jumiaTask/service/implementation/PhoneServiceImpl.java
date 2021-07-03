package com.jumia.task.jumiaTask.service.implementation;

import com.jumia.task.jumiaTask.dto.PhoneDto;
import com.jumia.task.jumiaTask.repo.CustomerRepository;
import com.jumia.task.jumiaTask.service.PhoneService;
import com.jumia.task.jumiaTask.utils.PhoneValidityChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.*;
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


//    @Override
//    public List<String> getAllValidPhoneNumbers() {
//        //fetches all phone numbers stored in db, converts to a stream then filters by phone validator as a predicate.
//        List<String> phoneNumbers = this.customerRepository.getAllPhoneNumbers();
//        phoneNumbers.forEach(System.out::println);
//        return phoneNumbers.stream()
//                .filter(num -> this.phoneValidityChecker.ValidatePhoneNumber(num))
//                .collect(Collectors.toList());
//    }

    @Override
    public List<PhoneDto> getAllPhoneNumbersWithStatusAndCountries(Optional<Boolean> validFilter, Optional<String> countryFilter) {
        List<String> phoneNumbers = this.customerRepository.getAllPhoneNumbers();
        List<PhoneDto> response = new ArrayList<>();
        for (String number : phoneNumbers) {
            Boolean isValid = this.phoneValidityChecker.ValidatePhoneNumber(number);
            String code = getCountryCode(number);
            String country = getCountryName(code);

            PhoneDto phoneDto = populateDto(number, code, isValid, country);

            response.add(phoneDto);
        }

        response = applyCountryFilter(countryFilter, response);
        response = applyValidFilter(validFilter, response);

        return response;
    }

    //these to throw exceptions and to be caught in exception handling.
    private String getCountryCode(String number) {
        String code = number.substring(1, number.indexOf(')'));
        return code.isEmpty() ? null : code;
    }

    private String getCountryName(String code) {
        String name = environment.getProperty(code + "_name");
        return name.isEmpty() ? null : name;
    }

    private PhoneDto populateDto(String number, String code, Boolean validity, String country) {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setValidityStatus(validity);
        phoneDto.setPhone(number);
        phoneDto.setCountryCode(code);
        phoneDto.setCountry(country);
        return phoneDto;
    }

    //checks if there's a flag to group response by phone status
    //if there is, converting response object to a stream and filter it using a predicate to check the status then converted back to filtered list.
    private List<PhoneDto> applyValidFilter(Optional<Boolean> validFilter, List<PhoneDto> unfilteredResponse) {
        if (validFilter.isEmpty())
            return unfilteredResponse;
        return validFilter.orElse(true) ? unfilteredResponse.stream()
                .filter(phoneDto -> phoneDto.getValidityStatus())
                .collect(Collectors.toList())
                : unfilteredResponse.stream()
                .filter(phoneDto -> !phoneDto.getValidityStatus())
                .collect(Collectors.toList());
    }

    private List<PhoneDto> applyCountryFilter(Optional<String> countryFilter, List<PhoneDto> unfilteredResponse) {
        if (countryFilter.isEmpty())
            return unfilteredResponse;
        String countryName = countryFilter.get();
        return unfilteredResponse.stream()
                .filter(phoneDto -> phoneDto.getCountry().equals(countryName))
                .collect(Collectors.toList());
    }

}
