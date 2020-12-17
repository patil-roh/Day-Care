package edu.neu.csye6200.daycare.objects;


import java.time.LocalDateTime;

public interface Immunization {
	
	public void setImmunizationName(String name);
	public String getImmunizationName();
	public void setNumberOfDosesGiven(int doses);
	public void checkImmunizationStatus(LocalDateTime bDate);
	public LocalDateTime getNextDueDate();
	public void updateNumberofDosesPending();
	public int getNumberOfDosesPending();
	public void setNumberOfDosesPending(int numberOfDosesPending);
	public int getNumberOfDosesGiven();
	public boolean checkImmuinityStatus();
	public boolean checkOverdueStatus();

}
