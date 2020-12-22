package com.revature.backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "associate")
public class Associate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "salesforce_id")
    private String salesforce_id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "lastname")
    private String last_name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager manager_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id")
    private Batch batch_id;

    private AssociateStatus status;

    public Associate() {
        // TODO Auto-generated constructor stub
    }

    public Associate(int id, String salesforce_id, String email, String first_name, String last_name,
                     Manager manager_id, Batch batch_id, AssociateStatus status) {
        super();
        this.id = id;
        this.salesforce_id = salesforce_id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.manager_id = manager_id;
        this.batch_id = batch_id;
        this.status = status;
    }

    public Associate(String salesforce_id, String email, String first_name, String last_name, Manager manager_id,
                     Batch batch_id, AssociateStatus status) {
        super();
        this.salesforce_id = salesforce_id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.manager_id = manager_id;
        this.batch_id = batch_id;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public String getSalesforce_id() {
        return this.salesforce_id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public Manager getManager_id() {
        return this.manager_id;
    }

    public Batch getBatch_id() {
        return this.batch_id;
    }

    public AssociateStatus getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalesforce_id(String salesforce_id) {
        this.salesforce_id = salesforce_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setManager_id(Manager manager_id) {
        this.manager_id = manager_id;
    }

    public void setBatch_id(Batch batch_id) {
        this.batch_id = batch_id;
    }

    public void setStatus(AssociateStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Associate)) return false;
        Associate associate = (Associate) o;
        return getId() == associate.getId() && Objects.equals(getSalesforce_id(), associate.getSalesforce_id()) && Objects.equals(getEmail(), associate.getEmail()) && Objects.equals(getFirst_name(), associate.getFirst_name()) && Objects.equals(getLast_name(), associate.getLast_name()) && Objects.equals(getManager_id(), associate.getManager_id()) && Objects.equals(getBatch_id(), associate.getBatch_id()) && getStatus() == associate.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSalesforce_id(), getEmail(), getFirst_name(), getLast_name(), getManager_id(), getBatch_id(), getStatus());
    }

    public String toString() {
        return "Associate(id=" + this.getId() + ", salesforce_id=" + this.getSalesforce_id() + ", email=" + this.getEmail() + ", first_name=" + this.getFirst_name() + ", last_name=" + this.getLast_name() + ", manager_id=" + this.getManager_id() + ", batch_id=" + this.getBatch_id() + ", status=" + this.getStatus() + ")";
    }
}
