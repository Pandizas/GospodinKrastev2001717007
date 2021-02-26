package uni.pl.fmi.st.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import uni.pl.fmi.st.models.User;
import uni.pl.fmi.st.repo.ILoginRepo;

@RunWith(Parameterized.class)
public class LoginServiceParametrizedTest {
    @Parameters(name = "{index}: with username={0}, pass1={1}, pass2={2} and expected message ={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{ null, null, null, "Въведете валидни входни аргументи" }, //
        	{ null, "pass","pass","Въведете валидни входни аргументи" },//
            { "username", null, "pass", "Въведете валидни входни аргументи" }, //
            { "username", "pass", null, "Въведете валидни входни аргументи" },//
            { "username", "pass", "pass", "OK"},//
            { "username1", "pass", "pass", "Потребител с тези данни не съществува!"},//
            { "username", "pass1", "pass1", "Потребител с тези данни не съществува!"},//
            { "username", "pass", "pass1", "Въведете еднакви пароли!"},//
            //
        	});
    }

    @Parameter(0)
    public String username;
    @Parameter(1)
    public String pass1;
    @Parameter(2)
    public String pass2;
    @Parameter(3)
    public String expectedMessage;



	private LoginService loginService;
	private ILoginRepo loginRepo;
	
	
	@Before
	public void setup() {
		loginRepo = mock(ILoginRepo.class);
		User user = new User();
		user.setPassword("pass");
		user.setUsername("username");
		List<User> users = Arrays.asList(user);
		doReturn(users).when(loginRepo).findAll();
		loginService = new LoginService(loginRepo);
	}
	


	/***
	 * testing {@link LoginService#login(String, String, String)} with null entries. 
	 * Expected message for invalid entries.
	 */
	@Test
	public void testLogin() {
		final String result = loginService.login(username, pass1, pass2);
		
		assertEquals(expectedMessage, result);
	}
}
