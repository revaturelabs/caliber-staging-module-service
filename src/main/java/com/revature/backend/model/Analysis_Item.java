package com.revature.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "analysisItems")
public class Analysis_Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "content")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "swot_analysis_id")
    private SWOT_Analysis SWOT_analysis_id;

    @Column(name = "type")
    private Analysis_Type type;

    public Analysis_Item() {
        // TODO Auto-generated constructor stub
    }

    public Analysis_Item(String content, SWOT_Analysis SWOT_analysis_id, Analysis_Type type) {
        super();
        this.content = content;
        this.SWOT_analysis_id = SWOT_analysis_id;
        this.type = type;
    }

    public Analysis_Item(int id, String content, SWOT_Analysis SWOT_analysis_id, Analysis_Type type) {
        super();
        this.id = id;
        this.content = content;
        this.SWOT_analysis_id = SWOT_analysis_id;
        this.type = type;
    }

    public SWOT_Analysis getSwot_analysis_id() {
        return SWOT_analysis_id;
    }

    public void setSwot_analysis_id(SWOT_Analysis SWOT_analysis_id) {
        this.SWOT_analysis_id = SWOT_analysis_id;
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public Analysis_Type getType() {
        return this.type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(Analysis_Type type) {
        this.type = type;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Analysis_Item)) return false;
        final Analysis_Item other = (Analysis_Item) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$SWOT_analysis_id = this.getSwot_analysis_id();
        final Object other$SWOT_analysis_id = other. getSwot_analysis_id();
        if (this$SWOT_analysis_id == null ? other$SWOT_analysis_id != null : !this$SWOT_analysis_id.equals(other$SWOT_analysis_id))
            return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        return true;
    }



    protected boolean canEqual(final Object other) {
        return other instanceof Analysis_Item;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $SWOT_analysis_id = this.getSwot_analysis_id();
        result = result * PRIME + ($SWOT_analysis_id == null ? 43 : $SWOT_analysis_id.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "Analysis_Item(id=" + this.getId() + ", content=" + this.getContent() + ", SWOT_analysis_id=" + this.getSwot_analysis_id() + ", type=" + this.getType() + ")";
    }
}
