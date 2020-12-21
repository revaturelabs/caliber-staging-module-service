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
@Table(name = "analysis_items")
public class Analysis_Item {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "content")
	private String content;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "swot_analysis_id")
	private Swot_Analysis swot_analysis_id;

	@Column(name = "type")
	private Analysis_Type type;

	public Analysis_Item() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Analysis_Item [id=" + id + ", content=" + content + ", swot_analysis_id=" + swot_analysis_id + ", type="
				+ type + "]";
	}

	public Analysis_Item(String content, Swot_Analysis swot_analysis_id, Analysis_Type type) {
		super();
		this.content = content;
		this.swot_analysis_id = swot_analysis_id;
		this.type = type;
	}

	public Analysis_Item(int id, String content, Swot_Analysis swot_analysis_id, Analysis_Type type) {
		super();
		this.id = id;
		this.content = content;
		this.swot_analysis_id = swot_analysis_id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Swot_Analysis getSwot_analysis_id() {
		return swot_analysis_id;
	}

	public void setSwot_analysis_id(Swot_Analysis swot_analysis_id) {
		this.swot_analysis_id = swot_analysis_id;
	}

	public Analysis_Type getType() {
		return type;
	}

	public void setType(Analysis_Type type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + ((swot_analysis_id == null) ? 0 : swot_analysis_id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Analysis_Item other = (Analysis_Item) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (swot_analysis_id == null) {
			if (other.swot_analysis_id != null)
				return false;
		} else if (!swot_analysis_id.equals(other.swot_analysis_id))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
