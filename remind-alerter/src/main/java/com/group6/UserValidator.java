package com.group6;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.group6.model.User;

@Component
public class UserValidator implements Validator {

	   @Override
	   public boolean supports(Class<?> clazz) {
	      return User.class.isAssignableFrom(clazz);
	   }

	   @Override
	   public void validate(Object target, Errors errors) {		
	      ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
	         "username", "required.username","Field username already exist.");
	   }
}
