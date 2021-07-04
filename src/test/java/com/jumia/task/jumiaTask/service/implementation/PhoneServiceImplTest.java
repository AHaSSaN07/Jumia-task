package com.jumia.task.jumiaTask.service.implementation;

import com.jumia.task.jumiaTask.dto.PhoneDto;
import com.jumia.task.jumiaTask.repo.CustomerRepository;
import com.jumia.task.jumiaTask.service.PhoneService;
import com.jumia.task.jumiaTask.dummyDataSources.DummyCustomerRepo;
import com.jumia.task.jumiaTask.dummyDataSources.DummyEnv;
import com.jumia.task.jumiaTask.utils.PhoneValidityChecker;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
class PhoneServiceImplTest {

    CustomerRepository customerRepository = new DummyCustomerRepo();
    Environment environment = new DummyEnv();
    PhoneValidityChecker phoneValidityChecker = new PhoneValidityChecker(environment);
    PhoneService phoneService = new PhoneServiceImpl(customerRepository, phoneValidityChecker, environment);

    //mock tests  to check the business logic
    @Test
    void getAllPhoneNumbersWithStatusAndCountriesTest() {
        List<PhoneDto> list = this.phoneService.getAllPhoneNumbersWithRequestedFilters(Optional.empty(), Optional.empty(),Optional.empty(), Optional.empty());
        Assert.assertEquals(11, list.size());
    }

    @Test
    void getAllPhoneNumbersWithStatusAndCountriesWithValidFilterTest() {
        List<PhoneDto> list = this.phoneService.getAllPhoneNumbersWithRequestedFilters(Optional.of(true), Optional.empty(),Optional.empty(), Optional.empty());
        Assert.assertEquals(6, list.size());
    }

    @Test
    void getAllPhoneNumbersWithStatusAndCountriesWithCountryFilterTest() {
        List<PhoneDto> list = this.phoneService.getAllPhoneNumbersWithRequestedFilters(Optional.empty(), Optional.of("Morocco"),Optional.empty(), Optional.empty());
        Assert.assertEquals(4, list.size());
    }
    @Test
    void getAllPhoneNumbersWithStatusAndCountriesWithCountryAndStatysFiltersTest() {
        List<PhoneDto> list = this.phoneService.getAllPhoneNumbersWithRequestedFilters(Optional.of(true), Optional.of("Morocco"),Optional.empty(), Optional.empty());
        Assert.assertEquals(1, list.size());
    }
}