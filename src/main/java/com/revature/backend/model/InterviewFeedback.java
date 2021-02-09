package com.revature.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.api.client.util.DateTime;

@Entity
@Table(name = "interview_feedback")
public class InterviewFeedback {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// IDENTITY was preferred to AUTO.
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER) // removed CascadeType.ALL, this will cause problems with deletion.
	@JoinColumn(name = "associate_id")
	private Associate associate;
	
	@ManyToOne(fetch = FetchType.EAGER) // removed CascadeType.ALL, this will cause problems with deletion.
	@JoinColumn(name = "manager_id")
	private Manager manager;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "date")
	private DateTime date; 

	public InterviewFeedback() {
	}
	
	public InterviewFeedback(Associate associate, Manager manager, String content, DateTime date) {
		super();
		this.associate = associate;
		this.manager = manager;
		this.content = content;
		this.date = date;
	}

	public InterviewFeedback(int id, Associate associate, Manager manager, String content, DateTime date) {
		super();
		this.id = id;
		this.associate = associate;
		this.manager = manager;
		this.content = content;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Associate getAssociate() {
		return associate;
	}

	public void setAssociate(Associate associate) {
		this.associate = associate;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "InterviewFeedback [id=" + id + ", associate=" + associate.getId() + ", manager=" + manager.getId() + ", content="
				+ content + ", date=" + date + "]";
	}

	
	
	
	
}
