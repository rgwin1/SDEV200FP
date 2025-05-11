package sdev200fp.model;

import java.time.LocalDate;

//class representing a task assigned to a family member
class Task {
	//task description
	private String description;
	//due date
	private LocalDate dueDate;
	//assigned member
	private FamilyMember assignedTo;
	//task status
	private boolean completed;

	//get description
	public String getDescription() {
		return description;
	}
	//set description
	public void setDescription(String description) {
		this.description = description;
	}

	//get due date
	public LocalDate getDueDate() {
		return dueDate;
	}
	//set due date
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	//get assigned member
	public FamilyMember getAssignedTo() {
		return assignedTo;
	}
	//set assigned member
	public void setAssignedTo(FamilyMember assignedTo) {
		this.assignedTo = assignedTo;
	}

	//return true if task is complete
	public boolean isCompleted() {
		return completed;
	}
	//set completion status
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	//convert to string
	public String toString() {
		return description + ", Due: " + dueDate + ", Assigned to: " + (assignedTo != null ? assignedTo.getFirstName() : "None");
	}
}