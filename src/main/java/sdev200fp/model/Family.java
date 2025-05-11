package sdev200fp.model;

import java.util.ArrayList;
import java.util.List;

//class representing a family group
class Family {
	//list of members
	private List<FamilyMember> members = new ArrayList<>();
	//family name
	private String familyName;

	//add member to list
	public void addMember(FamilyMember member) {
		members.add(member);
	}
	//remove member from list
	public void removeMember(FamilyMember member) {
		members.remove(member);
	}
	//get list of members
	public List<FamilyMember> getMembers() {
		return members;
	}

	//get family name
	public String getFamilyName() {
		return familyName;
	}
	//set family name
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	//find member by first name
	public FamilyMember findMember(String name) {
		for (FamilyMember member : members) {
			if (member.getFirstName().equalsIgnoreCase(name)) {
				return member;
			}
		}
		return null;
	}
}
