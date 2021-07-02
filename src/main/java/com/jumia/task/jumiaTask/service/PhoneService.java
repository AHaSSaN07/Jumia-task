package com.jumia.task.jumiaTask.service;

import com.jumia.task.jumiaTask.dto.PhoneDto;
import com.jumia.task.jumiaTask.entity.Customer;

import java.util.List;
import java.util.Map;

public interface PhoneService {
    public List<String> getAllValidPhoneNumbers();

    public List<PhoneDto> getAllPhoneNumbersWithStatusAndCountries();

}
