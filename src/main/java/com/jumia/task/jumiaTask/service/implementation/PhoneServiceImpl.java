package com.jumia.task.jumiaTask.service.implementation;

import com.jumia.task.jumiaTask.repo.CustomerRepository;
import com.jumia.task.jumiaTask.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {

    CustomerRepository customerRepository;

    @Autowired
    PhoneServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<String> getAllPhoneNumbers() {
        return null;
    }
}
