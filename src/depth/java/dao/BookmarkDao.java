package depth.java.dao;

import depth.java.DataStore;
import depth.java.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}
}
