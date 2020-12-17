package edu.neu.csye6200.daycare.objects;

import java.util.List;

public class Teacher extends Person {
	private int teacherID;
	private int groupID;
	private int classID;
	private boolean isAvailable;
	private String address;
        private String uName;
        private String password;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
        
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	private String phoneNumber;

	public Teacher(String firstName, String lastName, int teacherID, boolean isAvailable, String address, String phoneNumber, String uName, String password) {
		super(firstName, lastName);
		this.teacherID = teacherID;
		this.isAvailable = isAvailable;
		this.address= address;
		this.phoneNumber = phoneNumber;
                this.uName=uName;
                this.password=password;
	}

	public boolean getisAvailable() {
		return this.isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getTeacherID() {
		return this.teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getClassID() {
		return this.classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}
        
       

    @Override
    public String toString() {
        return  teacherID+"";
      
    }
        
}
