package edu.neu.csye6200.daycare.objects;

import java.util.Date;

public class Vaccine {
	private Date dateReceived;	//mm/dd/yyyy
	private int ageReceived; 	//months
	private Date nextDoseDate;	//mm/dd/yyyy
	private String vaccineName; //MMR etc
	private boolean isDosePending; //true if any dose is pending
}
