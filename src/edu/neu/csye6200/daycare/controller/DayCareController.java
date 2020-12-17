package edu.neu.csye6200.daycare.controller;

import edu.neu.csye6200.daycare.factory.*;
import edu.neu.csye6200.daycare.objects.*;
import edu.neu.csye6200.daycare.util.FileUtil;
import edu.neu.csye6200.daycare.views.AdminAcceptStud;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;

import org.omg.CORBA.DynAnyPackage.InvalidValue;

public class DayCareController {
	private static final String studentFileName = "student.csv";
        private static final String tempStudentFileName = "studentTemp.csv";
	private static final String teacherFileName = "teacher.csv";
        private static final String tempteacherFileName = "teacherTemp.csv";
	private static final String demoFileName = "demo.csv";
	private static final String enrollmentRulesFileName = "enrollmentRules.csv";
        private static FileWriter writer;
        private static File file;
        private static List<String> studentData = new ArrayList<String>();
        private static final String FILE_PATH_DEADLINE = "deadline.csv";
        private static final String LINE_BREAK = "\n";
	public static String getEnrollmentrulesfilename() {
		return enrollmentRulesFileName;
	}


	private static final String immunizationFileName = "Student_Immunization_Record.csv";
        private static final String tempImmunizationFileName = "Student_Immunization_Record_temp.csv";
	private static FileUtil fileutil = new FileUtil();
	private DayCare dayCareObj = null;
	private DayCareFactory  dayCarefactoryObj =  null;
	public static Hashtable<String, ImmunizationRules> immunizationRules = new Hashtable<String, ImmunizationRules>();
	private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
	private EnrollmentRulesFactory enrollmentFactoryObj = null;
	private StudentFactory  studentFactoryObj = null;
	private TeacherFactory  teacherFactoryObj = null;

    public static String getTeacherFileName() {
        return teacherFileName;
    }
	
	public static String getStudentfilename() {
		return studentFileName;
	}
        
        public static String getTempStudentFileName() {
		return tempStudentFileName;
	}
        public static String getTempteacherFileName() {
		return tempteacherFileName;
	}

        
        public static String getTempImmunizationFileName() {
		return tempImmunizationFileName;
	}
	
	public DayCare getDayCareObj() {
		return dayCareObj;
	}



	public void setDayCareObj(DayCare dayCareObj) {
		this.dayCareObj = dayCareObj;
	}



	public DayCareFactory getDayCarefactoryObj() {
		return dayCarefactoryObj;
	}



	public void setDayCarefactoryObj(DayCareFactory dayCarefactoryObj) {
		this.dayCarefactoryObj = dayCarefactoryObj;
	}



	public EnrollmentRulesFactory getEnrollmentFactoryObj() {
		return enrollmentFactoryObj;
	}



	public void setEnrollmentFactoryObj(EnrollmentRulesFactory enrollmentFactoryObj) {
		this.enrollmentFactoryObj = enrollmentFactoryObj;
	}



	public StudentFactory getStudentFactoryObj() {
		return studentFactoryObj;
	}



	public void setStudentFactoryObj(StudentFactory studentFactoryObj) {
		this.studentFactoryObj = studentFactoryObj;
	}



	public TeacherFactory getTeacherFactoryObj() {
		return teacherFactoryObj;
	}



	public void setTeacherFactoryObj(TeacherFactory teacherFactoryObj) {
		this.teacherFactoryObj = teacherFactoryObj;
	}


        
        

