package com.jumia.task.jumiaTask.utils;

import com.jumia.task.jumiaTask.dummyDataSources.DummyEnv;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidityCheckerTest {

    Environment environment = new DummyEnv();
    PhoneValidityChecker phoneValidityChecker = new PhoneValidityChecker(environment);

    @Test
    void TestValidNumber(){
        String validNumber = "(212) 698054317";
        Assert.assertEquals(true,this.phoneValidityChecker.ValidatePhoneNumber(validNumber));
    }

    @Test
    void TestInvalidNumber(){
        String invalidNumber = "(212) 6007989253";
        Assert.assertEquals(false,this.phoneValidityChecker.ValidatePhoneNumber(invalidNumber));
    }

}