package edu.neu.csye6200.daycare.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neu.csye6200.daycare.objects.Classroom;
import edu.neu.csye6200.daycare.objects.Group;
import edu.neu.csye6200.daycare.objects.Student;

/*
 * FileUtil is a class used for file I/O operations
 */
public class FileUtil {
	
	/**
	 * write a CSV file 
	 * @param fileName text file name
	 * @param data list of string data to be written to a file
	 */
	public static void writeTextFile(String fileName, List<String> data) {
		try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
			for (String line : data) {
				out.write(line);
				out.newLine();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Writing to file "+fileName+" complete");
	}
	
	public static void appendTextFile(String fileName, String data) {
		try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true))) {
				out.write(data);
				out.newLine();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Writing to file "+fileName+" complete");
	}
	
	
	/**
	 * read from a CSV file
	 * @param fileName text file name
	 * @return data list of strings from the file
	 */
	public List<String> readTextFile( String fileName) {
		List<String> data = new ArrayList<String>();
		String thisLine = null;
		try (FileReader fr = new FileReader(fileName);BufferedReader br = new BufferedReader(fr);){
			while((thisLine = br.readLine())!= null) {
				if (thisLine.isEmpty() || thisLine.trim().equals("") || thisLine.trim().equals("\n")) {
				 System.out.println("Empty line encountered, skipping");
				        continue;
				    }
				data.add(thisLine);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Reading from file "+fileName+" complete");
		return data;
	}
	
	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDateTime();
}


public static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
    return java.sql.Date.valueOf(dateToConvert);
}

//int[] monthArr = {53,39,36,35,44,42,16,28,27,23,18,22,17,63,16,15,12,63,11};
//LocalDateTime currentDate = LocalDateTime.now();
//List<LocalDateTime> newDOB = new ArrayList<LocalDateTime>();
//List<Date> newDOBDate = new ArrayList<Date>();
//for (int i = 0; i < monthArr.length; i++) {
//	newDOB.add(currentDate.minusMonths(monthArr[i]));
//	newDOBDate.add(Date.from((currentDate.minusMonths(monthArr[i])).atZone(ZoneId.systemDefault()).toInstant()));
//}
//for (Date date : newDOBDate) {
//	System.out.println("newDOBDate is "+dateFormat.format(date)+",");
//}


//for (Classroom classroom : dc.getDayCareObj().getClassroomList()) {
//	System.out.print("\nClassID:"+classroom.getClassroomID()+"\tAge group:"+classroom.getEnrollmentRule().getMinAge()+"-"+classroom.getEnrollmentRule().getMaxAge()+"months");
//	for (Group group : classroom.getGroupList()) {
//		System.out.print("\n\tGroupID:"+group.getGroupID()+"   Teacher Assigned:"+group.getTeacher().getFirstName()+"\n");
//		for (Student student : group.getStudentList()) {
//			System.out.println("StudentID:"+student.getStudentID()+"\t Age:"+student.getAge()+"months   DOB is "+student.getDateOfBirth());
//			LocalDateTime currentLocalDate = convertToLocalDateTimeViaInstant(student.getDateOfBirth());
//			currentLocalDate = currentLocalDate.plusMonths(6);
//			//student.setDateOfBirth(convertToDateViaSqlDate(currentLocalDate));
//			student.setDateOfBirth(Date.from(currentLocalDate.atZone(ZoneId.systemDefault()).toInstant()));			
//			System.out.println("Updated Student Age is "+student.getDateOfBirth());
//		}
//	}
//}
	
}