	public List<String> sendAllStudentImmunizationDetails(DayCareController dc) {
		List<String> detailsOfStudentImmunizationRecord = new ArrayList<String>();
		String ImmunizationData;
		for (Classroom classroom : dc.getDayCareObj().getClassroomList()) {
                    System.out.println("************************   Inside Classroom For   ********************\n");
			System.out.print("\nClassID:"+classroom.getClassroomID()+"\tAge group:"+classroom.getEnrollmentRule().getMinAge()+"-"+classroom.getEnrollmentRule().getMaxAge()+"months");
			for (Group group : classroom.getGroupList()) {
                                System.out.println("************************   Inside Group For   ********************\n");
				System.out.print("\n\tGroupID:"+group.getGroupID()+"   Teacher Assigned:"+group.getTeacher().getFirstName()+"\n");
				for (Student student : group.getStudentList()) {
                                        System.out.println("************************   Inside Student For   ********************\n");
					System.out.println(student.getStudentID() +","+student.getFirstName()+","+ student.getLastName());
					ImmunizationData = Integer.toString(student.getStudentID()) +","+student.getFirstName()+","+ student.getLastName();
					System.out.println("ImmunizationData  "+ImmunizationData);
							for (Immunization im : student.getImmunizationRecord()) {
                                                            System.out.println("************************   Inside Imune For   ********************\n");
								if(im.getNextDueDate()!=null) {
                                                                    System.out.println("************************   Inside IF    ********************\n");
									ImmunizationData+=","+im.getNextDueDate().toString();
								}
							}
							detailsOfStudentImmunizationRecord.add(ImmunizationData);
							ImmunizationData = null;
				}
			}
		}
		return detailsOfStudentImmunizationRecord;
	}
	
	
	

