package depth.java.managers;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import depth.java.constants.BookGenre;
import depth.java.constants.KidFriendlyStatus;
import depth.java.constants.MovieGenre;
import depth.java.dao.BookmarkDao;
import depth.java.entities.Book;
import depth.java.entities.Bookmark;
import depth.java.entities.Movie;
import depth.java.entities.User;
import depth.java.entities.UserBookmark;
import depth.java.entities.WebLink;
import depth.java.util.HttpConnect;
import depth.java.util.IOUtil;

public class BookmarkService {
	private static BookmarkService instance = new BookmarkService();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkService() {
	}

	public static BookmarkService getInstance() {
		return instance;
	}

	/*
	 * public Bookmark createBookmark(long idField, String title, String profileUrl)
	 * { Bookmark bookmark = new Bookmark();
	 * 
	 * bookmark.setIdField(idField); bookmark.setTitle(title);
	 * bookmark.setProfileUrl(profileUrl);
	 * 
	 * return bookmark; }
	 */

	public WebLink createWebLink(long id, String title, String url, String host) {
		WebLink webLink = new WebLink();

		webLink.setIdField(id);
		webLink.setTitle(title);
		webLink.setUrl(url);
		webLink.setHost(host);

		return webLink;
	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, BookGenre genre,
			double amazonRating) {
		Book book = new Book();

		book.setIdField(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, MovieGenre genre, double imdbRating) {
		Movie movie = new Movie();

		movie.setIdField(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;
	}

	public List<List<Bookmark>> getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);

		/*
		if(bookmark instanceof WebLink) {
			try {
				String url = ((WebLink)bookmark).getUrl();
				if(!url.endsWith(".pdf")) {
					String webpage = HttpConnect.download(url);
					System.out.println("\nOutside webpage != null if statement\n");
					System.out.println("Value of \"webpage != null\" is " + (webpage!=null));
					System.out.println("Value of webpage: " + webpage);
					if(webpage != null) {
						System.out.println("\n Downloading... " + webpage + " to " + bookmark.getIdField() + "\n");
						IOUtil.write(webpage, bookmark.getIdField());
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch(URISyntaxException e) {
				e.printStackTrace();
			}
		}
		*/
		
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println(
				"Kid-friendly status: " + kidFriendlyStatus + ", Marked by: " + user.getEmail() + ", " + bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		
		System.out.println("Data to be shared: ");
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
		} else if(bookmark instanceof WebLink) {
			System.out.println(((WebLink) bookmark).getItemData());
		}
	}
}
