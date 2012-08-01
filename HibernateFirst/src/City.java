//package com.loiane.com.model;

import javax.persistence.*;

@Entity
@Table(name="CITY")
public class City {
	
	@Embedded
	//@Column(name="ID_STRING", nullable=false)
	id_string Id_String;
	
	public id_string getId_String() {
		return Id_String;
	}
 
	public void setId_String(id_string id_String) {
		Id_String = id_String;
	}

	@Id
	@Column(name="CITY_NAME", nullable=false)
	private String name;
	
	@Column(name="CITY_STATE", nullable=false)
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(id_string id_String, String name, String state) {
		super();
		Id_String = id_String;
		this.name = name;
		this.state = state;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
