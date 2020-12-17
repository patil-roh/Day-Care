package edu.neu.csye6200.daycare.objects;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private int groupID;
	private List<Student> studentList = new ArrayList<Student>(); 
	private Teacher teacher = null;
	private EnrollmentRules enrollmentRule = null;
	private int classID;
	
	public int getClassID() {
		return classID;
	}


	public void setClassID(int classID) {
		this.classID = classID;
	}


	public void addStudent(Student student) {
		this.studentList.add(student);
	}
	

	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public List<Student> getStudentList() {
		return this.studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
        
        public void delStudent(Student s){
            this.studentList.remove(s);
        }


	public EnrollmentRules getEnrollmentRule() {
		return enrollmentRule;
	}

	public void setEnrollmentRule(EnrollmentRules enrollmentRule) {
		this.enrollmentRule = enrollmentRule;
	}

	public Group(int groupID, EnrollmentRules enrollmentRule) {
		super();
		this.groupID = groupID;
		this.enrollmentRule = enrollmentRule;
	}

	public void removeStudent(int studentID) {
		
	}
	
	public void removeTeacher(int teacherID) {
			
	}
	
	public int getGroupSize() {
		return this.studentList.size();
	}

	@Override
	public String toString() {
		return "Group [groupID=" + groupID + ", enrollmentRule=" + enrollmentRule + "]";
	}
	
	public void showGroupDetails() {
		System.out.println(this.toString());
	}
}
