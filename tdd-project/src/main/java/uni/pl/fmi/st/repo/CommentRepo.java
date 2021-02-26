/**
 * 
 */
package uni.pl.fmi.st.repo;

import java.util.Collections;
import java.util.List;

import uni.pl.fmi.st.models.Comment;

/**
 * @author pandi
 *
 */
public class CommentRepo implements ICommentRepo {

	
	
	/**
	 * Returns all comments from DB
	 * @return not null({@link List<Comments>}
	 */
	public List<Comment> findAll(){
		return Collections.emptyList();
	}
	/**
	 * Deletes comments from DB
	 * @return not null{@link List<Comments>}
	 */
	public List<Comment> delete(){
		return Collections.emptyList();
	}
}