/**
 * 
 */
package uni.pl.fmi.st.service;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uni.pl.fmi.st.models.User;
import uni.pl.fmi.st.models.Comment;
import uni.pl.fmi.st.models.Topic;
import uni.pl.fmi.st.repo.ICommentRepo;
import uni.pl.fmi.st.repo.ITopicRepo;
/**
 * 
 * Test class for {@link DeleteCommentService}
 *
 */
public class DeleteCommentServiceTest {
	private DeleteCommentService deleteCommentService;
	private ICommentRepo commentRepo;
	
	
	@Before
	public void setup() {
		commentRepo = mock(ICommentRepo.class);
		User user = new User();
		user.setRole("admin");
		Comment comment = new Comment();
		comment.setCommentBody("commentBody");
		List<Comment> comments = Arrays.asList(comment);
		doReturn(comments).when(commentRepo).delete();
		deleteCommentService = new DeleteCommentService(commentRepo);
		
	}
	
	/**
	 * Testing {@link DeleteCommentService#delete(String, String) with valid role and comment name.
	 */
	@Test
	public void testDeleteCommentWithAdminRole() {
		final String result = deleteCommentService.delete("commentBody", "admin");
		assertEquals("ОК", result);
	}
	/**
	 * Testing {@link DeleteCommentService#delete(String, String) with invalid role.
	 */
	@Test
	public void testDeleteCommentWithInvalidRole() {
		final String result = deleteCommentService.delete("commentBody", "user");
		assertEquals("Нямате правомощия за тази операция", result);
	}
	/**
	 * Testing {@link DeleteCommentService#delete(String, String) with invalid role.
	 */
	@Test
	public void testDeleteCommentWithInvalidName() {
		final String result = deleteCommentService.delete("invalid comment body", "admin");
		assertEquals("Няма такъв коментар", result);
	}
	
	
}
