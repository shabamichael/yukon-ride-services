package com.yukon.ride.services.customer.service;

import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;    

@Slf4j
public class CustomerServiceLogic {
	
	
	public boolean emailValidation(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);  
            //Create instance of matcher   
            Matcher matcher = pattern.matcher(email);
    		if(matcher.matches()) {
    			return true;
    		}else {
    			
    			log.info("Email address is invalid");
    			return false;
    		}
 
		}

}
