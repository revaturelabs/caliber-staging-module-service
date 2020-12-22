package com.revature.backend.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "swot_analysis")
public class SWOT {

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

    public SWOT() {
        // TODO Auto-generated constructor stub
    }

    public SWOT(int id, Associate associate_id, Manager created_by, Timestamp created_on,
                Timestamp last_modified) {
        super();
        this.id = id;
        this.associate = associate_id;
        this.created_by = created_by;
        this.created_on = created_on;
        this.last_modified = last_modified;
    }

    public SWOT(Associate associate_id, Manager created_by, Timestamp created_on, Timestamp last_modified) {
        super();
        this.associate = associate_id;
        this.created_by = created_by;
        this.created_on = created_on;
        this.last_modified = last_modified;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SWOT)) return false;
        SWOT swot = (SWOT) o;
        return getId() == swot.getId() && Objects.equals(getAssociate(), swot.getAssociate()) && Objects.equals(getCreated_by(), swot.getCreated_by()) && Objects.equals(getCreated_on(), swot.getCreated_on()) && Objects.equals(getLast_modified(), swot.getLast_modified());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAssociate(), getCreated_by(), getCreated_on(), getLast_modified());
    }

    public String toString() {
        return "SWOT_Analysis(id=" + this.getId() + ", associate=" + this.getAssociate() + ", created_by=" + this.getCreated_by() + ", created_on=" + this.getCreated_on() + ", last_modified=" + this.getLast_modified() + ")";
    }
}