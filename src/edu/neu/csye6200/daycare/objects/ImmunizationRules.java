package edu.neu.csye6200.daycare.objects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ImmunizationRules {
	
	private int maxNumberOfDoses;
	private List<Integer> dosageIntervals;

	public ImmunizationRules() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImmunizationRules(int maxNumberOfDoses) {
		super();
		this.maxNumberOfDoses = maxNumberOfDoses;
	}

	public int getMaxNumberOfDoses() {
		return maxNumberOfDoses;
	}

	public void setMaxNumberOfDoses(int maxNumberOfDoses) {
		this.maxNumberOfDoses = maxNumberOfDoses;
	}
	
	public LocalDateTime getNextDueDate(LocalDateTime bDate, int numberOfDosesPending) {
		if(numberOfDosesPending > 0)	{
			bDate = bDate.plusMonths(this.dosageIntervals.get(this.maxNumberOfDoses - numberOfDosesPending));
		}
		return bDate;
	}

	public ImmunizationRules(int maxNumberOfDoses, List<Integer> dosageIntervals) {
		super();
		this.dosageIntervals = new ArrayList<Integer>();
		this.maxNumberOfDoses = maxNumberOfDoses;
		for (Integer integer : dosageIntervals) {
			this.dosageIntervals.add(integer);
		}
	}
		

}
