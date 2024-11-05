package com.workintech.s19d1.utils;

import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class util {
    public static boolean isIdValid(Long id){
        if(id < 0){
            throw new ApiException("Id is not valid", HttpStatus.BAD_REQUEST);
        }else return true;
    }
}
