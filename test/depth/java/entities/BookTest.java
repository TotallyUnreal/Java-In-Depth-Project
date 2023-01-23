package depth.java.entities;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import depth.java.constants.BookGenre;
import depth.java.managers.BookmarkService;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test1 Book genre is Philosophy -- false
		Book book = BookmarkService.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
		
		boolean isKidFriendly = book.isKidFriendlyEligible();
		
		assertFalse("For Book genre Philosophy isKidFriendlyEligible should return false", isKidFriendly);
		
		// Test2 Book genre is Self-help -- false
		book = BookmarkService.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
		
		isKidFriendly = book.isKidFriendlyEligible();
		
		assertFalse("For Book genre Self-help isKidFriendlyEligible should return false", isKidFriendly);
	}

}
