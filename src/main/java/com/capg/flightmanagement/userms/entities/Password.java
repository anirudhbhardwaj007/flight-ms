package com.capg.flightmanagement.userms.entities;

import com.capg.flightmanagement.exceptions.InvalidPasswordException;
import com.capg.utility.Validate;
public class Password {
    private String password;
    public Password()
    {
        this("");

    }
    public Password(String password)
    {
        Validate validate = new Validate();
        if(validate.validate(password)) {
            this.password=password;
        }
        throw new InvalidPasswordException("Password not matched with criteria");
    }
}
