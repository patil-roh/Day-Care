package edu.neu.csye6200.daycare.factory;

import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.objects.DayCare;

public class DayCareFactory {
	private static DayCareFactory instance = null;
	private DayCareFactory() {
	}
	
	public static DayCareFactory getObj() {
		if (instance == null) {
			instance = new DayCareFactory();
		}
		return instance;
	}
	
	public DayCare getDayCareObj() {
			 DayCare dayCare = new DayCare();
			return dayCare;
	} 
}
