package org.tenement.jbuseratom.utils;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class ValidationUtils {

    private ValidationUtils() {}

    public static Map<String,String> getFieldErrors(BindingResult bindingResult){
        return getFieldErrors(bindingResult,null);
    }

    public static Map<String,String> getFieldErrors(BindingResult bindingResult, String suffix){
        if(suffix == null) {
            suffix = "";
        }
        String value = suffix;
        Map<String,String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> {
            errors.put(value + error.getField(),error.getCode());
        });
        return errors;
    }
}
