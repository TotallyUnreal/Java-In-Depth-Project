package depth.java.dao;

import java.util.ArrayList;
import java.util.List;

import depth.java.DataStore;
import depth.java.entities.Bookmark;
import depth.java.entities.UserBookmark;
import depth.java.entities.WebLink;

public class BookmarkDao {
	public List<List<Bookmark>> getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
	
	// In real application, we would have SQL or hibernate queries
	public List<WebLink> getAllWebLinks() {
		List<WebLink> result = new ArrayList<>();
		
		List<List<Bookmark>> bookmarks = DataStore.getBookmarks();
		List<Bookmark> allWebLinks = bookmarks.get(0);
		
		for(Bookmark bookmark: allWebLinks) {
			result.add((WebLink)bookmark);
		}
		return result;
	}
	
	public List<WebLink> getWebLinks(WebLink.DownloadStatus downloadStatus) {
		List<WebLink> result = new ArrayList<>();

		List<WebLink> allWebLinks = getAllWebLinks();
		
		for(WebLink weblink: allWebLinks) {
			if(weblink.getDownloadStatus().equals(downloadStatus)) {
				result.add(weblink);
			}
		}
		
		return result;
	}
}
