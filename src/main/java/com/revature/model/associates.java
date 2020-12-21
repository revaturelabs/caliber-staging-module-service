package com.revature.model;

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
@Table(name = "associates")
public class associates {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="salesforce_id")
	private String salesforce_id;

	@Column(name="email")
	private String email;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="lastname")
	private String last_name;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	private managers manager_id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "batch_id")
	private batch batch_id;
	
	private String status;

	public associates() {
		// TODO Auto-generated constructor stub
	}
	
	public associates(int id, String salesforce_id, String email, String first_name, String last_name,
			managers manager_id, batch batch_id, String status) {
		super();
		this.id = id;
		this.salesforce_id = salesforce_id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.manager_id = manager_id;
		this.batch_id = batch_id;
		this.status = status;
	}

	public associates(String salesforce_id, String email, String first_name, String last_name, managers manager_id,
			batch batch_id, String status) {
		super();
		this.salesforce_id = salesforce_id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.manager_id = manager_id;
		this.batch_id = batch_id;
		this.status = status;
	}

	@Override
	public String toString() {
		return "associates [id=" + id + ", salesforce_id=" + salesforce_id + ", email=" + email + ", first_name="
				+ first_name + ", last_name=" + last_name + ", manager_id=" + manager_id + ", batch_id=" + batch_id
				+ ", status=" + status + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public managers getManager_id() {
		return manager_id;
	}

	public void setManager_id(managers manager_id) {
		this.manager_id = manager_id;
	}

	public batch getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(batch batch_id) {
		this.batch_id = batch_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batch_id == null) ? 0 : batch_id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((manager_id == null) ? 0 : manager_id.hashCode());
		result = prime * result + ((salesforce_id == null) ? 0 : salesforce_id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		associates other = (associates) obj;
		if (batch_id == null) {
			if (other.batch_id != null)
				return false;
		} else if (!batch_id.equals(other.batch_id))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (manager_id == null) {
			if (other.manager_id != null)
				return false;
		} else if (!manager_id.equals(other.manager_id))
			return false;
		if (salesforce_id == null) {
			if (other.salesforce_id != null)
				return false;
		} else if (!salesforce_id.equals(other.salesforce_id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	

	
}
