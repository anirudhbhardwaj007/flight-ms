package com.capg.flightmanagement.login;


import com.capg.flightmanagement.exceptions.ShorterLengthException;
import com.capg.flightmanagement.exceptions.UserNotFoundException;
import com.capg.flightmanagement.util.Validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class UiLogin extends AuthenticationDaoImpl {

    // provide your own store that contain username, password
    Map<String, String> store = new HashMap();

    public UiLogin() {
        store.put("anirudh", "anirudh");
        store.put("harsh", "harsh");
        store.put("anushka", "anushka");
        store.put("shivam", "shivam");
        store.put("rashmi", "rashmi");
    }

    public static void main(String... args) {
        new UiLogin().exe(new Scanner(System.in));
    }

    public void exe(Scanner in) {
        String username = null;
        String password = null;

        Validate vd = new Validate();
        System.out.println("Enter username");
        username = in.next();

        System.out.println("Enter password");
        password = in.next();

        try {

//			if(!vd.validate(password)) {
//				out.println("min length should be six and max is 15, only include -, _ , *");
//			}

            if (username == null || password == null) {
                throw new NullPointerException("either username or password is null");
            } else if (username.length() == 0 || password.length() == 0) {
                throw new IllegalArgumentException("either username or password is empty");
            }
//			else if(username.length()<6 || password.length()<6) {
//				throw new ShorterLengthException("username or password length is less then minimum length six");
//			}
            else {
                System.out.println(this.login(username, password));
            }
        } catch (UserNotFoundException e) {
            out.println(e);
        } catch (ShorterLengthException e) {
            out.println(e);
        } catch (NullPointerException e) {
            out.println(e);
        } catch (IllegalArgumentException e) {
            out.println(e);
        }


    }

    @Override
    public Map store() {
        return this.store;
    }

}
