package com.jumia.task.jumiaTask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlePropNotFoundException {
    @ExceptionHandler(PropNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoRecordFoundException(PropNotFound ex)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("country code : " + ex.getProp() +" doesn't exist in lookup table");
        return errorResponse;
    }
}
