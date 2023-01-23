package depth.java;

import java.util.List;

import depth.java.bgjobs.WebpageDownloaderTask;
import depth.java.entities.Bookmark;
import depth.java.entities.User;
import depth.java.managers.BookmarkService;
import depth.java.managers.UserService;

public class Launch {
	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading data ...");
		DataStore.loadData();
		
		users = UserService.getInstance().getUsers();
		bookmarks = BookmarkService.getInstance().getBookmarks();
		
//		System.out.println("Printing data ...");
//		printUserData();
//		printBookmarkData();
	}

	private static void printUserData() {
		for(User user : users) {
			System.out.println(user);
		}
	}

	private static void printBookmarkData() {
		for(List<Bookmark> bookmarksArray: bookmarks) {
			for(Bookmark bookmark: bookmarksArray) {
				System.out.println(bookmark);
			}
		}
	}
	
	private static void start() {
		//System.out.println("\n2. Bookmarking ...");
		for (User user : users) {
			View.browse(user, bookmarks);
		}
	}
	
	public static void main(String[] args) {
		loadData();
		start();
		
		//Background Jobs
		runDownloaderJob();
	}
	
	private static void runDownloaderJob() {
		WebpageDownloaderTask task = new WebpageDownloaderTask(true);
		(new Thread(task)).start();
	}
}
