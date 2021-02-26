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
import uni.pl.fmi.st.models.User;
import uni.pl.fmi.st.models.Topic;
import uni.pl.fmi.st.repo.ITopicRepo;

/**
 * Test class for {@link DeleteTopicService}
 *
 */
public class DeleteTopicTest {
		private DeleteTopicService deleteTopicService;
		private ITopicRepo topicRepo;
		
		
		@Before
		public void setup() {
			topicRepo = mock(ITopicRepo.class);
			User user = new User();
			user.setRole("admin");
			Topic topic = new Topic();
			topic.setBody("body");
			topic.setName("name");
			List<Topic> topics = Arrays.asList(topic);
			doReturn(topics).when(topicRepo).delete();
			deleteTopicService = new DeleteTopicService(topicRepo);
			
		}
		
		/**
		 * Testing {@link DeleteTopicService#delete(String, String) with valid role and topic name.
		 */
		@Test
		public void testDeleteTopicWithAdminRole() {
			final String result = deleteTopicService.delete("name", "admin");
			assertEquals("ОК", result);
		}
		/**
		 * Testing {@link DeleteTopicService#delete(String, String) with invalid role.
		 */
		@Test
		public void testDeleteTopicWithInvalidRole() {
			final String result = deleteTopicService.delete("name", "user");
			assertEquals("Нямате правомощия за тази операция", result);
		}
		/**
		 * Testing {@link DeleteTopicService#delete(String, String) with invalid role.
		 */
		@Test
		public void testDeleteTopicWithInvalidName() {
			final String result = deleteTopicService.delete("invalid name", "admin");
			assertEquals("Няма такава тема", result);
		}
		
		
}
