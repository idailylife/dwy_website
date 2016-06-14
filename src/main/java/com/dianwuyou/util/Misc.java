package com.dianwuyou.util;

import org.json.JSONArray;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Created by inlab-dell on 2016/6/14.
 */
public class Misc {
    public static JSONArray parseBindingFieldErrors(BindingResult bindingResult){
        JSONArray errFields = new JSONArray();
        for(FieldError fieldError: bindingResult.getFieldErrors()){
            errFields.put(fieldError.getField());
        }
        return errFields;
    }
}
