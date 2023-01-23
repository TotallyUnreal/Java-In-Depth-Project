package depth.java.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import depth.java.managers.BookmarkService;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test1 porn in url -- false
		WebLink webLink =  BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		
		boolean isKidFriendly = webLink.isKidFriendlyEligible();
		
		assertFalse("For porn in url isKidFriendly() should return false", isKidFriendly);
		//Test2 porn in title -- false
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-Tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendly = webLink.isKidFriendlyEligible();
		
		assertFalse("For porn in title isKidFriendly should be false", isKidFriendly);
		
		//Test3 adult in host -- false
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-Tiger--part-2.html",
				"http://www.adultworld.com");
		
		isKidFriendly = webLink.isKidFriendlyEligible();
		
		assertFalse("For adult in host isKidFriendly() should be false", isKidFriendly);
		
		//Test4 adult in url, but not in host part -- true
		
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/adult/2072759/core-java/taming-Tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendly = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in url but not in host part, isKidFriendly() should be true", isKidFriendly);
		
		
		//Test5 adult in title only -- true
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-Tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendly = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in title only, isKidFriendly() should be true", isKidFriendly);
		
	}

}
