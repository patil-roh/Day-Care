package edu.neu.csye6200.daycare.objects;

import java.io.FileWriter;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.factory.ImmunizationFactory;
import edu.neu.csye6200.daycare.factory.StudentFactory;
import edu.neu.csye6200.daycare.factory.TeacherFactory;
import edu.neu.csye6200.daycare.util.FileUtil;

import org.omg.CORBA.DynAnyPackage.InvalidValue;

public class DayCare {
	private List<Classroom> classroomList = new ArrayList<Classroom>();
	private List<Teacher> teacherList = new ArrayList<Teacher>();
	private List<EnrollmentRules> enrollmentruleList = null;
	private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
	private ImmunizationFactory immunizationFactoryInstance;

	public DayCare() {
		super();
		this.immunizationFactoryInstance = ImmunizationFactory.getInstance();
	}

	public ImmunizationFactory getImmunizationFactoryInstance() {
		return immunizationFactoryInstance;
	}

	public void setImmunizationFactoryInstance(ImmunizationFactory immunizationFactoryInstance) {
		this.immunizationFactoryInstance = immunizationFactoryInstance;
	}
	private HashMap<Integer, Student> studentMap= new HashMap<Integer, Student>();
	
	
	public HashMap getstudentMap() {
		return this.studentMap;
	}
	
	
	
	public List<EnrollmentRules> getEnrollmentruleList() {
		return this.enrollmentruleList;
	}

	public void setEnrollmentruleList(List<EnrollmentRules> enrollmentruleList) {
		this.enrollmentruleList = enrollmentruleList;
	}

	public void addClassroom(Classroom classroom) {
		this.classroomList.add(classroom);
	}
	
	public void removeClassroom(Classroom classroom) {
		
	}
	