	public static String getDateformat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		String date = DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
		return date;
	}
	
	public static String getStudentInfo(DayCareController dc, String ID) {
		String studentInfo = "";
		int id = new Integer(ID);
		if(dc.getDayCareObj().getstudentMap().containsKey(id)) {
			Student s1 = (Student) dc.getDayCareObj().getstudentMap().get(id);
			studentInfo = s1.getStudentID()+","+s1.getFirstName()+","+s1.getLastName()+","+s1.getAge()+","+s1.getAddress()+","+s1.getFatherName()+","+s1.getMotherName()+","+s1.getPhoneNumber()+","+(dateFormat.format(s1.getDateOfJoining()))+","+(dateFormat.format(s1.getDateOfBirth()));
			System.out.println("studentInfo to be returned is "+studentInfo);
		}
		
		return studentInfo;
	}
	
	public static String getTeacherInfo(DayCareController dc, String ID) {
		String teacherInfo = "";
		int id = new Integer(ID);
		System.out.println("id is "+ID);
		for (Classroom classroom : dc.getDayCareObj().getClassroomList()) {
			for (Group group : classroom.getGroupList()) {
				System.out.println("group.getTeacher().getTeacherID()    "+group.getTeacher().getTeacherID());
				if(group.getTeacher().getTeacherID()==id)
				{
				Teacher t1 = group.getTeacher();
				teacherInfo = t1.getFirstName()+","+t1.getLastName()+","+t1.getClassID()+","+t1.getGroupID();
				System.out.println("teacherInfo to be returned is "+teacherInfo);
				}
			}
			
		}
		
		return teacherInfo;
	}
	
	public static List<String> getStudentListForTeacher(DayCareController dc, String ID) {
		System.out.println("id is "+ID);
		List<String> studentList = new ArrayList<String>();
		int id = new Integer(ID);
		for (Classroom classroom : dc.getDayCareObj().getClassroomList()) {
			for (Group group : classroom.getGroupList()) {
				if(group.getTeacher().getTeacherID()==id)
				{
					System.out.println("Teacher ID found");
					int g1 = group.getTeacher().getGroupID();
					System.out.println("g1 is "+g1);
					if(group.getGroupID() == g1) {
						System.out.println("Group found");
						for (Student student : group.getStudentList()) {
							System.out.println("found "+student.getStudentID());
							studentList.add(student.getStudentID()+","+student.getFirstName()+","+student.getLastName()+","+student.getAge());
						}
					}
				}
			}
		}
		for (String string : studentList) {
			System.out.println("student is "+string);
		}
		return studentList;
	}
	
	public static String getStudentImmInfo(DayCareController dc, String ID) {
		String studentImmInfo = "";
		String overDueStatus = "0";
		int id = new Integer(ID);
		if(dc.getDayCareObj().getstudentMap().containsKey(id)) {
			Student s1 = (Student) dc.getDayCareObj().getstudentMap().get(id);
			for (Immunization immdetails : s1.getImmunizationRecord()) {
				if(immdetails.checkOverdueStatus() == true) {
					overDueStatus = "1";
				}
				if(immdetails.getNextDueDate()!=null) {
					studentImmInfo = studentImmInfo+(dateFormat.format(Date.from((immdetails.getNextDueDate()).atZone(ZoneId.systemDefault()).toInstant())))+","+overDueStatus+",";
				}
				else {
					studentImmInfo = studentImmInfo+immdetails.getNextDueDate()+","+overDueStatus+",";
				}
			}
			
			System.out.println("studentImmInfo to be returned is "+studentImmInfo);
		}
		
		return studentImmInfo;
	}
	
		public static ImmunizationRules getImmunizationRule(String vaccine) {
		return DayCareController.immunizationRules.get(vaccine);
	}

	
	public void addSixMonths(DayCareController dc) throws Exception {
		List<String> demoDateList = fileutil.readTextFile(demoFileName);
		for (String string : demoDateList) {
			Date demoDate = dateFormat.parse(string);
		}
		for (Classroom classroom : dc.getDayCareObj().getClassroomList()) {
			for (Group group : classroom.getGroupList()) {
				group.getStudentList().clear();
				group.setTeacher(null);
			}
			classroom.getGroupList().clear();
		}
		dc.getDayCareObj().getClassroomList().clear();
		System.out.println("Cleared all existing Classroomlist");
		dc.getStudentFactoryObj().setStudentCount(0);
		List<String> student_data = fileutil.readTextFile(studentFileName);
                List<String> temp_student_data = fileutil.readTextFile(tempStudentFileName);
                student_data.addAll(temp_student_data);
		System.out.println("Student File read successfully");
		List<Student> studentList = dc.getStudentFactoryObj().initStudentObj(student_data, true);
		System.out.println("Updated Age by adding 6 months");
		dc.getDayCareObj().enrollStudent(studentList);
		
	}
	
	private void createDayCareImmunizationRules () {
		
		DayCareController.immunizationRules.put("Hib", new ImmunizationRules(4, Arrays.asList(2, 4, 6, 15)));
		DayCareController.immunizationRules.put("DTap", new ImmunizationRules(4, Arrays.asList(2, 4, 6, 15)));
		DayCareController.immunizationRules.put("Polio", new ImmunizationRules(3, Arrays.asList(0, 6, 12)));
		DayCareController.immunizationRules.put("Hepatitis B", new ImmunizationRules(3, Arrays.asList(0, 2, 15)));
		DayCareController.immunizationRules.put("MMR", new ImmunizationRules(1, Arrays.asList(0)));
		DayCareController.immunizationRules.put("Varicella", new ImmunizationRules(1, Arrays.asList(0)));
		
	}
	
	public static List<String> getEnrollmentStatus(DayCareController dc) {
		System.out.println("getEnrollmentStatus");
		List<String> studentdataList = new ArrayList<String>();
		for (Classroom classroom : dc.getDayCareObj().getClassroomList()) {
			for (Group group : classroom.getGroupList()) {
				for (Student student : group.getStudentList()) {
					String studentData = "";
					int daysPending =0;
					LocalDateTime enrollmentDueDate =(((fileutil.convertToLocalDateTimeViaInstant(student.getDateOfJoining()).plusYears(1))));
					Calendar c = Calendar.getInstance();
					c.setTime(Date.from((enrollmentDueDate).atZone(ZoneId.systemDefault()).toInstant()));
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH) + 1;
					int date = c.get(Calendar.DATE);
					LocalDate l1 = LocalDate.of(year, month, date);
					Period age = Period.between(LocalDate.now(), l1);
							if(age.getYears()!=0) {
								daysPending = daysPending + (age.getYears()*365);
							}
							if(age.getMonths()!=0) {
								daysPending = daysPending + age.getMonths()*30;
							}
							daysPending +=age.getDays();
							System.out.println("period age is "+daysPending);
					
					
					studentData = student.getStudentID()+","+student.getFirstName()+","+student.getLastName()+","+dateFormat.format(student.getDateOfJoining())+","+
							dateFormat.format(Date.from((enrollmentDueDate).atZone(ZoneId.systemDefault()).toInstant()))+","+daysPending;
					System.out.println("studentData is "+studentData);
					studentdataList.add(studentData);
				}
			}
		}
		System.out.println(studentdataList);
		
		return studentdataList;
	}

	
	public static void demo(DayCareController dc) throws Exception {
		System.out.println("DayCare Demo ");
		List<String> date = new ArrayList<String>();
		File f = new File(demoFileName);
		if(f.exists()){
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dateFormat.format(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		date.add(dateFormat.format(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())));
		fileutil.writeTextFile(demoFileName, date);
		System.out.println("Date updated");
		//Get DayCare factory obj from DayCare factory
		DayCareFactory  factoryObj = DayCareFactory.getObj();
		dc.setDayCarefactoryObj(factoryObj);
		System.out.println("DayCare Factory obj created");

		 //Get DayCare obj 
		DayCare DayCare = factoryObj.getDayCareObj();
		dc.setDayCareObj(DayCare);
		System.out.println("DayCare obj  created");

		
		//Creating Rules
		EnrollmentRulesFactory enrollFactoryObj = EnrollmentRulesFactory.getObj();
		dc.setEnrollmentFactoryObj(enrollFactoryObj);
		System.out.println("Rules factory obj  created");
		List<String> enrollmentRegulationList = new ArrayList<String>();
		//minAge, maxAge, num of Students, num of Teachers, groupSize 
		enrollmentRegulationList.add("6,12,4,1,3");
		enrollmentRegulationList.add("13,24,5,1,3");
		enrollmentRegulationList.add("25,35,6,1,3");
		enrollmentRegulationList.add("36,47,8,1,3");
		enrollmentRegulationList.add("48,59,12,1,2");
		enrollmentRegulationList.add("60,100,15,1,2");
		dc.getDayCareObj().setEnrollmentruleList(enrollFactoryObj.getRuleObj(enrollmentRegulationList));
		List<String> rulesList = new ArrayList<String>();
		String firstLine = "Age Group,\tgroupSize,\tratio,\tmaxGroups/Class";
		rulesList.add(firstLine);
		for (EnrollmentRules EnrollmentRules : dc.getDayCareObj().getEnrollmentruleList()) {
			String rule = ""+EnrollmentRules.getMinAge() + "-" + EnrollmentRules.getMaxAge() +",\t\t\t"
					+ EnrollmentRules.getGroupSize() + ", \t\t\t" + EnrollmentRules.getRatio() + ", \t\t\t" + EnrollmentRules.getMaxGroup();
			System.out.println(rule);
			rulesList.add(rule);	
		}
		System.out.println("Rule objs created");
		fileutil.writeTextFile(enrollmentRulesFileName, rulesList);
		dc.createDayCareImmunizationRules();

		//*****INITIALIZATION START*****
		//Get Student factory obj from Student factory
		StudentFactory  studentFactoryObj = StudentFactory.getObj();
		dc.setStudentFactoryObj(studentFactoryObj);
		System.out.println("Student Factory obj");
		
		//Get Teacher factory obj from Student factory
		TeacherFactory  teacherFactoryObj = TeacherFactory.getTeacherFactoryObj();
		dc.setTeacherFactoryObj(teacherFactoryObj);
		System.out.println("Teacher Factory obj");
		
		//Store data read from file in file_data, call readTextFile using FileUtil object passing filename
		List<String> teacher_data = fileutil.readTextFile(teacherFileName);
                List<String> temp_teacher_data = fileutil.readTextFile(tempteacherFileName);
                teacher_data.addAll(temp_teacher_data);
		System.out.println("Teacher File read successfully");
		dc.getDayCareObj().setTeacherList(teacherFactoryObj.getTeacherObj(teacher_data));
		
		//Store data read from file in file_data, call readTextFile using FileUtil object passing filename
		List<String> student_data = fileutil.readTextFile(studentFileName);
                List<String> temp_data = fileutil.readTextFile(tempStudentFileName);
                student_data.addAll(temp_data);
		System.out.println("Student File read successfully");
		List<Student> studentList = studentFactoryObj.initStudentObj(student_data, false);
		dc.getDayCareObj().enrollStudent(studentList);
                
                
//                studentData = getEnrollmentStatus();
//                try {
//                    writeDeadlineToFile(studentData);
//                } catch (IOException ex) {
//                Logger.getLogger(AdminAcceptStud.class.getName()).log(Level.SEVERE, null, ex);
//                }
                

		//*****INITIALIZATION COMPLETE*****
		System.out.println("INITIALIZATION COMPLETE");
		
		
		
		List<String> immunization_data = fileutil.readTextFile(immunizationFileName);
		dc.getDayCareObj().mapStudentIDToImmunizationData(immunization_data, studentList, DayCare.getImmunizationFactoryInstance());
		
		
		for (Classroom classroom : dc.getDayCareObj().getClassroomList()) {
			System.out.print("\nClassID:"+classroom.getClassroomID()+"\tAge group:"+classroom.getEnrollmentRule().getMinAge()+"-"+classroom.getEnrollmentRule().getMaxAge()+"months");
			for (Group group : classroom.getGroupList()) {
				System.out.print("\n\tGroupID:"+group.getGroupID()+"   Teacher Assigned:"+group.getTeacher().getFirstName()+"\n");
				for (Student student : group.getStudentList()) {
						if(student.getImmunizationRecord() != null)
							for (Immunization im : student.getImmunizationRecord()) {
								         im.checkImmunizationStatus(FileUtil.convertToLocalDateTimeViaInstant(student.getDateOfBirth()));
							}
				}
			}
		}
			System.out.println("DayCare Demo Done");
		
		
//		for (Classroom classroom : dc.getDayCareObj().getClassroomList()) {
//			System.out.print("\nClassID:"+classroom.getClassroomID()+"\tAge group:"+classroom.getEnrollmentRule().getMinAge()+"-"+classroom.getEnrollmentRule().getMaxAge()+"months");
//			for (Group group : classroom.getGroupList()) {
//				System.out.print("\n\tGroupID:"+group.getGroupID()+"   Teacher Assigned:"+group.getTeacher().getFirstName()+"\n");
//				for (Student student : group.getStudentList()) {
//					System.out.println("Student ID : " + student.getStudentID());
//						if(student.getImmunizationRecord() != null)
//							for (Immunization im : student.getImmunizationRecord()) {
//								        System.out.println(im.getImmunizationName()+ "  " + im.getNextDueDate());
//								        System.out.println(im.getNumberOfDosesPending());
//								        System.out.println("Is Immune: "+im.checkImmuinityStatus());
//								        System.out.println("Is overdue: " + im.checkOverdueStatus());
//							}
//				}
//				if (studentFound == true)
//					break;
			}
//			if (studentFound == true)
//				break;
//		}
//}	
		
//		System.out.println("Calling Add6Months feature");
		//dc.addSixMonths(dc);
//		
//		System.out.println("Calling getEnrollmentdate");
//		dc.getEnrollmentStatus(dc);

		
		
        
        public static void writeDeadlineToFile(List<String> studentData) throws IOException{
          try {
            file = new File(FILE_PATH_DEADLINE);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New File Created");
            writer = new FileWriter(file);
        
            actualWriteDeadline(studentData); 
            
        }finally{
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        
     }
     
     public static void actualWriteDeadline(List<String> studentData) throws IOException{
         if(!studentData.isEmpty()){
        for(String dead:studentData){
            
            
             writer.append(dead);
             writer.append(LINE_BREAK);
                   
        }
        }
  
     }

	}

