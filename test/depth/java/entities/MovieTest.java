package depth.java.entities;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import depth.java.constants.MovieGenre;
import depth.java.managers.BookmarkService;

class MovieTest {
	@Test
	void testIsKidFriendlyEligible() {
		// Test1 genre is Horror -- false
		Movie movie = BookmarkService.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		
		boolean isKidFriendly = movie.isKidFriendlyEligible();
		
		assertFalse("For genre Horror isKidFriendlyEligible() should be false", isKidFriendly);
		
		// Test2 genre is Thriller -- false
		movie = BookmarkService.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		
		isKidFriendly = movie.isKidFriendlyEligible();
		
		assertFalse("For genre Thriller isKidFriendlyEligible() should be false", isKidFriendly);
	}

}
