package uni.pl.fmi.st.repo;
import java.util.List;

import uni.pl.fmi.st.models.Topic;

public interface ITopicRepo {
	public List<Topic> findAll();
	public List<Topic> delete();
}
