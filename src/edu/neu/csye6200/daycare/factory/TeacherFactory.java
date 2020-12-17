package edu.neu.csye6200.daycare.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import edu.neu.csye6200.daycare.objects.Teacher;

public class TeacherFactory {
	private static TeacherFactory instance = null;
	private static int teacherCount = 0;
	
	private TeacherFactory() {
		
	};
	
	public static TeacherFactory getTeacherFactoryObj() {
		if (instance == null) {
			instance = new TeacherFactory();
			return instance;
		}
		else {
			return instance;
		}
	}
	
	//INIT
	public List<Teacher>  getTeacherObj(List<String> teacherData) {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Iterator<String> it = teacherData.iterator();
		String[] eachLine = null;
			while(it.hasNext()) {
				teacherCount += 1;
				eachLine = it.next().split(",");
				int teacherID            	=new Integer(eachLine[0]);
				String firstName         	=eachLine[1];
				String lastName          	=eachLine[2];
				boolean isAvailable        	=new Boolean(eachLine[3]);
				String address          	=eachLine[4];
				String phoneNumber          =eachLine[5];
                                String uName = eachLine[6];
                                String pass= eachLine[7];
				teacherList.add(new Teacher( firstName, lastName, teacherID,  isAvailable,  address, phoneNumber, uName, pass));
					} 
			return teacherList;
	}
	
	
	//SINGLE
		public Teacher getSingleTeacherObj(String teacherData) {
			teacherCount += 1;
					String[] eachLine = teacherData.split(",");
					String firstName         	=eachLine[0];
					String lastName          	=eachLine[1];
					boolean isAvailable        	=new Boolean(eachLine[3]);
					String address          	=eachLine[2];
					String phoneNumber          =eachLine[4];
                                        String uName = eachLine[5];
                                        String pass= eachLine[6];
					//Dan  Peters  10  false  Yes  9876543210
					System.out.println(firstName+"  "+lastName+"  "+teacherCount+"  "+isAvailable+"  "+address+"  "+phoneNumber);
					return (new Teacher( firstName, lastName, teacherCount,  isAvailable,  address, phoneNumber, uName,pass));
		}
		
	}
