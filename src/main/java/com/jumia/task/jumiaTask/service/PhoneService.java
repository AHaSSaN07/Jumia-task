package com.jumia.task.jumiaTask.service;

import com.jumia.task.jumiaTask.dto.PhoneDto;
import com.jumia.task.jumiaTask.entity.Customer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PhoneService {
    //public List<String> getAllValidPhoneNumbers();

    public List<PhoneDto> getAllPhoneNumbersWithRequestedFilters(Optional<Boolean> validFilter, Optional<String> countryFilter);

}
