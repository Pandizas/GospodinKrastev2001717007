package uni.pl.fmi.st.service;
import java.util.List;
import java.util.function.Predicate;

import uni.pl.fmi.st.models.Comment;
import uni.pl.fmi.st.models.Topic;
import uni.pl.fmi.st.repo.ICommentRepo;
import uni.pl.fmi.st.repo.ITopicRepo;

/**
 * Provides admin comment delete functionality. Expected comment body and user role
 * @param commentBody String represents comment. Invalid {@code NotFound} if not found
 * @param role String represents user role. Invalid {@code NotFound} if not found
 * @return String message from delete comment state.
 *
 */
public class DeleteCommentService {
	final ICommentRepo commentRepo;
	
	public DeleteCommentService(ICommentRepo commentRepo) {
		this.commentRepo = commentRepo;
		}
	
	public String delete(final String commentBody, final String role) {
		String result = null;
		if(role == "admin") {
			List<Comment> comments = commentRepo.delete();
			Predicate<? super Comment> predicate = topic -> topic.getCommentBody().equals(commentBody);
			boolean isCommentMatch = comments.stream().anyMatch(predicate);
			result =isCommentMatch?"ОК":"Няма такъв коментар";
		}else {
			result = "Нямате правомощия за тази операция";
		}
		return result;
	}
	
}
