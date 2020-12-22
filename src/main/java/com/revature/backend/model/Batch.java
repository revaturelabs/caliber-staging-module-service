package com.revature.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "salesforce_id")
    private String salesforce_id;

    @Column(name = "name")
    private String name;

    @Column(name = "skill")
    private String skill;

    @Column(name = "location")
    private String location;

    public Batch() {
        // TODO Auto-generated constructor stub
    }

    public Batch(int id, String salesforce_id, String name, String skill, String location) {
        super();
        this.id = id;
        this.salesforce_id = salesforce_id;
        this.name = name;
        this.skill = skill;
        this.location = location;
    }

    public Batch(String salesforce_id, String name, String skill, String location) {
        super();
        this.salesforce_id = salesforce_id;
        this.name = name;
        this.skill = skill;
        this.location = location;
    }

    @Override
    public String toString() {
        return "batch [id=" + id + ", salesforce_id=" + salesforce_id + ", name=" + name + ", skill=" + skill
                + ", location=" + location + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalesforce_id() {
        return salesforce_id;
    }

    public void setSalesforce_id(String salesforce_id) {
        this.salesforce_id = salesforce_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Batch)) return false;
        Batch batch = (Batch) o;
        return getId() == batch.getId() && Objects.equals(getSalesforce_id(), batch.getSalesforce_id()) && Objects.equals(getName(), batch.getName()) && Objects.equals(getSkill(), batch.getSkill()) && Objects.equals(getLocation(), batch.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSalesforce_id(), getName(), getSkill(), getLocation());
    }
}