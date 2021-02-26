/**
 * 
 */
package uni.pl.fmi.st.service;

import java.util.List;
import java.util.function.Predicate;

import uni.pl.fmi.st.models.Comment;
import uni.pl.fmi.st.models.Topic;
import uni.pl.fmi.st.repo.ICommentRepo;

/**
 * Provides user comment functionality. expected commentBody
 * @param commentBody String that represents the comment. Invalid{@code Null} or empty String
 * @return String message from user comment state
 */
public class CommentService {
	final ICommentRepo commentRepo;
	
	public CommentService(ICommentRepo commentRepo)
	{
		this.commentRepo = commentRepo;
	}

	public String create(final String commentBody) {
		
		String result = null;
		
		if(commentBody ==null) {
			result = "Попълнете входните полета";
		}else {
			result = "OK";
		}
		
		
		
		return result;
	}	
	/**
	 * @bodyLengthTest adds functionallity of testing min and max comment length
	 * @param commentBody String that represents the comment. Invalid{@code Null} or empty String
	 * @return String message from user comment state
	 */
	public String bodyLengthTest(final String commentBody) {
		String result = null;
		if((commentBody.length())<=5) {
			result = "Въведеното не е в границите!";		
	}else if ((commentBody.length())>=25) {
		result = "Въведеното не е в границите!";
	}
		else {
		result = "ОК";
	}
		return result;
		}

}
