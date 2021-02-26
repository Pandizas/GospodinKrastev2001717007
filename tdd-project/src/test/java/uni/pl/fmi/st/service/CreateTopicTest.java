
package uni.pl.fmi.st.service;
import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import uni.pl.fmi.st.models.Topic;
import uni.pl.fmi.st.repo.ITopicRepo;
/**
 * @author pandi
 *
 */
public class CreateTopicTest {
		private CreateTopicService createTopicService;
		private ITopicRepo topicRepo;

		@Before
		public void setup() {
			topicRepo = mock(ITopicRepo.class);
			Topic topic = new Topic();
			topic.setName("name");
			topic.setBody("body");
			List<Topic> topics = Arrays.asList(topic);
			doReturn(topics).when(topicRepo).findAll();		
			createTopicService = new CreateTopicService(topicRepo);
			}
		
		
		/**
		 * testing {@link CreateTopicService#create(String, String) with null entries.
		 * Expected message for invalid entries
		 */
		@Test
		public void testCreateTopicWithNullEntries() {
			final String result = createTopicService.create(null,null);
			
			assertEquals("Попълнете входните полета", result);
		}
		/**
		 * testing {@link CreateTopicService#create(String, String) with null name and valid body entries.
		 * Expected message for invalid entries
		 */
		@Test
		public void testCreateTopicWithNullName() {
			final String result = createTopicService.create(null,"body");
			
			assertEquals("Попълнете входните полета", result);
		}
		
		/**
		 * testing {@link CreateTopicService#create(String, String) with null name and valid body entries.
		 * Expected message for invalid entries
		 */
		@Test
		public void testCreateTopicWithNullBody() {
			final String result = createTopicService.create("name",null);
			
			assertEquals("Попълнете входните полета", result);
		}
		
		/**
		 * testing {@link CreateTopicService#create(String, String, String)} with valid and existing entries. 
		 * Expected "ОК" message.
		 */
		@Test
		public void testCreateTopicWithValidAndNotExistingEntries() {
			final String result = createTopicService.create("name1","body" );
			
			assertEquals("ОК", result);
		}
		
		/**
		 * testing{@link CreateTopicService#nameLengthTest(String) with invalid entries}
		 */
		@Test
		public void testNameLengthTooShort() {
			final String result = createTopicService.nameLengthTest("name");
			assertEquals("Въведеното не е в границите!", result);
		}
		
		/**
		 * testing{@link CreateTopicService#nameLengthTest(String) with invalid entries}
		 */
		@Test
		public void testNameLengthTooLong() {
			final String result = createTopicService.nameLengthTest("name is too long to appear here ");
			assertEquals("Въведеното не е в границите!", result);
		}
		/**
		 * testing{@link CreateTopicService#nameLengthTest(String) with valid entries}
		 */
		@Test
		public void testNameLengthInBounds() {
			final String result = createTopicService.nameLengthTest("name is in bounds");
			assertEquals("ОК", result);
		}
		/**
		 * testing{@link CreateTopicService#bodyLengthTest(String) with invalid entries}
		 */
		@Test
		public void testBodyLengthTooShort() {
			final String result = createTopicService.bodyLengthTest("body");
			assertEquals("Въведеното не е в границите!", result);
		}
		
		/**
		 * testing{@link CreateTopicService#bodyLengthTest(String) with invalid entries}
		 */
		@Test
		public void testBodyLengthTooLong() {
			final String result = createTopicService.bodyLengthTest("body is too long to appear here ");
			assertEquals("Въведеното не е в границите!", result);
		}
		/**
		 * testing{@link CreateTopicService#bodyLengthTest(String) with valid entries}
		 */
		@Test
		public void testBodyLengthInBounds() {
			final String result = createTopicService.bodyLengthTest("body is in bounds");
			assertEquals("ОК", result);
		}
}


