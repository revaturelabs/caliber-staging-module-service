package com.revature.backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "analysis_ìtems")
public class AnalysisItem {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "content")
  private String content;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "swot_analysis_id")
  private Swot swot;

  @Column(name = "type")
  private AnalysisType type;

  public AnalysisItem() {
    // TODO Auto-generated constructor stub
  }

  public AnalysisItem(String content, Swot swot, AnalysisType type) {
    super();
    this.content = content;
    this.swot = swot;
    this.type = type;
  }

  public AnalysisItem(int id, String content, Swot swot, AnalysisType type) {
    super();
    this.id = id;
    this.content = content;
    this.swot = swot;
    this.type = type;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AnalysisItem)) return false;
    AnalysisItem that = (AnalysisItem) o;
    return getId() == that.getId()
        && Objects.equals(getContent(), that.getContent())
        && Objects.equals(swot, that.swot)
        && getType() == that.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getContent(), swot, getType());
  }

  public String toString() {
    return "Analysis_Item(id="
        + this.getId()
        + ", content="
        + this.getContent()
        + ", SWOT_analysis_id="
        + this.getSwot_analysis_id()
        + ", type="
        + this.getType()
        + ")";
  }
}
