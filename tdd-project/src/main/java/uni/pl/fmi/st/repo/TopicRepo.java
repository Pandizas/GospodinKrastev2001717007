package uni.pl.fmi.st.repo;
import java.util.Collections;
import java.util.List;
import uni.pl.fmi.st.models.Topic;



/**
 * 
 * @author pandi
 *
 */
public class TopicRepo implements ITopicRepo {

	
	
	/**
	 * Returns all topics from DB
	 * @return not null({@link List<Topic>}
	 */
	public List<Topic> findAll(){
		return Collections.emptyList();
	}
	
	public List<Topic> delete(){
		return Collections.emptyList();
	}
}
