package edu.neu.csye6200.daycare.objects;

public class EnrollmentRules {
	private int minAge;
	private int maxAge;
	private String ageRange;
	private int groupSize;
	private String ratio;
	private int maxGroup;
	
	public EnrollmentRules(int minAge, int maxAge, String ageRange, int groupSize, String ratio, int maxGroup) {
		super();
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.ageRange = ageRange;
		this.groupSize = groupSize;
		this.ratio = ratio;
		this.maxGroup = maxGroup;
	}

	public int getMinAge() {
		return minAge;
	}

	@Override
	public String toString() {
		return "EnrollmentRules [minAge=" + this.minAge + ", maxAge=" + this.maxAge + ", ageRange=" + this.ageRange + ", groupSize="
				+ this.groupSize + ", ratio=" + this.ratio + ", maxGroup=" + this.maxGroup + "]";
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	public int getMaxGroup() {
		return maxGroup;
	}

	public void setMaxGroup(int maxGroup) {
		this.maxGroup = maxGroup;
	}

	public void showRuleDetails() {
		this.toString();
	}
}
