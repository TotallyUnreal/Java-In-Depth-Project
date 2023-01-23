package depth.java.entities;

import depth.java.constants.KidFriendlyStatus;

public abstract class Bookmark {
	private long idField;
	private String title;
	private String profileUrl;
	private KidFriendlyStatus kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;
	private User sharedBy;

	public long getIdField() {
		return idField;
	}

	public void setIdField(long idField) {
		this.idField = idField;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	
	public abstract boolean isKidFriendlyEligible();

	public KidFriendlyStatus getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}

	public void setKidFriendlyStatus(KidFriendlyStatus kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}

	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}

	public User getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}
	
}
