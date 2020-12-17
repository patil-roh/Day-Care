package edu.neu.csye6200.daycare.factory;

import edu.neu.csye6200.daycare.objects.Immunization;
import edu.neu.csye6200.daycare.objects.ImmunizationRecord;

import java.util.List;
import java.util.Vector;
import java.util.ArrayList;

import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.objects.AbstractImmunizationFactory;

public class ImmunizationFactory extends AbstractImmunizationFactory {
	
	
	private static ImmunizationFactory immunizationFactoryInstance;
	
	private ImmunizationFactory() {
		ImmunizationFactory.immunizationFactoryInstance = null;
	}
	
	public static ImmunizationFactory getInstance() {
		
		if(ImmunizationFactory.immunizationFactoryInstance == null) {
			immunizationFactoryInstance = new ImmunizationFactory();
		}
		
		return immunizationFactoryInstance;
		
	}

	@Override
	public Immunization getObject() {
		return (new ImmunizationRecord());
	}

	@Override
	public Immunization getObject(String csvData) {
		
		String[] ObjData = csvData.split(",");
		int dosesGiven = Integer.parseInt(ObjData[0]);	
		return new ImmunizationRecord(ObjData[1], dosesGiven);
	}

}
