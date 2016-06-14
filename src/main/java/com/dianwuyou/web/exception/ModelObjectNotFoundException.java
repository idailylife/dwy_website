package com.dianwuyou.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by inlab-dell on 2016/6/14.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cannot find target model resource or object")
public final class ModelObjectNotFoundException extends RuntimeException{
    public ModelObjectNotFoundException(){
        super();
    }

    public ModelObjectNotFoundException(String message){
        super(message);
    }
}
