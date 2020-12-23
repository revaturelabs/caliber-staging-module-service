package com.revature.backend.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "swot_analysis")
public class Swot {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "associate_id")
    private Associate associate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
     Manager manager;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "last_modified")
    private Timestamp lastModified;

    public Swot() {
        // TODO Auto-generated constructor stub
    }

    public Swot(int id, Associate associate_id, Manager manager, Timestamp createdOn,
                Timestamp lastModified) {
        super();
        this.id = id;
        this.associate = associate_id;
        this.manager = manager;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
    }

    public Swot(Associate associate_id, Manager manager, Timestamp createdOn, Timestamp lastModified) {
        super();
        this.associate = associate_id;
        this.manager = manager;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
    }

    public int getId() {
        return this.id;
    }

    public Associate getAssociate() {
        return this.associate;
    }

    public Manager getManager() {
        return this.manager;
    }

    public Timestamp getCreatedOn() {
        return this.createdOn;
    }

    public Timestamp getLastModified() {
        return this.lastModified;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    public void setManager(Manager created_by) {
        this.manager = created_by;
    }

    public void setCreatedOn(Timestamp created_on) {
        this.createdOn = created_on;
    }

    public void setLastModified(Timestamp last_modified) {
        this.lastModified = last_modified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Swot)) return false;
        Swot swot = (Swot) o;
        return getId() == swot.getId() && Objects.equals(getAssociate(), swot.getAssociate()) && Objects.equals(getManager(), swot.getManager()) && Objects.equals(getCreatedOn(), swot.getCreatedOn()) && Objects.equals(getLastModified(), swot.getLastModified());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAssociate(), getManager(), getCreatedOn(), getLastModified());
    }

    public String toString() {
        return "SWOT_Analysis(id=" + this.getId() + ", associate=" + this.getAssociate() + ", created_by=" + this.getManager() + ", created_on=" + this.getCreatedOn() + ", last_modified=" + this.getLastModified() + ")";
    }
}