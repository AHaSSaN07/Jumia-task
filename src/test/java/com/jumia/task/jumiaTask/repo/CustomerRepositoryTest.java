package com.jumia.task.jumiaTask.repo;

import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testRepo(){
        List<String> list = customerRepository.getAllPhoneNumbers();
        Assert.assertEquals(40,list.size());
    }

}