/**
 * 
 */
package uni.pl.fmi.st.models;

import java.util.List;

/**
 * Main Topic data model. Provides main topic information
 *
 */
public class Topic {
	
	private String name;
	private String body;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

}
