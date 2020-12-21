package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batch")
public class Batch {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "salesforce_id")
	private String salesforce_id;

	@Column(name = "name")
	private String name;

	@Column(name = "skill")
	private String skill;

	@Column(name = "location")
	private String location;

	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int id, String salesforce_id, String name, String skill, String location) {
		super();
		this.id = id;
		this.salesforce_id = salesforce_id;
		this.name = name;
		this.skill = skill;
		this.location = location;
	}

	public Batch(String salesforce_id, String name, String skill, String location) {
		super();
		this.salesforce_id = salesforce_id;
		this.name = name;
		this.skill = skill;
		this.location = location;
	}

	@Override
	public String toString() {
		return "batch [id=" + id + ", salesforce_id=" + salesforce_id + ", name=" + name + ", skill=" + skill
				+ ", location=" + location + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalesforce_id() {
		return salesforce_id;
	}

	public void setSalesforce_id(String salesforce_id) {
		this.salesforce_id = salesforce_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salesforce_id == null) ? 0 : salesforce_id.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salesforce_id == null) {
			if (other.salesforce_id != null)
				return false;
		} else if (!salesforce_id.equals(other.salesforce_id))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		return true;
	}

}
