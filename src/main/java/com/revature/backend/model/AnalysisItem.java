package com.revature.backend.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Objects;

@Entity
@Table(name = "analysis_items")
public class AnalysisItem {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// IDENTITY was preferred to AUTO.
	private int id;

	@Column(name = "content")
	private String content;

	//@JsonIgnore	// Meant to help when trying to create a SWOT, this is a bad solution.
	@JsonBackReference // Meant to help when trying to create a SWOT. - Prevents recursion in retrieve requests, this is the better solution.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "swot_analysis_id")
	private Swot swot;

	@Column(name = "type")
	private AnalysisType type;
	

	@Column(name = "comment")
	private String comment;


	public AnalysisItem() {}

	public AnalysisItem(String content, Swot swot, AnalysisType type, String comment) {
		super();
		this.content = content;
		this.swot = swot;
		this.type = type;
		this.comment = comment;
	}

	public AnalysisItem(int id, String content, Swot swot, AnalysisType type, String comment) {
		super();
		this.id = id;
		this.content = content;
		this.swot = swot;
		this.type = type;
		this.comment = comment;
	}

	public Swot getSwot() {
		return swot;
	}

	public void setSwot(Swot swot) {
		this.swot = swot;
	}

	public int getId() {
		return this.id;
	}

	public String getContent() {
		return this.content;
	}

	public AnalysisType getType() {
		return this.type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setType(AnalysisType type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AnalysisItem))
			return false;
		AnalysisItem that = (AnalysisItem) o;
		return getId() == that.getId() && Objects.equals(getContent(), that.getContent())
				&& Objects.equals(swot, that.swot) && getType() == that.getType() && getComment().equals(that.getComment());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getContent(), swot, getType(), getComment());
	}

	//This does not print 'swot' because it causes a stack overflow error when either the AnalysisItem or Swot toString are called
	//if printing is required, print the id instead of the whole object or otherwise edit the swot toString to prevent recursive printing
	public String toString() {
		return "Analysis_Item(id=" + this.getId() + ", content=" + this.getContent() + ", type=" + this.getType() + "," + this.getComment() + ")";
	}
}
