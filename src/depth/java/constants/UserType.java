package depth.java.constants;

public enum UserType {
	
	USER("User"),
	EDITOR("Editor"),
	CHIEF_EDITOR("Chief editor");
	
	private UserType(String name) {
		this.name = name;
	}
	
	private String name;
	public String getName() {
		return name;
	}
}
