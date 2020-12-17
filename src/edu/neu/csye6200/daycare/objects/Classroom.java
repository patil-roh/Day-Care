package edu.neu.csye6200.daycare.objects;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	private List<Group> groupList = new ArrayList<Group>();
	private int classroomID;
	private EnrollmentRules enrollmentRule;
	
public EnrollmentRules getEnrollmentRule() {
		return this.enrollmentRule;
	}

	public void setEnrollmentRule(EnrollmentRules enrollmentRule) {
		this.enrollmentRule = enrollmentRule;
	}



	public Classroom(int classroomID, EnrollmentRules enrollmentRule) {
		super();
		this.classroomID = classroomID;
		this.enrollmentRule = enrollmentRule;
	}

	public void addGroupObj(Group group) {
	this.groupList.add(group);
	}
	
	public List<Group> getGroupList() {
	return this.groupList;
}

public void setGroupList(List<Group> groupList) {
	this.groupList = groupList;
}

public int getClassroomID() {
	return classroomID;
}

public void setClassroomID(int classroomID) {
	this.classroomID = classroomID;
}

	public void addGroupID(int groupID) {
		
	}
	
	public void removeGroup(Group group) {
		
	}
	
	public void removeGroupID(int groupID) {
			
	}
	


	@Override
	public String toString() {
		return "Classroom has following groups\n" + getNumOfGroups() +"  and groups are "+ this.groupList + ", classroomID=" + this.classroomID;
	}

	public int getNumOfGroups() {
		return this.groupList.size();
	}
	
	public void showClassDetails() {
		System.out.println(this.toString());
	}
}
