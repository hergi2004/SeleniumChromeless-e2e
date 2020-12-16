package com.seleniumtesting.demoblaze;

import java.util.HashMap;
import java.util.Map;

public enum SIGNUP_STATUS {

    /**
     *  ENUM List
     *  1. SUCCESS -- implies that the sign up is successful. with STATUS CODE of "S"
     *  2. FAILED --  implies that the sign up has failed because of incomplete submission. Lack of username or password.    with STATUS CODE of "F"
     *  3. FAILED2 --  implies that the sign up has failed because there is already an user with the same username.    with STATUS CODE of "E"
     */


    SUCCESS("Sign up successful."){
        @Override
        public String getCode(){

            return "S";
        }

    },
    FAILED("Please fill out Username and Password."){
        @Override
        public String getCode(){

            return "F";
        }
    },
    FAILED2("This user already exist."){
        @Override
        public String getCode(){

            return "E";
        }
    };

    //abstract method that can be overridden based on the enum objects
    public abstract String getCode();

    //use HashMap to construct the lookup table
    private static final Map<String, SIGNUP_STATUS> lookup = new HashMap<>();

    //Populate the lookup table with enum objects and its values
    static
    {
        for(SIGNUP_STATUS statusList : SIGNUP_STATUS.values())
        {
            lookup.put(statusList.getStatus(), statusList);
        }
    }

    //Reverse lookup
    // return the ENUM based on its values

    /**
     *
     * @param responseStatus String of the alert message returned from the website "Sign Up Successful." -- > SUCCESS (enum) or "Please fill out Username and Password." --> FAILED (enum)
     * @return Enum of matched values ( reverse lookup ) based on the responseStatus
     */
    public static SIGNUP_STATUS get(String responseStatus)
    {
        return lookup.get(responseStatus);
    }

    //instance variable
    private String status;

    //setter
    SIGNUP_STATUS(String s) {
        this.status=s;
    }

    //getter
    public String getStatus(){
        return status;
    }

    }

