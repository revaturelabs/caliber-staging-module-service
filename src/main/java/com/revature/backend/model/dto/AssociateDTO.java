package com.revature.backend.model.dto;

import com.revature.backend.model.AssociateStatus;
import com.revature.backend.model.Batch;
import com.revature.backend.model.Manager;

public class AssociateDTO {

	private int id;

	private String salesforceId;

	private String email;

	private String firstName;

	private String lastName;

	private Manager manager;

	private Batch batch;

	private AssociateStatus status;

	public AssociateDTO() {
		// TODO Auto-generated constructor stub
	}

	public AssociateDTO(int id, String salesforceId, String email, String firstName, String lastName, Manager manager,
			Batch batch, AssociateStatus status) {
		super();
		this.id = id;
		this.salesforceId = salesforceId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = manager;
		this.batch = batch;
		this.status = status;
	}

	public AssociateDTO(String salesforceId, String email, String firstName, String lastName, Manager manager,
			Batch batch, AssociateStatus status) {
		super();
		this.salesforceId = salesforceId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = manager;
		this.batch = batch;
		this.status = status;
	}

	@Override
	public String toString() {
		return "AssociateDTO [id=" + id + ", salesforceId=" + salesforceId + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", manager=" + manager + ", batch=" + batch + ", status="
				+ status + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalesforceId() {
		return salesforceId;
	}

	public void setSalesforceId(String salesforceId) {
		this.salesforceId = salesforceId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public AssociateStatus getStatus() {
		return status;
	}

	public void setStatus(AssociateStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batch == null) ? 0 : batch.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((salesforceId == null) ? 0 : salesforceId.hashCode());
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
		AssociateDTO other = (AssociateDTO) obj;
		if (batch == null) {
			if (other.batch != null)
				return false;
		} else if (!batch.equals(other.batch))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (salesforceId == null) {
			if (other.salesforceId != null)
				return false;
		} else if (!salesforceId.equals(other.salesforceId))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}