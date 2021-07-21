import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.dao.UserDAOImpl;
import com.bank.model.User;

public class jtest {

	public UserDAOImpl udao;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testValidLogin() {
		User u1 = new User("test", "user", "testuser", "test@email.com", 0,  "testpass");
		User not = new User( "test", "user", "testuser", "test@mail.com", 0, "testpass");
		
//		when(udao.getUserByUsername(anyString())).thenReturn(u1);
		
//		User loggedIn = uServ.signIn("testuser", "testpass");
		
//		assertEquals(u1.getId(), loggedIn.getId());
	}
}
