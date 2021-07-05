package com.jumia.task.jumiaTask.controller;


import com.jumia.task.jumiaTask.dto.PhoneDto;
import com.jumia.task.jumiaTask.service.PhoneService;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {

    PhoneService phoneService;

    PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

//    @GetMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
//            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @GetMapping
    public ResponseEntity getListOfPhonesWithCorrespondingCountries(@RequestParam(name = "valid", required = false) Optional<Boolean> validFilter
            , @RequestParam(name = "country", required = false) Optional<String> countryFilter
    ) {
        List<PhoneDto> response = this.phoneService.getAllPhoneNumbersWithRequestedFilters(validFilter, countryFilter);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
