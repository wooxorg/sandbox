package org.woox.photoservice.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO read http://docs.mongodb.org/manual/reference/database-references/ http://static.springsource.org/spring-data/data-document/docs/current/reference/html/

@XmlRootElement
@Document(collection="photos")
public class Photo {

	@Id
	private String id;
	
	@Indexed
	private String title;
	
	private byte[] data;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
