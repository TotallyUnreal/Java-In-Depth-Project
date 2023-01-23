package depth.java;

import java.util.ArrayList;
import java.util.List;

import depth.java.constants.BookGenre;
import depth.java.constants.Gender;
import depth.java.constants.MovieGenre;
import depth.java.entities.Bookmark;
import depth.java.entities.User;
import depth.java.entities.UserBookmark;
import depth.java.managers.BookmarkService;
import depth.java.managers.UserService;
import depth.java.util.IOUtil;

public class DataStore {

	private static List<User> users = new ArrayList<>();
	private static List<List<Bookmark>> bookmarks = new ArrayList<>();
	private static List<UserBookmark> userBookmarks = new ArrayList<>();
	
	private static int bookmarkIndex;

	public static void loadData() {
		loadUsers();
		loadWeblinks();
		loadMovies();
		loadBooks();
	}

	private static void loadUsers() {
		//String[] data = new String[TOTAL_USER_COUNT];
		List<String> data = new ArrayList<>();
		IOUtil.read(data, "User");
		for(String row: data) {
			String[] values = row.split("\t");
			
			Gender gender = Gender.MALE;
			if(values[5].equals("f")) {
				gender = Gender.FEMALE;
			} else if(values[5].equals("T")) {
				gender = Gender.OTHER;
			}
			
			users.add(UserService.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2],
				values[3], values[4], gender, values[6]));
		}
	}

	private static void loadWeblinks() {
		List<String> data = new ArrayList<>();
		IOUtil.read(data, "WebLink");
		
		// Or you can do it this way
		List<Bookmark> bookmarkList = new ArrayList<>();
		for(String row: data) {
			String[] values = row.split("\t");
			
			Bookmark bookmark = BookmarkService.getInstance().createWebLink(Long.parseLong(values[0]),
					values[1], values[2], values[3]);
			// I did it this way in this method and in other methods if there is a problem this is probably it.
			bookmarkList.add(bookmark);
		}
		// Then
		bookmarks.add(bookmarkList);
		
	}

	private static void loadMovies() {
		List<String> data = new ArrayList<>();
		IOUtil.read(data, "Movie");
		
		List<Bookmark> bookmarkList = new ArrayList<>();
		for(String row: data) {
			String[] values = row.split("\t");
			String[] cast = values[3].split(",");
			String[] directors = values[4].split(",");
			bookmarkList.add(BookmarkService.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast,
					directors, MovieGenre.valueOf(values[5].toUpperCase()), Double.parseDouble(values[6])));
		}
		bookmarks.add(bookmarkList);
	}

	public static List<List<Bookmark>> getBookmarks() {
		return bookmarks;
	}

	public static List<User> getUsers() {
		return users;
	}

	private static void loadBooks() {
		List<String> data = new ArrayList<>();
		IOUtil.read(data, "Book");
		
		List<Bookmark> bookmarkList = new ArrayList<>();
		for(String row: data) {
			String[] values = row.split("\t");
			
			bookmarkList.add(BookmarkService.getInstance().createBook(Long.parseLong(values[0]), values[1],
					Integer.parseInt(values[2]), values[3], values[4].split(","), BookGenre.valueOf(values[5].toUpperCase()), Double.parseDouble(values[6])));
		}
		bookmarks.add(bookmarkList);
	}

	public static void add(UserBookmark userBookmark) {
		userBookmarks.add(userBookmark);
	}
}
