package edu.neu.csye6200.daycare.objects;

public abstract class AbstractImmunizationFactory {
	
	public abstract Immunization getObject();
	
	public abstract Immunization getObject(String csvData);
	

}
