package sdev200fp.util;

import java.time.LocalDate;
import java.util.regex.Pattern;


public class ValidationUtils {

    //do I need constructors? I'm mostly just declaring methods to check the different input types
    //private constructor to prevent instantiation of ValidationUtils class 
    private ValidationUtils() {
    //prevent instantiation
    }
        
    //isValidName()?
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Z][a-z]+$");
    }
    //dob check
//    public static boolean isValidDate(LocalDate date){
//        return date != null && date.matches("^\\d{2}([-/])\\d{2}\\1(\\d{2}|\\d{4})$");
//    }
    //email check - I guess use regex here?
    public static boolean isValidEmail(String email){
        return email.matches("[\\w.-]+@[\\w.-]+\\.[\\w]+$");
    }
    //notes
    
    //medical info
    
    //anything else?
    
    
    //output to an alert box? I guess?
}