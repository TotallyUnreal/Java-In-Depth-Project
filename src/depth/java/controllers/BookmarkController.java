package depth.java.controllers;

import depth.java.constants.KidFriendlyStatus;
import depth.java.entities.Bookmark;
import depth.java.entities.User;
import depth.java.managers.BookmarkService;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	
	private BookmarkController() {}
	
	public static BookmarkController getInstance() {
		return instance;
	}
	
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkService.getInstance().saveUserBookmark(user, bookmark);
	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
		BookmarkService.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkService.getInstance().share(user, bookmark);
	}
}
