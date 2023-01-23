package depth.java.constants;

public enum KidFriendlyStatus {
	APPROVED("approved"),
	REJECTED("rejected"),
	UNKNOWN("unknown");
	
	private KidFriendlyStatus(String kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}
	
	private String kidFriendlyStatus;
	public String getkidFriendlyStatus() {
		return kidFriendlyStatus;
	}
}
