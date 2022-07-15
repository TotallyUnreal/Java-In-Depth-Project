package java.depth.managers;

import java.depth.dao.BookmarkDao;
import java.depth.entities.Book;
import java.depth.entities.Bookmark;
import java.depth.entities.Movie;
import java.depth.entities.WebLink;

public class BookmarkService {
	private static BookmarkService instance = new BookmarkService();
	private static BookmarkDao dao = new BookmarkDao();
	
	private BookmarkService() {
	}

	public static BookmarkService getInstance() {
		return instance;
	}

	public Bookmark createBookmark(long idField, String title, String profileUrl) {
		Bookmark bookmark = new Bookmark();

		bookmark.setIdField(idField);
		bookmark.setTitle(title);
		bookmark.setProfileUrl(profileUrl);

		return bookmark;
	}

	public WebLink createWebLink(long id, String title, String url, String host) {
		WebLink webLink = new WebLink();

		webLink.setIdField(id);
		webLink.setTitle(title);
		webLink.setUrl(url);
		webLink.setHost(host);

		return webLink;
	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre,
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
			String[] directors, String genre, double imdbRating) {
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
	
	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}
}
