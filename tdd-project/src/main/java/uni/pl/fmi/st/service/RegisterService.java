/**
 * 
 */
package uni.pl.fmi.st.service;
import java.util.List;
import java.util.function.Predicate;

import uni.pl.fmi.st.models.User;
import uni.pl.fmi.st.repo.ILoginRepo;
import uni.pl.fmi.st.repo.LoginRepo;
/**
 * Provides user register functionality. Expected username and matching user passwords
 * @param username String represents username. Invalid {@code Null} or empty String
 * @param pass1 String represents user password. Invalid {@code Null} or empty String
 * @param pass2 String represents user password. Invalid {@code Null} or empty String
 * @return String message from user register state.
 *
 */
public class RegisterService {

	final ILoginRepo loginRepo;
	
	public RegisterService(ILoginRepo loginRepo) {
		this.loginRepo=loginRepo;
		
	}

	public String register(final String username, final String pass1, final String pass2) {
		String result = null;
		
		if(username == null || pass1 ==null || pass2== null) {
			result = "Попълнете полетата за регистрация";
		}else if(!pass1.equals(pass2)) {
			result = "Въведете еднакви пароли!";
		}
		else {
			List<User> users = loginRepo.findAll();
			Predicate<? super User> predicate = user -> user.getUsername().equals(username);
			boolean isUserMatch = users.stream().anyMatch(predicate);
			result = isUserMatch?"Потребител с тези данни вече съществува": "ОК";
		}
		return result;
	}
	
	
}
