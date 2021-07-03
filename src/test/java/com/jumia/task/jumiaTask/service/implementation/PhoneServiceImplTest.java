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

    @Test
    void getAllPhoneNumbersWithStatusAndCountries() {
        List<PhoneDto> list = this.phoneService.getAllPhoneNumbersWithStatusAndCountries(Optional.empty(), Optional.empty());
        Assert.assertEquals(11, list.size());
    }

    @Test
    void getAllPhoneNumbersWithStatusAndCountriesWithValidFilter() {
        List<PhoneDto> list = this.phoneService.getAllPhoneNumbersWithStatusAndCountries(Optional.of(true), Optional.empty());
        Assert.assertEquals(6, list.size());
    }

    @Test
    void getAllPhoneNumbersWithStatusAndCountriesWithCountryFilter() {
        List<PhoneDto> list = this.phoneService.getAllPhoneNumbersWithStatusAndCountries(Optional.empty(), Optional.of("Morocco"));
        Assert.assertEquals(4, list.size());
    }
}