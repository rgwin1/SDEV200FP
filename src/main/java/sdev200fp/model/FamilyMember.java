package sdev200fp.model;

import java.time.LocalDate;

//class representing a family member
public class FamilyMember extends Person {
	//medical information
	private String medicalInfo;
	//notes about member
	private String notes;
        
        //base64 photostring, to get added to database?
        private String photoString;
        
        public FamilyMember(){};
        public FamilyMember(String firstName, String lastName, String middleName, LocalDate dateOfBirth, String email, String medicalInfo, String notes, String photoString){
                super(firstName, lastName, middleName, dateOfBirth, email);
                this.medicalInfo = medicalInfo;
                this.notes = notes;
                this.photoString = photoString;
        }
        
        //get details override
        @Override
        public String getDetails(){
            return "First Name: " + firstName + "\nLast Name: " + lastName + "\nMiddle Name: " + middleName + "\nEmail: " + email + "\nDate of Birth: " + dateOfBirth; 
            
        }
	//get medical info
	public String getMedicalInfo() {
		return medicalInfo;
	}
        
        //get notes
	public String getNotes() {
		return notes;
	}
        
        //get photo string
        public String getPhotoString() {
            return photoString;
        }
        
        
	//set medical info
	public void setMedicalInfo(String medicalInfo) {
		this.medicalInfo = medicalInfo;
	}

	//set notes
	public void setNotes(String notes) {
		this.notes = notes;
	}
        
        //set photo string
        public void setPhotoString(String photoString){
            this.photoString = photoString;
        }


}
