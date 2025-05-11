package sdev200fp.model;

import java.time.LocalDate;

//class representing Person
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected String email;
    protected LocalDate dateOfBirth;

    //no-arg constructor, creates person without details
    protected Person(){}

    //constructor for creating person with all details
    protected Person(String firstName, String lastName, String middleName, LocalDate dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    //declare abstract method getDetails()
    public abstract String getDetails();

    //get first name
    public String getFirstName() {
        return firstName;
    }
    //get last name
    public String getLastName() {
        return lastName;
    }
    
    //get middle name
    public String getMiddleName() {
        return middleName;
    }
    
    //get email
    public String getEmail() {
        return email;
    }
    //get date of birth
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    //set first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //set last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    //set email
    public void setEmail(String email){
        this.email = email;
    }
    //set date of birth
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    //return true if fields are valid
	public boolean isValid() {
		return firstName != null && lastName != null && dateOfBirth != null;
	}

	//convert to string
    @Override
	public String toString() {
		return firstName + " " + lastName + ", DOB: " + dateOfBirth;
	}
}