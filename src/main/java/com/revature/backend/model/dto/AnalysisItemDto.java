package com.revature.backend.model.dto;

public class AnalysisItemDto {

  // Primary key.
  private int id;

  // Content of the item.
  private String content;

  // The primary key of the Swot object.
  private int swotId;

  // The AnalysisType, converted to a String for easier access.
  private String type;

  public AnalysisItemDto() {
  }

  public AnalysisItemDto(int id, String content, int swotId, String type) {
    super();
    this.id = id;
    this.content = content;
    this.swotId = swotId;
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

  public int getSwotId() {
    return swotId;
  }

  public void setSwotId(int swotId) {
    this.swotId = swotId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "AnalysisItemDto [id=" + id + ", content=" + content + ", swotId=" + swotId + ", type=" + type + "]";
  }

}
