package uni.pl.fmi.st.service;

import java.util.List;
import java.util.function.Predicate;

import uni.pl.fmi.st.models.Topic;
import uni.pl.fmi.st.repo.ITopicRepo;



public class CreateTopicService {

	final ITopicRepo topicRepo;
	
	public CreateTopicService(ITopicRepo topicRepo)
	{
		this.topicRepo = topicRepo;
	}	
	
	public String create(final String name, final String body) {
		String result = null;
		
		if(name ==null || body ==null) {
			result = "Попълнете входните полета";
		}else{
			List<Topic> topics = topicRepo.findAll();
			Predicate<? super Topic> predicate = topic -> topic.getName().equals(name);
			boolean isTopicMatch = topics.stream().anyMatch(predicate);
			result = isTopicMatch?"Такава тема съществува": "ОК";
		}
		return result;
	}
	
	public String nameLengthTest(final String name) {
		String result = null;
		if((name.length())<=5) {
			result = "Въведеното не е в границите!";		
	}else if ((name.length())>=25) {
		result = "Въведеното не е в границите!";
	}
		else {
		result = "ОК";
	}
		return result;
		}
		
	public String bodyLengthTest(final String body) {
		String result = null;
		if((body.length())<=5 || (body.length())>=25) {
			result = "Въведеното не е в границите!";		
	}else {
		result = "ОК";
	}
		return result;
		}
		
		
}
