package depth.java;

import depth.java.entities.Bookmark;
import depth.java.entities.User;
import depth.java.managers.BookmarkService;
import depth.java.managers.UserService;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading data ...");
		DataStore.loadData();
		
		users = UserService.getInstance().getUsers();
		bookmarks = BookmarkService.getInstance().getBookmarks();
		
		System.out.println("Printing data ...");
		printUserData();
		printBookmarkData();
	}

	private static void printUserData() {
		for(User user : users) {
			System.out.println(user);
		}
	}

	private static void printBookmarkData() {
		for(Bookmark[] bookmarksArray: bookmarks) {
			for(Bookmark bookmark: bookmarksArray) {
				System.out.println(bookmark);
			}
		}
	}
	
	public static void main(String[] args) {
		loadData();
	}

	
	
}
