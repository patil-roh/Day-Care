package edu.neu.csye6200.daycare.objects;

public class Person extends AbstractPersonAPI {
	private String firstName = null;
	private String lastName = null;


	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	@Override
	public void show() {
		this.toString();
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