	public List<Teacher> getTeacherList() {
		return this.teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	public void addClassroomID(int classroomID) {
		
	}
	
	public void removeClassroomID(Classroom classroomID) {
		
	}

	public void showDayCareDetails() {
		this.toString();
	}
	
	public List<Classroom> getClassroomList() {
		return classroomList;
	}

	public void setClassroomList(List<Classroom> classroomList) {
		this.classroomList = classroomList;
	}
	
	public void showTeacherListDetails() {
		for (Teacher teacher : this.teacherList) {
			System.out.println("teacher ID "+teacher.getTeacherID()+" teacher availability "+teacher.getisAvailable());
			if (teacher.getisAvailable()) {
				System.out.println("teacher is available to be assigned to a group");
			}
		}
	}
	
	
	public EnrollmentRules getApplicableEnrollmentRule(int age) throws InvalidValue {
		for (EnrollmentRules enrollmentRules : this.getEnrollmentruleList()) {
			if((enrollmentRules.getMinAge()<= age && age <= enrollmentRules.getMaxAge())) {
				System.out.println("Rule found");
				return enrollmentRules;
			}
			else {
				System.out.println("Age group mismatch");	
			}
		}
		throw new InvalidValue("Invalid Age input for Student");
		
	}
	
	
	public void enrollStudent(List<Student> studentList) throws Exception {
		for (Student student : studentList) {
			int studentAge = student.getAge();
			EnrollmentRules rule = this.getApplicableEnrollmentRule(studentAge);
			System.out.println("Applicable rule is "+rule.getAgeRange());
			this.setClassIDGroupID(student, rule);
			System.out.println("Student Enrollemnt Complete");
			student.showStudentDetails();
			studentMap.put(student.getStudentID(), student);
			System.out.println("Student Enrollemnt Complete\n");
		}
		
	}
	
	public static Date getStuDOB (String studentData) {
		String[] eachLine = studentData.split(",");
		Date dOB;
		try {
			dOB = dateFormat.parse(eachLine[2]);
			System.out.println("dOB is "+dOB);
		} catch (ParseException e) {
			System.out.println("Date not parsed");
			e.printStackTrace();
			return new Date();
		}
		
		return dOB;
		
	}
	
	public static int getStuAge(String studentData, LocalDate currentTime) {
		int ageInMonths =0;
		Calendar c = Calendar.getInstance();
		c.setTime(getStuDOB(studentData));
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		LocalDate l1 = LocalDate.of(year, month, date);
		System.out.println("l1 is "+l1);
		//LocalDate currentTime = LocalDate.now();
		System.out.println("now1 is "+currentTime);
		Period age = Period.between(l1, currentTime);
		if(age.getYears()!=0) {
			ageInMonths = ageInMonths+ (age.getYears()*12);
		}
		if(age.getMonths()!=0) {
			ageInMonths = ageInMonths + age.getMonths();
		}
		System.out.println("period age is "+age);
		return ageInMonths;
	}
        
        public static int getStuAge(Date dob, LocalDate currentTime) {
		int ageInMonths =0;
		Calendar c = Calendar.getInstance();
		c.setTime(dob);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		LocalDate l1 = LocalDate.of(year, month, date);
		System.out.println("l1 is "+l1);
		//LocalDate currentTime = LocalDate.now();
		System.out.println("now1 is "+currentTime);
		Period age = Period.between(l1, currentTime);
		if(age.getYears()!=0) {
			ageInMonths = ageInMonths+ (age.getYears()*12);
		}
		if(age.getMonths()!=0) {
			ageInMonths = ageInMonths + age.getMonths();
		}
		System.out.println("period age is "+age);
		return ageInMonths;
	}
	
	public boolean enrollStudent(StudentFactory stuFactObj, String studentData) throws Exception {
		boolean addStudentStatus = true;
		System.out.println("Received student data for processing");
		System.out.println("****************studentData "+studentData);
		LocalDate currentDate = LocalDate.now();
		int age = getStuAge(studentData, currentDate);
		System.out.println("age:"+age+" months");
		studentData = studentData+","+dateFormat.format(new Date())+","+age;
		System.out.println("*****************final studentData before parsing   "+studentData);
		Student student = stuFactObj.getStudentObj(studentData);
			int studentAge = student.getAge();
			EnrollmentRules rule = this.getApplicableEnrollmentRule(studentAge);
			System.out.println("Applicable rule is "+rule.getAgeRange());
			this.setClassIDGroupID(student, rule);
			System.out.println("Student Enrollemnt Complete");
			student.showStudentDetails();
			System.out.println("Student Enrollemnt Complete\n");
			String data = student.getStudentID()+","+student.getFirstName()+","+student.getLastName()+","+student.getAge()+","+
					student.getAddress()+","+student.getMotherName()+","+student.getFatherName()+","+student.getPhoneNumber()+","
                                        +dateFormat.format(student.getDateOfJoining())
                                +","+dateFormat.format(student.getDateOfBirth())+","+student.getuName()+","+student.getPass();
			System.out.println("data to be written is "+data);
			FileUtil.appendTextFile("studentTemp.csv", data);
			studentMap.put(student.getStudentID(), student);
			return (addStudentStatus);
	}
        
        public boolean enrollStudentPerm(StudentFactory stuFactObj, String studentData) throws Exception {
		boolean addStudentStatus = true;
		System.out.println("Received student data for processing");
		System.out.println("****************studentData "+studentData);
		LocalDate currentDate = LocalDate.now();
		int age = getStuAge(studentData, currentDate);
		System.out.println("age:"+age+" months");
		studentData = studentData+","+dateFormat.format(new Date())+","+age;
		System.out.println("*****************final studentData before parsing   "+studentData);
		Student student = stuFactObj.getStudentObj(studentData);
			int studentAge = student.getAge();
			EnrollmentRules rule = this.getApplicableEnrollmentRule(studentAge);
			System.out.println("Applicable rule is "+rule.getAgeRange());
			this.setClassIDGroupID(student, rule);
			System.out.println("Student Enrollemnt Complete");
			student.showStudentDetails();
			System.out.println("Student Enrollemnt Complete\n");
			String data = student.getStudentID()+","+student.getFirstName()+","+student.getLastName()+","+student.getAge()+","+
						student.getAddress()+","+student.getMotherName()+","+student.getFatherName()+","+student.getPhoneNumber()+","
						+dateFormat.format(student.getDateOfJoining())
                                +","+dateFormat.format(student.getDateOfBirth())+","+student.getuName()+","+student.getPass();
			System.out.println("data to be written is "+data);
			FileUtil.appendTextFile("student.csv", data);
			studentMap.put(student.getStudentID(), student);
			return (addStudentStatus);
	}
        
        public boolean enrollStudentPermUp(StudentFactory stuFactObj, String studentData,int count) throws Exception {
		boolean addStudentStatus = true;
		System.out.println("Received student data for processing");
		System.out.println("****************studentData "+studentData);
		LocalDate currentDate = LocalDate.now();
		int age = getStuAge(studentData, currentDate);
		System.out.println("age:"+age+" months");
		studentData = studentData+","+dateFormat.format(new Date())+","+age;
		System.out.println("*****************final studentData before parsing   "+studentData);
		Student student = stuFactObj.getStudentObjUp(studentData,count);
			int studentAge = student.getAge();
			EnrollmentRules rule = this.getApplicableEnrollmentRule(studentAge);
			System.out.println("Applicable rule is "+rule.getAgeRange());
			this.setClassIDGroupID(student, rule);
			System.out.println("Student Enrollemnt Complete");
			student.showStudentDetails();
			System.out.println("Student Enrollemnt Complete\n");
			String data = student.getStudentID()+","+student.getFirstName()+","+student.getLastName()+","+student.getAge()+","+
						student.getAddress()+","+student.getMotherName()+","+student.getFatherName()+","+student.getPhoneNumber()+","
						+dateFormat.format(student.getDateOfJoining())
                                +","+dateFormat.format(student.getDateOfBirth())+","+student.getuName()+","+student.getPass();
			System.out.println("data to be written is "+data);
			FileUtil.appendTextFile("student.csv", data);
			studentMap.put(student.getStudentID(), student);
			return (addStudentStatus);
	}
	
	public boolean enrollTeacher(TeacherFactory teaFactObj, String teacherData) throws Exception {
		boolean addTeacherStatus = true;
		System.out.println("Received teacher data for processing");
		System.out.println("teacherData "+teacherData);
		Teacher teacher = teaFactObj.getSingleTeacherObj(teacherData);
			System.out.println("Teacher Enrollemnt Complete");
			teacher.show();
			//9,TeanineName, TeasecondName,true, #1 Hunt, 100, 8888888888
			String data = teacher.getTeacherID()+","+teacher.getFirstName()+","+teacher.getLastName()
                                        +","+teacher.getisAvailable()+","+teacher.getAddress()+","+teacher.getPhoneNumber()
                                        +","+teacher.getuName()+","+teacher.getPassword();
			System.out.println("data to be written is "+data);
			FileUtil.appendTextFile("teacherTemp.csv", data);
			return (addTeacherStatus);
	}
        
        public boolean enrollTeacherPerm(TeacherFactory teaFactObj, String teacherData) throws Exception {
		boolean addTeacherStatus = true;
		System.out.println("Received teacher data for processing");
		System.out.println("teacherData "+teacherData);
		Teacher teacher = teaFactObj.getSingleTeacherObj(teacherData);
			System.out.println("Teacher Enrollemnt Complete");
			teacher.show();
			//9,TeanineName, TeasecondName,true, #1 Hunt, 100, 8888888888
			String data = teacher.getTeacherID()+","+teacher.getFirstName()+","+teacher.getLastName()+","+teacher.getisAvailable()+","+
                                teacher.getAddress()+","+teacher.getPhoneNumber()+","+teacher.getuName()+","+teacher.getPassword();
			System.out.println("data to be written is "+data);
			FileUtil.appendTextFile("teacher.csv", data);
			return (addTeacherStatus);
	}
	public Student findStudentById(int studentId) {
		System.out.println("ID to be searched: " + studentId);
		Student studentObj= null;
		boolean studentFound = false;
		for (Classroom classroom : this.getClassroomList()) {
			System.out.print("\nClassID:"+classroom.getClassroomID()+"\tAge group:"+classroom.getEnrollmentRule().getMinAge()+"-"+classroom.getEnrollmentRule().getMaxAge()+"months");
			for (Group group : classroom.getGroupList()) {
				System.out.print("\n\tGroupID:"+group.getGroupID()+"   Teacher Assigned:"+group.getTeacher().getFirstName()+"\n");
				for (Student student : group.getStudentList()) {
					if(studentId == student.getStudentID())
					{
						System.out.println(student.getStudentID());
						studentObj = student;
						studentFound = true;
						break;
					}
				}
				if (studentFound == true)
					break;
			}
			if (studentFound == true)
				break;
		}
		return studentObj;
	}
	//2,2,1,3,1,0
	//Hib,DTAP,Polio,HepB,MMR,Varicella
	private List<Immunization> getImmunizationObject(String csvData, ImmunizationFactory immunizationFactoryInstance) throws ParseException
	{
		List<Immunization> immunizationRec = new ArrayList<Immunization>();
		String[] str = csvData.split(",");
		
		immunizationRec.add(immunizationFactoryInstance.getObject(str[1]+","+"Hib"));
		immunizationRec.add(immunizationFactoryInstance.getObject(str[2]+","+"DTap"));
		immunizationRec.add(immunizationFactoryInstance.getObject(str[3]+","+"Polio"));
		immunizationRec.add(immunizationFactoryInstance.getObject(str[4]+","+"Hepatitis B"));
		immunizationRec.add(immunizationFactoryInstance.getObject(str[5]+","+"MMR"));
		immunizationRec.add(immunizationFactoryInstance.getObject(str[6]+","+"Varicella"));
		
		return immunizationRec;
	}

	public void mapStudentIDToImmunizationData(List<String> csvImmunizationData, List<Student> studentList, ImmunizationFactory immunizationFactoryInstance) throws ParseException
	{
		for(String csvData:csvImmunizationData)
		{
			String[] studentID = csvData.split(",");
			List<Immunization> list = getImmunizationObject(csvData, immunizationFactoryInstance); 

			for (Student student : studentList) {
				if(student.getStudentID() == Integer.parseInt(studentID[0])) {
					student.setImmunizationRecord(list);
				}
			}
		}
//		System.out.println("MAPPING DONE\n");
	}

	public void mapStudentIDToImmunizationDataFromUI(String immunizationRecord) throws ParseException
	{
		Student studentObj = null;
		List<Immunization> immunizationRec = getImmunizationObject(immunizationRecord, this.immunizationFactoryInstance);
		studentObj = findStudentById(StudentFactory.getStudentCount());
		studentObj.setImmunizationRecord(immunizationRec);
		FileUtil.appendTextFile("Student_Immunization_Record_temp.csv", immunizationRecord);
	}
        
        public void mapStudentIDToImmunizationDataFromUIPerm(String immunizationRecord) throws ParseException
	{
		Student studentObj = null;
		List<Immunization> immunizationRec = getImmunizationObject(immunizationRecord, this.immunizationFactoryInstance);
		studentObj = findStudentById(StudentFactory.getStudentCount());
		studentObj.setImmunizationRecord(immunizationRec);
		FileUtil.appendTextFile("Student_Immunization_Record.csv", immunizationRecord);
	}
        
         public void mapStudentIDToImmunizationDataFromUIPermUp(String immunizationRecord) throws ParseException
	{
		Student studentObj = null;
		List<Immunization> immunizationRec = getImmunizationObject(immunizationRecord, this.immunizationFactoryInstance);
		studentObj = findStudentById(StudentFactory.getStudentCount());
		studentObj.setImmunizationRecord(immunizationRec);
		FileUtil.appendTextFile("Student_Immunization_Record.csv", immunizationRecord);
	}

	public Classroom setClassIDGroupID(Student student, EnrollmentRules rule) throws Exception {
		boolean classroomFound = false;
		boolean groupFound = false;
		boolean teacherFound = false;
		Classroom vacantClassroom = null;
		if (this.classroomList.isEmpty()) {
			Classroom classObj = new Classroom(this.classroomList.size(), rule);
			classroomFound = true;
			this.addClassroom(classObj);
			System.out.println("No classrooms available, new class created");
			Group groupObj = new Group(classObj.getNumOfGroups(), classObj.getEnrollmentRule());
			groupObj.setClassID(classObj.getClassroomID());
			System.out.println("No groups available, new group created");
			classObj.addGroupObj(groupObj);
			//add teacher
			for (Teacher teacher : teacherList) {
				if (teacher.getisAvailable()) {
					teacher.setAvailable(false);
					teacher.setClassID(classObj.getClassroomID());
					teacher.setGroupID(groupObj.getGroupID());
					groupObj.setTeacher(teacher);
					teacherFound = true;
					break;
				}
			}
			
			if (groupObj.getGroupSize()+1 <= groupObj.getEnrollmentRule().getGroupSize()) {
				groupFound = true;
				groupObj.addStudent(student);
				student.setGroupID(groupObj.getGroupID());
				System.out.println("groupID set");
				student.setClassID(classObj.getClassroomID());
				System.out.println("classID set");
				return classObj;
			}
		}
		else {
			for (Classroom classroom : this.classroomList) {
				if (classroom.getEnrollmentRule().equals(rule)) {
					System.out.println("classroom.getNumOfGroups()  "+classroom.getNumOfGroups()+"  classroom.getEnrollmentRule().getMaxGroup()  "+classroom.getEnrollmentRule().getMaxGroup());
					if(classroom.getNumOfGroups()<=classroom.getEnrollmentRule().getMaxGroup()) {
						if(classroom.getNumOfGroups()==classroom.getEnrollmentRule().getMaxGroup()) {
							System.out.println("Classroom is full");
							for (Group group : classroom.getGroupList()) {
								System.out.println("group.getGroupSize()+1"+(group.getGroupSize()+1)+" group.getEnrollmentRule().getGroupSize() "+group.getEnrollmentRule().getGroupSize());
								if (group.getGroupSize()+1 <= group.getEnrollmentRule().getGroupSize()) {
									System.out.println("Group with vacancy found");
									groupFound = true;
									classroomFound = true;
									group.addStudent(student);
									student.setGroupID(group.getGroupID());
									System.out.println("groupID set");
									student.setClassID(classroom.getClassroomID());
									System.out.println("classID set");
									return classroom;
						}
							}
						}
						else {
							classroomFound = true;
							vacantClassroom = classroom;
							for (Group group1 : classroom.getGroupList()) {
								System.out.println("group.getGroupSize()+1"+(group1.getGroupSize()+1)+" group.getEnrollmentRule().getGroupSize() "+group1.getEnrollmentRule().getGroupSize());
								if (group1.getGroupSize()+1 <= group1.getEnrollmentRule().getGroupSize()) {
									System.out.println("Group with vacancy found");
									groupFound = true;
									group1.addStudent(student);
									student.setGroupID(group1.getGroupID());
									System.out.println("groupID set");
									student.setClassID(classroom.getClassroomID());
									System.out.println("classID set");
									return classroom;
								}
								else{
										System.out.println("Group is full");
									}
							}
						}	
					}
					else{
						System.out.println("Classroom is full");
						}
				}
				else {
					System.out.println("Class rule mismatch");
				}
				if (classroomFound == true && vacantClassroom != null) {
					System.out.println("Vacant classroom available, group is full, creating new group");
					System.out.println("inputs for creating new group are "+vacantClassroom.getNumOfGroups()+"  "+ vacantClassroom.getEnrollmentRule());
					Group newGroup = new Group(vacantClassroom.getNumOfGroups(), vacantClassroom.getEnrollmentRule());
					newGroup.setClassID(vacantClassroom.getClassroomID());
					vacantClassroom.addGroupObj(newGroup);
					//add teacher
					for (Teacher teacher : teacherList) {
						if (teacher.getisAvailable()) {
							teacher.setAvailable(false);
							teacher.setClassID(newGroup.getClassID());
							teacher.setGroupID(newGroup.getGroupID());
							newGroup.setTeacher(teacher);
							teacherFound = true;
							break;
						}
					}
					System.out.println("check ***  "+newGroup.getGroupID()+"  "+(newGroup.getGroupSize()+1)+"   "+newGroup.getEnrollmentRule().getGroupSize());
					if (newGroup.getGroupSize()+1 <= newGroup.getEnrollmentRule().getGroupSize()) {
						groupFound = true;
						newGroup.addStudent(student);
						student.setGroupID(newGroup.getGroupID());
						System.out.println("groupID set");
						student.setClassID(vacantClassroom.getClassroomID());
						System.out.println("classID set");
						return vacantClassroom;
				}
			}
		}
		}
		System.out.println("classroomFound is "+classroomFound +"  groupFound  "+groupFound);
		if (classroomFound == false && groupFound == false) {
			System.out.println("Class and group not found");
			System.out.println("Creating new class and group");
			Classroom classObj = new Classroom(this.classroomList.size(), rule);
			classroomFound = true;
			this.addClassroom(classObj);
			Group groupObj = new Group(classObj.getNumOfGroups(), classObj.getEnrollmentRule());
			groupObj.setClassID(classObj.getClassroomID());
			classObj.addGroupObj(groupObj);
			//add teacher
			for (Teacher teacher : teacherList) {
				if (teacher.getisAvailable()) {
					teacher.setAvailable(false);
					teacher.setClassID(groupObj.getClassID());
					teacher.setGroupID(groupObj.getGroupID());
					groupObj.setTeacher(teacher);
					teacherFound = true;
					break;
				}
			}
			if (groupObj.getGroupSize()+1 <= groupObj.getEnrollmentRule().getGroupSize()) {
				groupFound = true;
				groupObj.addStudent(student);
				student.setGroupID(groupObj.getGroupID());
				System.out.println("groupID set");
				student.setClassID(classObj.getClassroomID());
				System.out.println("classID set");
				return classObj;
			}
			
		}
		throw new Exception("Invalid input while assigning Class ID");
		}
	
	
	
}
