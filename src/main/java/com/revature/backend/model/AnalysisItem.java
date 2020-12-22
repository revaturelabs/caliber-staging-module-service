package com.revature.backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "analysisItems")
public class AnalysisItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "content")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "swot_analysis_id")
    private SWOT SWOT__id;

    @Column(name = "type")
    private AnalysisType type;

    public AnalysisItem() {
        // TODO Auto-generated constructor stub
    }

    public AnalysisItem(String content, SWOT SWOT__id, AnalysisType type) {
        super();
        this.content = content;
        this.SWOT__id = SWOT__id;
        this.type = type;
    }

    public AnalysisItem(int id, String content, SWOT SWOT__id, AnalysisType type) {
        super();
        this.id = id;
        this.content = content;
        this.SWOT__id = SWOT__id;
        this.type = type;
    }

    public SWOT getSwot_analysis_id() {
        return SWOT__id;
    }

    public void setSwot_analysis_id(SWOT SWOT__id) {
        this.SWOT__id = SWOT__id;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AnalysisItem)) return false;
        final AnalysisItem other = (AnalysisItem) o;
        if (!other.canEqual(this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (!Objects.equals(this$content, other$content)) return false;
        final Object this$SWOT_analysis_id = this.getSwot_analysis_id();
        final Object other$SWOT_analysis_id = other. getSwot_analysis_id();
        if (!Objects.equals(this$SWOT_analysis_id, other$SWOT_analysis_id))
            return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (!Objects.equals(this$type, other$type)) return false;
        return true;
    }



    protected boolean canEqual(final Object other) {
        return other instanceof AnalysisItem;
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
