package edu.neu.csye6200.daycare.objects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.util.FileUtil;

public class ImmunizationRecord implements Immunization {
	
	
	private String immunizationName;
	private int numberOfDosesGiven;
	private int numberOfDosesPending;
	private LocalDateTime nextDueDate;
	private boolean isOverdue;
	private boolean isImmune;

	public ImmunizationRecord(String immunizationName, int numberOfDosesGiven) {
		super();
		this.immunizationName = immunizationName;
		this.numberOfDosesGiven = numberOfDosesGiven;
		this.numberOfDosesPending = DayCareController.getImmunizationRule(this.immunizationName).getMaxNumberOfDoses() - this.numberOfDosesGiven;
		this.isOverdue = false;
		this.isImmune = false;
	}

	@Override
	public String toString() {
		return "ImmunizationRecord [immunizationName=" + immunizationName + ", numberOfDosesGiven=" + numberOfDosesGiven
				+ ", numberOfDosesPending=" + numberOfDosesPending + ", nextDueDate=" + nextDueDate + ", isOverdue="
				+ isOverdue + ", isImmune=" + isImmune + "]";
	}

	@Override
	public void setImmunizationName(String immunizationName) {
		this.immunizationName = immunizationName;
		
	}
	
	public void updateNumberofDosesPending() {
		
		this.numberOfDosesPending = DayCareController.getImmunizationRule(this.immunizationName).getMaxNumberOfDoses() - this.numberOfDosesGiven;	
	}
	
	public String getImmunizationName() {
		return this.immunizationName;
	}

	@Override
	public void setNumberOfDosesGiven(int dosesGiven) {
		this.numberOfDosesGiven = dosesGiven;
//		this.updateNumberofDosesPending();
		
	}
	
	public ImmunizationRecord() {
		super();
	}

	public int getNumberOfDosesPending() {
		return numberOfDosesPending;
	}

	public void setNumberOfDosesPending(int numberOfDosesPending) {
		this.numberOfDosesPending = numberOfDosesPending;
	}

	public LocalDateTime getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(LocalDateTime nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

	public boolean isOverdue() {
		return isOverdue;
	}

	public void setOverdue(boolean isOverdue) {
		this.isOverdue = isOverdue;
	}

	public int getNumberOfDosesGiven() {
		return this.numberOfDosesGiven;
		
	}
	public boolean checkImmuinityStatus() {
		return this.isImmune;
	}
	
	public boolean checkOverdueStatus() {
		return this.isOverdue;
	}
	
	public void checkImmunizationStatus(LocalDateTime bDate) {
		if(this.numberOfDosesPending > 0) {
			this.nextDueDate = DayCareController.getImmunizationRule(immunizationName).getNextDueDate(bDate, this.numberOfDosesPending);
			this.isOverdue = nextDueDate.isBefore(LocalDateTime.now()) ? true : false;
		}
		else if(this.numberOfDosesPending == 0)
			this.isImmune = true;
	}


}
