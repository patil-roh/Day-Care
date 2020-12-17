package edu.neu.csye6200.Application;

import javax.swing.SwingUtilities;

import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.views.DriverFrame;
 
public class Driver {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    createAndShowGUI();
	                } catch (Exception e) {
	                	e.printStackTrace();
	                						}
	            	}
		});
}
	
	public static void createAndShowGUI() throws Exception {
		DriverFrame df = new DriverFrame();
        df.setVisible(true);
    }

	
/**
 * OUTPUT
 * Init components complete
DayCare Demo 
Writing to file demo.csv complete
Date updated
DayCare Factory obj created
DayCare obj  created
Rules factory obj  created
6-12,			4, 			4:1, 			3
13-24,			5, 			5:1, 			3
25-35,			6, 			6:1, 			3
36-47,			8, 			8:1, 			3
48-59,			12, 			12:1, 			2
60-100,			15, 			15:1, 			2
Rule objs created
Writing to file enrollmentRules.csv complete
Student Factory obj
Teacher Factory obj
Reading from file teacher.csv complete
Teacher File read successfully
Reading from file student.csv complete
Student File read successfully
Student ID in initStudentObj is 1
Student ID in initStudentObj is 2
Student ID in initStudentObj is 3
Student ID in initStudentObj is 4
Student ID in initStudentObj is 5
Student ID in initStudentObj is 6
Student ID in initStudentObj is 7
Student ID in initStudentObj is 8
Student ID in initStudentObj is 9
Student ID in initStudentObj is 10
Student ID in initStudentObj is 11
Student ID in initStudentObj is 12
Student ID in initStudentObj is 13
Student ID in initStudentObj is 14
Student ID in initStudentObj is 15
Student ID in initStudentObj is 16
Student ID in initStudentObj is 17
Student ID in initStudentObj is 18
Student ID in initStudentObj is 19
Student ID in initStudentObj is 20
Age group mismatch
Age group mismatch
Age group mismatch
Age group mismatch
Rule found
Applicable rule is 48-59
No classrooms available, new class created
No groups available, new group created
groupID set
classID set
Student Enrollemnt Complete
studentID=1,groupID=0, classID=0, fatherName=Emma Tompson, motherName=Jimmy Tompson, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=0, age=53, address=#60 St Germain Street, phoneNumber=8888888888DOB: Tue Jun 23 00:00:00 EDT 2015
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Age group mismatch
Rule found
Applicable rule is 36-47
Class rule mismatch
classroomFound is false  groupFound  false
Class and group not found
Creating new class and group
groupID set
classID set
Student Enrollemnt Complete
studentID=2,groupID=0, classID=1, fatherName=Isabella George, motherName=Sally George, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=1, age=39, address=#60 St Germain Street, phoneNumber=8888888888DOB: Tue Aug 23 00:00:00 EDT 2016
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Age group mismatch
Rule found
Applicable rule is 36-47
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+12 group.getEnrollmentRule().getGroupSize() 8
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=3,groupID=0, classID=1, fatherName=Madison Edwen, motherName=Lizzy Edwen, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=1, age=36, address=#60 St Germain Street, phoneNumber=8888888888DOB: Wed Nov 23 00:00:00 EST 2016
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Rule found
Applicable rule is 25-35
Class rule mismatch
Class rule mismatch
classroomFound is false  groupFound  false
Class and group not found
Creating new class and group
groupID set
classID set
Student Enrollemnt Complete
studentID=4,groupID=0, classID=2, fatherName=Olivia James, motherName=Markie James, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=2, age=35, address=#60 St Germain Street, phoneNumber=8888888888DOB: Fri Dec 23 00:00:00 EST 2016
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Age group mismatch
Rule found
Applicable rule is 36-47
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+13 group.getEnrollmentRule().getGroupSize() 8
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=5,groupID=0, classID=1, fatherName=Mia Dep, motherName=Johnny Dep, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=1, age=44, address=#60 St Germain Street, phoneNumber=8888888888DOB: Wed Mar 23 00:00:00 EDT 2016
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Age group mismatch
Rule found
Applicable rule is 36-47
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+14 group.getEnrollmentRule().getGroupSize() 8
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=6,groupID=0, classID=1, fatherName=Elizabeth Higgins, motherName=Bobby Higgins, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=1, age=42, address=#60 St Germain Street, phoneNumber=8888888888DOB: Mon May 23 00:00:00 EDT 2016
Student Enrollemnt Complete

Age group mismatch
Rule found
Applicable rule is 13-24
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroomFound is false  groupFound  false
Class and group not found
Creating new class and group
groupID set
classID set
Student Enrollemnt Complete
studentID=7,groupID=0, classID=3, fatherName=Addison Hill, motherName=Billy Hill, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=3, age=16, address=#60 St Germain Street, phoneNumber=8888888888DOB: Mon Jul 23 00:00:00 EDT 2018
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Rule found
Applicable rule is 25-35
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+12 group.getEnrollmentRule().getGroupSize() 6
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=8,groupID=0, classID=2, fatherName=Alyssa Jane, motherName=Evie Jane, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=2, age=28, address=#60 St Germain Street, phoneNumber=8888888888DOB: Sun Jul 23 00:00:00 EDT 2017
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Rule found
Applicable rule is 25-35
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+13 group.getEnrollmentRule().getGroupSize() 6
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=9,groupID=0, classID=2, fatherName=Hannah Smith, motherName=Becky Smith, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=2, age=27, address=#60 St Germain Street, phoneNumber=8888888888DOB: Wed Aug 23 00:00:00 EDT 2017
Student Enrollemnt Complete

Age group mismatch
Rule found
Applicable rule is 13-24
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+12 group.getEnrollmentRule().getGroupSize() 5
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=10,groupID=0, classID=3, fatherName=Alexis Christin, motherName=Jessie Christin, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=3, age=23, address=#60 St Germain Street, phoneNumber=8888888888DOB: Sat Dec 23 00:00:00 EST 2017
Student Enrollemnt Complete

Age group mismatch
Rule found
Applicable rule is 13-24
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+13 group.getEnrollmentRule().getGroupSize() 5
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=11,groupID=0, classID=3, fatherName=Alyssa Chan, motherName=Jackie Chan, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=3, age=18, address=#60 St Germain Street, phoneNumber=8888888888DOB: Wed May 23 00:00:00 EDT 2018
Student Enrollemnt Complete

Age group mismatch
Rule found
Applicable rule is 13-24
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+14 group.getEnrollmentRule().getGroupSize() 5
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=12,groupID=0, classID=3, fatherName=Ashley Florance, motherName=Laurie Florance, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=3, age=22, address=#60 St Germain Street, phoneNumber=8888888888DOB: Tue Jan 23 00:00:00 EST 2018
Student Enrollemnt Complete

Age group mismatch
Rule found
Applicable rule is 13-24
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+15 group.getEnrollmentRule().getGroupSize() 5
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=13,groupID=0, classID=3, fatherName=Ella Methew, motherName=Cathey Methew, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=3, age=17, address=#60 St Germain Street, phoneNumber=8888888888DOB: Sat Jun 23 00:00:00 EDT 2018
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Age group mismatch
Age group mismatch
Age group mismatch
Rule found
Applicable rule is 60-100
Class rule mismatch
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroomFound is false  groupFound  false
Class and group not found
Creating new class and group
groupID set
classID set
Student Enrollemnt Complete
studentID=14,groupID=0, classID=4, fatherName=Sarah Tompson, motherName=Millie Tompson, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=4, age=63, address=#60 St Germain Street, phoneNumber=8888888888DOB: Sat Aug 23 00:00:00 EDT 2014
Student Enrollemnt Complete

Age group mismatch
Rule found
Applicable rule is 13-24
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+16 group.getEnrollmentRule().getGroupSize() 5
Group is full
Vacant classroom available, group is full, creating new group
inputs for creating new group are 1  EnrollmentRules [minAge=13, maxAge=24, ageRange=13-24, groupSize=5, ratio=5:1, maxGroup=3]
check ***  1  1   5
groupID set
classID set
Student Enrollemnt Complete
studentID=15,groupID=1, classID=3, fatherName=Taylor Jesus, motherName=Ruthie Jesus, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=1, classID=3, age=16, address=#60 St Germain Street, phoneNumber=8888888888DOB: Mon Jul 23 00:00:00 EDT 2018
Student Enrollemnt Complete

Age group mismatch
Rule found
Applicable rule is 13-24
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  2  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+16 group.getEnrollmentRule().getGroupSize() 5
Group is full
group.getGroupSize()+12 group.getEnrollmentRule().getGroupSize() 5
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=16,groupID=1, classID=3, fatherName=Grace Mart, motherName=Stanley Mart, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=1, classID=3, age=15, address=#60 St Germain Street, phoneNumber=8888888888DOB: Thu Aug 23 00:00:00 EDT 2018
Student Enrollemnt Complete

Rule found
Applicable rule is 6-12
Class rule mismatch
Class rule mismatch
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroomFound is false  groupFound  false
Class and group not found
Creating new class and group
groupID set
classID set
Student Enrollemnt Complete
studentID=17,groupID=0, classID=5, fatherName=Lily Mandery, motherName=Mary Mandery, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=5, age=12, address=#60 St Germain Street, phoneNumber=8888888888DOB: Fri Nov 23 00:00:00 EST 2018
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Age group mismatch
Age group mismatch
Age group mismatch
Rule found
Applicable rule is 60-100
Class rule mismatch
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  2
group.getGroupSize()+12 group.getEnrollmentRule().getGroupSize() 15
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=18,groupID=0, classID=4, fatherName=Kylie Johns, motherName=Annie Johns, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=4, age=63, address=#60 St Germain Street, phoneNumber=8888888888DOB: Sat Aug 23 00:00:00 EDT 2014
Student Enrollemnt Complete

Rule found
Applicable rule is 6-12
Class rule mismatch
Class rule mismatch
Class rule mismatch
Class rule mismatch
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+12 group.getEnrollmentRule().getGroupSize() 4
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=19,groupID=0, classID=5, fatherName=Brooke Karren, motherName=Karlly Karren, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=5, age=11, address=#60 St Germain Street, phoneNumber=8888888888DOB: Sun Dec 23 00:00:00 EST 2018
Student Enrollemnt Complete

Age group mismatch
Age group mismatch
Age group mismatch
Rule found
Applicable rule is 36-47
Class rule mismatch
classroom.getNumOfGroups()  1  classroom.getEnrollmentRule().getMaxGroup()  3
group.getGroupSize()+15 group.getEnrollmentRule().getGroupSize() 8
Group with vacancy found
groupID set
classID set
Student Enrollemnt Complete
studentID=20,groupID=0, classID=1, fatherName=Ramesh, motherName=Subhashini, dateOfJoining=Sat Nov 23 00:00:00 EST 2019, groupID=0, classID=1, age=47, address=#60 St Germain, phoneNumber=1234567890DOB: Fri Dec 11 00:00:00 EST 2015
Student Enrollemnt Complete

INITIALIZATION COMPLETE
Reading from file Student_Immunization_Record.csv complete
DayCare Demo Done
DayCare Demo Done

ClassID:0	Age group:48-59months
	GroupID:0   Teacher Assigned:TeaOneName

ClassID:1	Age group:36-47months
	GroupID:0   Teacher Assigned:TeaTwoName

ClassID:2	Age group:25-35months
	GroupID:0   Teacher Assigned:TeathreeName

ClassID:3	Age group:13-24months
	GroupID:0   Teacher Assigned:TeafourName

	GroupID:1   Teacher Assigned:TeasixName

ClassID:4	Age group:60-100months
	GroupID:0   Teacher Assigned:TeafiveName

ClassID:5	Age group:6-12months
	GroupID:0   Teacher Assigned:TeasevenName

ClassID:0	Age group:48-59months
	GroupID:0   Teacher Assigned:TeaOneName
Student ID : 1
Hib  2016-09-23T00:00
1
Is Immune: false
Is overdue: true
DTap  2015-12-23T00:00
2
Is Immune: false
Is overdue: true
Polio  2015-12-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2015-06-23T00:00
3
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false

ClassID:1	Age group:36-47months
	GroupID:0   Teacher Assigned:TeaTwoName
Student ID : 2
Hib  2016-12-23T00:00
3
Is Immune: false
Is overdue: true
DTap  2017-02-23T00:00
2
Is Immune: false
Is overdue: true
Polio  2017-02-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2016-08-23T00:00
3
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false
Student ID : 3
Hib  2017-05-23T00:00
2
Is Immune: false
Is overdue: true
DTap  2017-05-23T00:00
2
Is Immune: false
Is overdue: true
Polio  2017-05-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2016-11-23T00:00
3
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false
Student ID : 5
Hib  2016-05-23T00:00
4
Is Immune: false
Is overdue: true
DTap  2016-09-23T00:00
2
Is Immune: false
Is overdue: true
Polio  2016-09-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2016-03-23T00:00
3
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  2016-03-23T00:00
1
Is Immune: false
Is overdue: true
Student ID : 6
Hib  2016-09-23T00:00
3
Is Immune: false
Is overdue: true
DTap  2016-11-23T00:00
2
Is Immune: false
Is overdue: true
Polio  2016-11-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2016-07-23T00:00
2
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false
Student ID : 20
Hib  2016-04-11T00:00
3
Is Immune: false
Is overdue: true
DTap  2016-06-11T00:00
2
Is Immune: false
Is overdue: true
Polio  2015-12-11T00:00
3
Is Immune: false
Is overdue: true
Hepatitis B  2015-12-11T00:00
3
Is Immune: false
Is overdue: true
MMR  2015-12-11T00:00
1
Is Immune: false
Is overdue: true
Varicella  2015-12-11T00:00
1
Is Immune: false
Is overdue: true

ClassID:2	Age group:25-35months
	GroupID:0   Teacher Assigned:TeathreeName
Student ID : 4
Hib  2017-04-23T00:00
3
Is Immune: false
Is overdue: true
DTap  2017-06-23T00:00
2
Is Immune: false
Is overdue: true
Polio  2017-06-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2016-12-23T00:00
3
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  2016-12-23T00:00
1
Is Immune: false
Is overdue: true
Student ID : 8
Hib  2017-11-23T00:00
3
Is Immune: false
Is overdue: true
DTap  2017-11-23T00:00
3
Is Immune: false
Is overdue: true
Polio  2018-01-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2017-09-23T00:00
2
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false
Student ID : 9
Hib  2017-12-23T00:00
3
Is Immune: false
Is overdue: true
DTap  2017-12-23T00:00
3
Is Immune: false
Is overdue: true
Polio  2018-02-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2017-10-23T00:00
2
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false

ClassID:3	Age group:13-24months
	GroupID:0   Teacher Assigned:TeafourName
Student ID : 7
Hib  2018-11-23T00:00
3
Is Immune: false
Is overdue: true
DTap  2018-11-23T00:00
3
Is Immune: false
Is overdue: true
Polio  2019-01-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2018-09-23T00:00
2
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false
Student ID : 10
Hib  2018-06-23T00:00
2
Is Immune: false
Is overdue: true
DTap  2018-06-23T00:00
2
Is Immune: false
Is overdue: true
Polio  2018-12-23T00:00
1
Is Immune: false
Is overdue: true
Hepatitis B  2019-03-23T00:00
1
Is Immune: false
Is overdue: true
MMR  2017-12-23T00:00
1
Is Immune: false
Is overdue: true
Varicella  2017-12-23T00:00
1
Is Immune: false
Is overdue: true
Student ID : 11
Hib  2019-08-23T00:00
1
Is Immune: false
Is overdue: true
DTap  2018-11-23T00:00
2
Is Immune: false
Is overdue: true
Polio  2018-11-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2018-07-23T00:00
2
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  2018-05-23T00:00
1
Is Immune: false
Is overdue: true
Student ID : 12
Hib  2018-03-23T00:00
4
Is Immune: false
Is overdue: true
DTap  2018-03-23T00:00
4
Is Immune: false
Is overdue: true
Polio  2018-01-23T00:00
3
Is Immune: false
Is overdue: true
Hepatitis B  2018-01-23T00:00
3
Is Immune: false
Is overdue: true
MMR  2018-01-23T00:00
1
Is Immune: false
Is overdue: true
Varicella  null
0
Is Immune: true
Is overdue: false
Student ID : 13
Hib  2018-10-23T00:00
3
Is Immune: false
Is overdue: true
DTap  2018-10-23T00:00
3
Is Immune: false
Is overdue: true
Polio  2018-12-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2018-08-23T00:00
2
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false

	GroupID:1   Teacher Assigned:TeasixName
Student ID : 15
Hib  2019-01-23T00:00
2
Is Immune: false
Is overdue: true
DTap  2019-01-23T00:00
2
Is Immune: false
Is overdue: true
Polio  2019-01-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2018-07-23T00:00
3
Is Immune: false
Is overdue: true
MMR  2018-07-23T00:00
1
Is Immune: false
Is overdue: true
Varicella  2018-07-23T00:00
1
Is Immune: false
Is overdue: true
Student ID : 16
Hib  2019-02-23T00:00
2
Is Immune: false
Is overdue: true
DTap  2018-12-23T00:00
3
Is Immune: false
Is overdue: true
Polio  2019-02-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2018-10-23T00:00
2
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false

ClassID:4	Age group:60-100months
	GroupID:0   Teacher Assigned:TeafiveName
Student ID : 14
Hib  2014-12-23T00:00
3
Is Immune: false
Is overdue: true
DTap  2014-12-23T00:00
3
Is Immune: false
Is overdue: true
Polio  2015-02-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2014-10-23T00:00
2
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  null
0
Is Immune: true
Is overdue: false
Student ID : 18
Hib  2014-10-23T00:00
4
Is Immune: false
Is overdue: true
DTap  2014-10-23T00:00
4
Is Immune: false
Is overdue: true
Polio  2014-08-23T00:00
3
Is Immune: false
Is overdue: true
Hepatitis B  2014-08-23T00:00
3
Is Immune: false
Is overdue: true
MMR  2014-08-23T00:00
1
Is Immune: false
Is overdue: true
Varicella  2014-08-23T00:00
1
Is Immune: false
Is overdue: true

ClassID:5	Age group:6-12months
	GroupID:0   Teacher Assigned:TeasevenName
Student ID : 17
Hib  2019-01-23T00:00
4
Is Immune: false
Is overdue: true
DTap  2019-01-23T00:00
4
Is Immune: false
Is overdue: true
Polio  2018-11-23T00:00
3
Is Immune: false
Is overdue: true
Hepatitis B  2018-11-23T00:00
3
Is Immune: false
Is overdue: true
MMR  2018-11-23T00:00
1
Is Immune: false
Is overdue: true
Varicella  2018-11-23T00:00
1
Is Immune: false
Is overdue: true
Student ID : 19
Hib  2019-02-23T00:00
4
Is Immune: false
Is overdue: true
DTap  2019-02-23T00:00
4
Is Immune: false
Is overdue: true
Polio  2019-06-23T00:00
2
Is Immune: false
Is overdue: true
Hepatitis B  2018-12-23T00:00
3
Is Immune: false
Is overdue: true
MMR  null
0
Is Immune: true
Is overdue: false
Varicella  2018-12-23T00:00
1
Is Immune: false
Is overdue: true
Main page init components complete
Admin init components complete
TrackImmunisationRecord init components complete

ClassID:0	Age group:48-59months
	GroupID:0   Teacher Assigned:TeaOneName
1,Aron,Tompson
ImmunizationData  1,Aron,Tompson

ClassID:1	Age group:36-47months
	GroupID:0   Teacher Assigned:TeaTwoName
2,Jacob,George
ImmunizationData  2,Jacob,George
3,Ethan,Edwen
ImmunizationData  3,Ethan,Edwen
5,Alexander,Dep
ImmunizationData  5,Alexander,Dep
6,Christopher,Higgins
ImmunizationData  6,Christopher,Higgins
20,Kiran,Ramesh
ImmunizationData  20,Kiran,Ramesh

ClassID:2	Age group:25-35months
	GroupID:0   Teacher Assigned:TeathreeName
4,Joshua,James
ImmunizationData  4,Joshua,James
8,Ryan,Jane
ImmunizationData  8,Ryan,Jane
9,John,Smith
ImmunizationData  9,John,Smith

ClassID:3	Age group:13-24months
	GroupID:0   Teacher Assigned:TeafourName
7,Jayden,Hill
ImmunizationData  7,Jayden,Hill
10,Logan,Christin
ImmunizationData  10,Logan,Christin
11,Elijah,Chan
ImmunizationData  11,Elijah,Chan
12,Jonathan,Florance
ImmunizationData  12,Jonathan,Florance
13,Samuel,Methew
ImmunizationData  13,Samuel,Methew

	GroupID:1   Teacher Assigned:TeasixName
15,William,Jesus
ImmunizationData  15,William,Jesus
16,James,Mart
ImmunizationData  16,James,Mart

ClassID:4	Age group:60-100months
	GroupID:0   Teacher Assigned:TeafiveName
14,Jack,Tompson
ImmunizationData  14,Jack,Tompson
18,Luke,Johns
ImmunizationData  18,Luke,Johns

ClassID:5	Age group:6-12months
	GroupID:0   Teacher Assigned:TeasevenName
17,Tyler,Mandery
ImmunizationData  17,Tyler,Mandery
19,Connor,Karren
ImmunizationData  19,Connor,Karren
1,Aron,Tompson,2016-09-23T00:00,2015-12-23T00:00,2015-12-23T00:00,2015-06-23T00:00
2,Jacob,George,2016-12-23T00:00,2017-02-23T00:00,2017-02-23T00:00,2016-08-23T00:00
3,Ethan,Edwen,2017-05-23T00:00,2017-05-23T00:00,2017-05-23T00:00,2016-11-23T00:00
5,Alexander,Dep,2016-05-23T00:00,2016-09-23T00:00,2016-09-23T00:00,2016-03-23T00:00,2016-03-23T00:00
6,Christopher,Higgins,2016-09-23T00:00,2016-11-23T00:00,2016-11-23T00:00,2016-07-23T00:00
20,Kiran,Ramesh,2016-04-11T00:00,2016-06-11T00:00,2015-12-11T00:00,2015-12-11T00:00,2015-12-11T00:00,2015-12-11T00:00
4,Joshua,James,2017-04-23T00:00,2017-06-23T00:00,2017-06-23T00:00,2016-12-23T00:00,2016-12-23T00:00
8,Ryan,Jane,2017-11-23T00:00,2017-11-23T00:00,2018-01-23T00:00,2017-09-23T00:00
9,John,Smith,2017-12-23T00:00,2017-12-23T00:00,2018-02-23T00:00,2017-10-23T00:00
7,Jayden,Hill,2018-11-23T00:00,2018-11-23T00:00,2019-01-23T00:00,2018-09-23T00:00
10,Logan,Christin,2018-06-23T00:00,2018-06-23T00:00,2018-12-23T00:00,2019-03-23T00:00,2017-12-23T00:00,2017-12-23T00:00
11,Elijah,Chan,2019-08-23T00:00,2018-11-23T00:00,2018-11-23T00:00,2018-07-23T00:00,2018-05-23T00:00
12,Jonathan,Florance,2018-03-23T00:00,2018-03-23T00:00,2018-01-23T00:00,2018-01-23T00:00,2018-01-23T00:00
13,Samuel,Methew,2018-10-23T00:00,2018-10-23T00:00,2018-12-23T00:00,2018-08-23T00:00
15,William,Jesus,2019-01-23T00:00,2019-01-23T00:00,2019-01-23T00:00,2018-07-23T00:00,2018-07-23T00:00,2018-07-23T00:00
16,James,Mart,2019-02-23T00:00,2018-12-23T00:00,2019-02-23T00:00,2018-10-23T00:00
14,Jack,Tompson,2014-12-23T00:00,2014-12-23T00:00,2015-02-23T00:00,2014-10-23T00:00
18,Luke,Johns,2014-10-23T00:00,2014-10-23T00:00,2014-08-23T00:00,2014-08-23T00:00,2014-08-23T00:00,2014-08-23T00:00
17,Tyler,Mandery,2019-01-23T00:00,2019-01-23T00:00,2018-11-23T00:00,2018-11-23T00:00,2018-11-23T00:00,2018-11-23T00:00
19,Connor,Karren,2019-02-23T00:00,2019-02-23T00:00,2019-06-23T00:00,2018-12-23T00:00,2018-12-23T00:00
AnnualRegistration init components complete
Enrollment list call
getEnrollmentStatus
period age is 360
studentData is 1,Aron,Tompson,11/23/2019,11/23/2020,360
period age is 360
studentData is 2,Jacob,George,11/23/2019,11/23/2020,360
period age is 360
studentData is 3,Ethan,Edwen,11/23/2019,11/23/2020,360
period age is 360
studentData is 5,Alexander,Dep,11/23/2019,11/23/2020,360
period age is 360
studentData is 6,Christopher,Higgins,11/23/2019,11/23/2020,360
period age is 360
studentData is 20,Kiran,Ramesh,11/23/2019,11/23/2020,360
period age is 360
studentData is 4,Joshua,James,11/23/2019,11/23/2020,360
period age is 360
studentData is 8,Ryan,Jane,11/23/2019,11/23/2020,360
period age is 360
studentData is 9,John,Smith,11/23/2019,11/23/2020,360
period age is 360
studentData is 7,Jayden,Hill,11/23/2019,11/23/2020,360
period age is 360
studentData is 10,Logan,Christin,11/23/2019,11/23/2020,360
period age is 360
studentData is 11,Elijah,Chan,11/23/2019,11/23/2020,360
period age is 360
studentData is 12,Jonathan,Florance,11/23/2019,11/23/2020,360
period age is 360
studentData is 13,Samuel,Methew,11/23/2019,11/23/2020,360
period age is 360
studentData is 15,William,Jesus,11/23/2019,11/23/2020,360
period age is 360
studentData is 16,James,Mart,11/23/2019,11/23/2020,360
period age is 360
studentData is 14,Jack,Tompson,11/23/2019,11/23/2020,360
period age is 360
studentData is 18,Luke,Johns,11/23/2019,11/23/2020,360
period age is 360
studentData is 17,Tyler,Mandery,11/23/2019,11/23/2020,360
period age is 360
studentData is 19,Connor,Karren,11/23/2019,11/23/2020,360
[1,Aron,Tompson,11/23/2019,11/23/2020,360, 2,Jacob,George,11/23/2019,11/23/2020,360, 3,Ethan,Edwen,11/23/2019,11/23/2020,360, 5,Alexander,Dep,11/23/2019,11/23/2020,360, 6,Christopher,Higgins,11/23/2019,11/23/2020,360, 20,Kiran,Ramesh,11/23/2019,11/23/2020,360, 4,Joshua,James,11/23/2019,11/23/2020,360, 8,Ryan,Jane,11/23/2019,11/23/2020,360, 9,John,Smith,11/23/2019,11/23/2020,360, 7,Jayden,Hill,11/23/2019,11/23/2020,360, 10,Logan,Christin,11/23/2019,11/23/2020,360, 11,Elijah,Chan,11/23/2019,11/23/2020,360, 12,Jonathan,Florance,11/23/2019,11/23/2020,360, 13,Samuel,Methew,11/23/2019,11/23/2020,360, 15,William,Jesus,11/23/2019,11/23/2020,360, 16,James,Mart,11/23/2019,11/23/2020,360, 14,Jack,Tompson,11/23/2019,11/23/2020,360, 18,Luke,Johns,11/23/2019,11/23/2020,360, 17,Tyler,Mandery,11/23/2019,11/23/2020,360, 19,Connor,Karren,11/23/2019,11/23/2020,360]
studentData is [1,Aron,Tompson,11/23/2019,11/23/2020,360, 2,Jacob,George,11/23/2019,11/23/2020,360, 3,Ethan,Edwen,11/23/2019,11/23/2020,360, 5,Alexander,Dep,11/23/2019,11/23/2020,360, 6,Christopher,Higgins,11/23/2019,11/23/2020,360, 20,Kiran,Ramesh,11/23/2019,11/23/2020,360, 4,Joshua,James,11/23/2019,11/23/2020,360, 8,Ryan,Jane,11/23/2019,11/23/2020,360, 9,John,Smith,11/23/2019,11/23/2020,360, 7,Jayden,Hill,11/23/2019,11/23/2020,360, 10,Logan,Christin,11/23/2019,11/23/2020,360, 11,Elijah,Chan,11/23/2019,11/23/2020,360, 12,Jonathan,Florance,11/23/2019,11/23/2020,360, 13,Samuel,Methew,11/23/2019,11/23/2020,360, 15,William,Jesus,11/23/2019,11/23/2020,360, 16,James,Mart,11/23/2019,11/23/2020,360, 14,Jack,Tompson,11/23/2019,11/23/2020,360, 18,Luke,Johns,11/23/2019,11/23/2020,360, 17,Tyler,Mandery,11/23/2019,11/23/2020,360, 19,Connor,Karren,11/23/2019,11/23/2020,360]
Main page init components complete


 */
}
