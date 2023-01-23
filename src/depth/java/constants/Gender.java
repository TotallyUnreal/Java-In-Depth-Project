package depth.java.constants;

public enum Gender {
	
	MALE(0),
	FEMALE(1),
	OTHER(2);
	
	
	private Gender(int gender) {
		this.gender = gender;
	}
	
	private int gender;
	
	public int getGender() {
		return gender;
	}
}
