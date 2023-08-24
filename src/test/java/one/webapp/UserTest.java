/**
 * 
 */
package one.webapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class UserTest {
	
	private User u;
	private User u2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		u = new User();
		u2 = new User("abc","def","a@a.com","en");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link one.webapp.User#getName()}.
	 */
	@Test
	void testGetName() {
		u.setName("abc");
		
		assertEquals(u.getName(),"abc");
		assertEquals(u2.getName(),"abc");
		
	}

	/**
	 * Test method for {@link one.webapp.User#setName(java.lang.String)}.
	 */
	@Test
	void testSetName() {
		u.setName("def");
		
		assertEquals(u.getName(),"def");
	}

	/**
	 * Test method for {@link one.webapp.User#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		u.setPassword("123");
		
		assertEquals(u.getPassword(),"123");
	}

	/**
	 * Test method for {@link one.webapp.User#setPassword(java.lang.String)}.
	 */
	@Test
	void testSetPassword() {
		u.setPassword("123");
		
		assertEquals(u.getPassword(),"123");
	}

	/**
	 * Test method for {@link one.webapp.User#getEmail()}.
	 */
	@Test
	void testGetEmail() {
		u.setEmail("a@a.com");
		
		assertEquals(u.getEmail(),"a@a.com");
	}

	/**
	 * Test method for {@link one.webapp.User#setEmail(java.lang.String)}.
	 */
	@Test
	void testSetEmail() {
		u.setEmail("a@a.com");
		
		assertEquals(u.getEmail(),"a@a.com");
	}

	/**
	 * Test method for {@link one.webapp.User#getLanguage()}.
	 */
	@Test
	void testGetLanguage() {
		u.setLanguage("en");
		
		assertEquals(u.getLanguage(),"en");
	}

	/**
	 * Test method for {@link one.webapp.User#setLanguage(java.lang.String)}.
	 */
	@Test
	void testSetLanguage() {
		u.setLanguage("en");
		
		assertEquals(u.getLanguage(),"en");
	}

}
