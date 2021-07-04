package com.jumia.task.jumiaTask.exceptions;

public class PropNotFound extends RuntimeException{
    String prop;
    public PropNotFound(String prop){
        super();
        this.prop =prop;
    }
    public String getProp() {
        return prop;
    }
}
