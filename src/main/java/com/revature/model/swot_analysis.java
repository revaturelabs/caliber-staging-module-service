package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "swot_analysis")
public class swot_analysis {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "associate_id")
	private associates associate_id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by")
	private managers created_by;
	
	@Column(name = "created_on")
	private Timestamp created_on;
	
	@Column(name = "last_modified")
	private Timestamp last_modified;
	
	public swot_analysis() {
		// TODO Auto-generated constructor stub
	}

	public swot_analysis(int id, associates associate_id, managers created_by, Timestamp created_on,
			Timestamp last_modified) {
		super();
		this.id = id;
		this.associate_id = associate_id;
		this.created_by = created_by;
		this.created_on = created_on;
		this.last_modified = last_modified;
	}

	public swot_analysis(associates associate_id, managers created_by, Timestamp created_on, Timestamp last_modified) {
		super();
		this.associate_id = associate_id;
		this.created_by = created_by;
		this.created_on = created_on;
		this.last_modified = last_modified;
	}

	@Override
	public String toString() {
		return "swot_analysis [id=" + id + ", associate_id=" + associate_id + ", created_by=" + created_by
				+ ", created_on=" + created_on + ", last_modified=" + last_modified + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public associates getAssociate_id() {
		return associate_id;
	}

	public void setAssociate_id(associates associate_id) {
		this.associate_id = associate_id;
	}

	public managers getCreated_by() {
		return created_by;
	}

	public void setCreated_by(managers created_by) {
		this.created_by = created_by;
	}

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public Timestamp getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(Timestamp last_modified) {
		this.last_modified = last_modified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associate_id == null) ? 0 : associate_id.hashCode());
		result = prime * result + ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result + ((created_on == null) ? 0 : created_on.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_modified == null) ? 0 : last_modified.hashCode());
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
		swot_analysis other = (swot_analysis) obj;
		if (associate_id == null) {
			if (other.associate_id != null)
				return false;
		} else if (!associate_id.equals(other.associate_id))
			return false;
		if (created_by == null) {
			if (other.created_by != null)
				return false;
		} else if (!created_by.equals(other.created_by))
			return false;
		if (created_on == null) {
			if (other.created_on != null)
				return false;
		} else if (!created_on.equals(other.created_on))
			return false;
		if (id != other.id)
			return false;
		if (last_modified == null) {
			if (other.last_modified != null)
				return false;
		} else if (!last_modified.equals(other.last_modified))
			return false;
		return true;
	}
	
	

}
