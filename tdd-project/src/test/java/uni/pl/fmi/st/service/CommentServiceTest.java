/**
 * 
 */
package uni.pl.fmi.st.service;
import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import uni.pl.fmi.st.models.Comment;
import uni.pl.fmi.st.repo.ICommentRepo;

/**
 * Test class for {@link Comment Service}
 *
 */
public class CommentServiceTest {
	
		private CommentService commentService;
		private ICommentRepo commentRepo;
		
		@Before
		public void setup() {
			commentRepo = mock(ICommentRepo.class);
			Comment comment = new Comment();
			comment.setCommentBody("comment");
			comment.setUsername("user");
			List<Comment> comments = Arrays.asList(comment);
			doReturn(comments).when(commentRepo).findAll();
			commentService = new CommentService(commentRepo);
			
		}
		/**
		 * testing {@link CreateTopicService#create(String, String) with null entries.
		 * Expected message for invalid entries
		 */
		@Test
		public void testCreateCommentWithNullEntries() {
			final String result = commentService.create(null);
			
			assertEquals("Попълнете входните полета", result);
		}
		
		/**
		 * testing{@link CommentService#create(String) with valid entries
		 * expected message OK
		 */
		@Test
		public void testCreateCommentWithValidEntries() {
			final String result = commentService.create("comment");
			
			assertEquals("OK", result);
		}
		/**
		 * testing{@link CommentService#bodyLengthTest(String) with invalid entries}
		 */
		@Test
		public void testBodyLengthTooShort() {
			final String result = commentService.bodyLengthTest("body");
			assertEquals("Въведеното не е в границите!", result);
		}
		
		/**
		 * testing{@link CommentService#bodyLengthTest(String) with invalid entries}
		 */
		@Test
		public void testBodyLengthTooLong() {
			final String result = commentService.bodyLengthTest("body is too long to appear here ");
			assertEquals("Въведеното не е в границите!", result);
		}
		/**
		 * testing{@link CommentService#bodyLengthTest(String) with valid entries}
		 */
		@Test
		public void testBodyLengthInBounds() {
			final String result = commentService.bodyLengthTest("body is in bounds");
			assertEquals("ОК", result);
		}


}



