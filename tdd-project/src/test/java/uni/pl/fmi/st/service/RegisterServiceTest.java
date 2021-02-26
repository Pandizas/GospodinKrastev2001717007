/**
 * 
 */
package uni.pl.fmi.st.service;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import uni.pl.fmi.st.models.User;
import uni.pl.fmi.st.repo.ILoginRepo;

/**
 * Test class for{@link RegisterService}
 *
 */
public class RegisterServiceTest {

	
	private RegisterService registerService;
	private ILoginRepo loginRepo;
	
	@Before
	public void setup() {
		loginRepo = mock(ILoginRepo.class);
		User user = new User();
		user.setPassword("pass");
		user.setUsername("username");
		List<User> users = Arrays.asList(user);
		doReturn(users).when(loginRepo).findAll();
		registerService = new RegisterService(loginRepo);
		
	}
	
	
	/***
	 * testing {@link RegisterService#register(String, String, String)} with null entries. 
	 * Expected message for invalid entries.
	 */
	@Test
	public void testRegisterWithNullEntries() {
		final String result = registerService.register(null,null,null);
		
		assertEquals("Попълнете полетата за регистрация", result);
	}
	/***
	 * testing {@link RegisterService#register(String, String, String)} with null username and valid password entries. 
	 * Expected message for invalid entries.
	 */
	@Test
	public void testRegisterWithNullUsername() {
		final String result = registerService.register(null, "pass", "pass");
		
		assertEquals("Попълнете полетата за регистрация", result);
	}
	/***
	 * testing {@link RegisterService#register(String, String, String)} with null pass1 and valid username and pass2 entries. 
	 * Expected message for invalid entries.
	 */
	@Test
	public void testRegisterWithNullPass1() {
		final String result = registerService.register("username", null, "pass");
		
		assertEquals("Попълнете полетата за регистрация", result);
	}
	/***
	 * testing {@link RegisterService#register(String, String, String)} with null pass2 and valid username and pass1 entries. 
	 * Expected message for invalid entries.
	 */
	@Test
	public void testRegisterWithNullPass2() {
		final String result = registerService.register("username", "pass", null);
		
		assertEquals("Попълнете полетата за регистрация", result);
	}
	/***
	 * testing {@link RegisterService#register(String, String, String)} with valid and existing entries. 
	 * Expected "Потребител с тези данни вече съществува" message.
	 */
	@Test
	public void testRegisterWithValidAndExistingEntries() {
		final String result = registerService.register("username", "pass", "pass");
		
		assertEquals("Потребител с тези данни вече съществува", result);
	}
	/***
	 * testing {@link RegisterService#register(String, String, String)} with valid and existing entries. 
	 * Expected "ОК" message.
	 */
	@Test
	public void testRegisterWithValidAndNotExistingEntries() {
		final String result = registerService.register("username1", "pass", "pass");
		
		assertEquals("ОК", result);
	}
	/***
	 * testing {@link RegisterService#register(String, String, String)} with valid and existing entries. 
	 * Expected "Въведете еднакви пароли!" message.
	 */
	@Test
	public void testRegisterWithNotMatchingPasswords() {
		final String result = registerService.register("username", "pass", "pass1");
		
		assertEquals("Въведете еднакви пароли!", result);
	}
	
	
	
	
	
	
}
