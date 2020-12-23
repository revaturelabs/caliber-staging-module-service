package com.revature.backend.backend.model;

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
    private String salesforceId;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager managerID;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "batch_id")
  private Batch batchID;

    private AssociateStatus status;

    public Associate() {
        // TODO Auto-generated constructor stub
    }

    public Associate(int id, String salesforceId, String email, String firstName, String lastName,
                     Manager managerID, Batch batchID, AssociateStatus status) {
        super();
        this.id = id;
        this.salesforceId = salesforceId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerID = managerID;
        this.batchID = batchID;
        this.status = status;
    }

    public Associate(String salesforceId, String email, String firstName, String lastName, Manager managerID,
                     Batch batchID, AssociateStatus status) {
        super();
        this.salesforceId = salesforceId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerID = managerID;
        this.batchID = batchID;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public String getSalesforceId() {
        return this.salesforceId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Manager getManagerID() {
        return this.managerID;
    }

    public Batch getBatchID() {
        return this.batchID;
    }

    public AssociateStatus getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalesforceId(String salesforce_id) {
        this.salesforceId = salesforce_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public void setManagerID(Manager manager_id) {
        this.managerID = manager_id;
    }

    public void setBatchID(Batch batch_id) {
        this.batchID = batch_id;
    }

    public void setStatus(AssociateStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Associate)) return false;
        Associate associate = (Associate) o;
        return getId() == associate.getId() && Objects.equals(getSalesforceId(), associate.getSalesforceId()) && Objects.equals(getEmail(), associate.getEmail()) && Objects.equals(getFirstName(), associate.getFirstName()) && Objects.equals(getLastName(), associate.getLastName()) && Objects.equals(getManagerID(), associate.getManagerID()) && Objects.equals(getBatchID(), associate.getBatchID()) && getStatus() == associate.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSalesforceId(), getEmail(), getFirstName(), getLastName(), getManagerID(), getBatchID(), getStatus());
    }

    public String toString() {
        return "Associate(id=" + this.getId() + ", salesforce_id=" + this.getSalesforceId() + ", email=" + this.getEmail() + ", first_name=" + this.getFirstName() + ", last_name=" + this.getLastName() + ", manager_id=" + this.getManagerID() + ", batch_id=" + this.getBatchID() + ", status=" + this.getStatus() + ")";
    }
}
