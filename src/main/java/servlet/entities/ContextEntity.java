package servlet.entities;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class ContextEntity {
	
	@Id public Long uid;
	@Index public Date updated;
	
	public String type, values;
	@Index public long lat, lng;

	public ContextEntity() {
		this.updated = new Date();
	}
	
	public ContextEntity(String type, String values, long lat, long lng) {
		this();
		this.lat = lat;
		this.lng = lng;
		this.type = type;
		this.values = values;
	}
	
	public void touch() {
		this.updated = new Date();
	}
}
