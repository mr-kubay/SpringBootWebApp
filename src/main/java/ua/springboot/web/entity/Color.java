package ua.springboot.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color extends BaseEntity{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color() {
	}
	
	
}
