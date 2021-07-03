package com.jumia.task.jumiaTask.dto;

import java.util.List;
import java.util.Map;


public class PhoneDto {


    private String phone;
    private String country;
    private String countryCode;
    private Boolean validityStatus;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Boolean getValidityStatus() {
        return validityStatus;
    }

    public void setValidityStatus(Boolean status) {
        this.validityStatus = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
