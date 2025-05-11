package sdev200fp.model;

import java.time.LocalTime;
import java.time.LocalDate;

//class representing an event
class Event {
	//event title
	private String title;
	//event date
	private LocalDate date;
	//event time
	private LocalTime time;
	//event location
	private String location;
	//event notes
	private String notes;

	//get title
	public String getTitle() {
		return title;
	}
	//set title
	public void setTitle(String title) {
		this.title = title;
	}

	//get date
	public LocalDate getDate() {
		return date;
	}
    
	//set date
	public void setDate(LocalDate date) {
		this.date = date;
	}

	//get time
	public LocalTime getTime() {
		return time;
	}
	//set time
	public void setTime(LocalTime time) {
		this.time = time;
	}

	//get location
	public String getLocation() {
		return location;
	}
	//set location
	public void setLocation(String location) {
		this.location = location;
	}

	//get notes
	public String getNotes() {
		return notes;
	}
	//set notes
	public void setNotes(String notes) {
		this.notes = notes;
	}

	//convert to string
	public String toString() {
		return title + " on " + date + " at " + time + " (" + location + ")";
	}
}