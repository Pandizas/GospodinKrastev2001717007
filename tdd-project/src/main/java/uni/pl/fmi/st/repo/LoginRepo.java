package uni.pl.fmi.st.repo;

import java.util.Collections;
import java.util.List;

import uni.pl.fmi.st.models.User;

/**
 * 
 * @author pandi
 *
 */

public class LoginRepo implements ILoginRepo {

	
	/**
	 * Returns all users from DB
	 * @return not null {@link List<User>}
	 */
	public List<User> findAll() {
		return Collections.emptyList();
	}

}
