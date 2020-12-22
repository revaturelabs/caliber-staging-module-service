package com.revature.backend.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "swot_analysis")
public class SWOT_Analysis {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "associate_id")
    private Associate associate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
     Manager created_by;

    @Column(name = "created_on")
    private Timestamp created_on;

    @Column(name = "last_modified")
    private Timestamp last_modified;

    public SWOT_Analysis() {
        // TODO Auto-generated constructor stub
    }

    public SWOT_Analysis(int id, Associate associate_id, Manager created_by, Timestamp created_on,
                         Timestamp last_modified) {
        super();
        this.id = id;
        this.associate = associate_id;
        this.created_by = created_by;
        this.created_on = created_on;
        this.last_modified = last_modified;
    }

    public SWOT_Analysis(Associate associate_id, Manager created_by, Timestamp created_on, Timestamp last_modified) {
        super();
        this.associate = associate_id;
        this.created_by = created_by;
        this.created_on = created_on;
        this.last_modified = last_modified;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SWOT_Analysis;
    }

    public int getId() {
        return this.id;
    }

    public Associate getAssociate() {
        return this.associate;
    }

    public Manager getCreated_by() {
        return this.created_by;
    }

    public Timestamp getCreated_on() {
        return this.created_on;
    }

    public Timestamp getLast_modified() {
        return this.last_modified;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    public void setCreated_by(Manager created_by) {
        this.created_by = created_by;
    }

    public void setCreated_on(Timestamp created_on) {
        this.created_on = created_on;
    }

    public void setLast_modified(Timestamp last_modified) {
        this.last_modified = last_modified;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SWOT_Analysis)) return false;
        final SWOT_Analysis other = (SWOT_Analysis) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$associate = this.getAssociate();
        final Object other$associate = other.getAssociate();
        if (this$associate == null ? other$associate != null : !this$associate.equals(other$associate)) return false;
        final Object this$created_by = this.getCreated_by();
        final Object other$created_by = other.getCreated_by();
        if (this$created_by == null ? other$created_by != null : !this$created_by.equals(other$created_by))
            return false;
        final Object this$created_on = this.getCreated_on();
        final Object other$created_on = other.getCreated_on();
        if (this$created_on == null ? other$created_on != null : !this$created_on.equals(other$created_on))
            return false;
        final Object this$last_modified = this.getLast_modified();
        final Object other$last_modified = other.getLast_modified();
        if (this$last_modified == null ? other$last_modified != null : !this$last_modified.equals(other$last_modified))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $associate = this.getAssociate();
        result = result * PRIME + ($associate == null ? 43 : $associate.hashCode());
        final Object $created_by = this.getCreated_by();
        result = result * PRIME + ($created_by == null ? 43 : $created_by.hashCode());
        final Object $created_on = this.getCreated_on();
        result = result * PRIME + ($created_on == null ? 43 : $created_on.hashCode());
        final Object $last_modified = this.getLast_modified();
        result = result * PRIME + ($last_modified == null ? 43 : $last_modified.hashCode());
        return result;
    }

    public String toString() {
        return "SWOT_Analysis(id=" + this.getId() + ", associate=" + this.getAssociate() + ", created_by=" + this.getCreated_by() + ", created_on=" + this.getCreated_on() + ", last_modified=" + this.getLast_modified() + ")";
    }
}