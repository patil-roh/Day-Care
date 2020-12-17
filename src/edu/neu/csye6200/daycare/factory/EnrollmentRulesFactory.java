package edu.neu.csye6200.daycare.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.neu.csye6200.daycare.objects.EnrollmentRules;

public class EnrollmentRulesFactory {
	
	private static EnrollmentRulesFactory instance = null;
	private EnrollmentRulesFactory() {
	}
	
	public static EnrollmentRulesFactory getObj() {
		if (instance == null) {
			instance = new EnrollmentRulesFactory();
		}
		return instance;
	}
	
	public  List<EnrollmentRules> getRuleObj(List<String> enrollmentRegulationList) {
		List<EnrollmentRules> EnrollmentRulesList = new ArrayList<EnrollmentRules>();
		Iterator<String> it = enrollmentRegulationList.iterator();
		while(it.hasNext()) {
			String[] parameter = it.next().split(",");
			int minAge = new Integer(parameter[0]);
			int maxAge = new Integer(parameter[1]);
			int numOfStu = new Integer(parameter[2]);
			int numOfTea = new Integer(parameter[3]);
			int  groupSize= new Integer(parameter[4]);
			String ageRange = String.valueOf(minAge)+"-"+String.valueOf(maxAge);
			String ratio = String.valueOf(numOfStu)+":"+String.valueOf(numOfTea);
			EnrollmentRulesList.add(new EnrollmentRules( minAge,  maxAge, ageRange, numOfStu, ratio, groupSize));
		}
		
			return EnrollmentRulesList;
	} 
}
