package uni.pl.fmi.st.service;
import java.util.List;
import java.util.function.Predicate;

import uni.pl.fmi.st.models.Topic;
import uni.pl.fmi.st.repo.ITopicRepo;

/**
 * 
 * Provides admin topic delete functionality. Expected topic name and user role
 * @param name String that represents the name of the topic. Invalid if not found
 * @param role String that represents the role of the user. Invalid if not found
 * @return String message from delete topic state
 *
 */


public class DeleteTopicService {
	final ITopicRepo topicRepo;
	
	public DeleteTopicService(ITopicRepo topicRepo) {
		this.topicRepo = topicRepo;
		}
	
	public String delete(final String name, final String role) {
		String result = null;
		if(role == "admin") {
			List<Topic> topics = topicRepo.delete();
			Predicate<? super Topic> predicate = topic -> topic.getName().equals(name);
			boolean isTopicMatch = topics.stream().anyMatch(predicate);
			result =isTopicMatch?"ОК":"Няма такава тема";
		}else {
			result = "Нямате правомощия за тази операция";
		}
		return result;
	}
	
	
	
	
	
}
