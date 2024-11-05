package jp.ebiten.katsu.domain.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class TweetEntityTest {

	@Test
	void testNoArgsConstructor() {
		Tweet tweet = new Tweet();
		assertNotNull(tweet);
		assertNull(tweet.getId());
		assertNull(tweet.getContent());
		assertNull(tweet.getUser());
		assertNull(tweet.getCreatedAt());
	}
	
	@Test
	void testAllArgsconstructor() {
		User user = new User();
		LocalDateTime now = LocalDateTime.now();
		Tweet tweet = new Tweet(1L, "Test", user, now);
		
		assertEquals(1L, tweet.getId());
		assertEquals("Test", tweet.getContent());
		assertEquals(user, tweet.getUser());
		assertEquals(now, tweet.getCreatedAt());
	}
	
	@Test
	void testGetIdAndSetId() {
		Tweet tweet = new Tweet();
		tweet.setId(1L);
		assertEquals(1L, tweet.getId());
	}
	
	@Test
	void testGetContentAndSetContent() {
		Tweet tweet = new Tweet();
		tweet.setContent("Test");
		assertEquals("Test", tweet.getContent());
	}
	
	//同値性を示している・・・？
	@Test
	void testGetUserAndSetUser() {
		User user = new User();
		Tweet tweet = new Tweet();
		tweet.setUser(user);
		assertEquals(user, tweet.getUser());
	}
	
	@Test
	void testGetCreatedAtAndGetCreatedAt() {
		Tweet tweet = new Tweet();
		LocalDateTime now = LocalDateTime.now();
		tweet.setCreatedAt(now);
		assertEquals(now, tweet.getCreatedAt());
	}
	
	/*
	@Test
	void testEqualsAndHashCode() {
		User user1 = new User();
		LocalDateTime time1 = LocalDateTime.now();
		
		User user2 = new User();
		LocalDateTime time2 = LocalDateTime.now();
		
		Tweet tweet1 = new Tweet(1L, "Conten1t", user1, time1);
		Tweet tweet2 = new Tweet(1L, "Content1", user1, time1);
		Tweet tweet3 = new Tweet(2L, "Content2", user2, time2);

		assertEquals(tweet1, tweet2);
		assertNotEquals(tweet1, tweet3);
		assertEquals(tweet1.hashCode(), tweet2.hashCode());
		assertNotEquals(tweet1.hashCode(), tweet3.hashCode());
	}
	*/
	
	/*
	 * toStringのtest
	 *
	 */
}
