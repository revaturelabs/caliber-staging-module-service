package com.revature.backend.model;

import javax.persistence.*;

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

    private Associate_Status status;

    public Associate() {
        // TODO Auto-generated constructor stub
    }

    public Associate(int id, String salesforce_id, String email, String first_name, String last_name,
                     Manager manager_id, Batch batch_id, Associate_Status status) {
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
                     Batch batch_id, Associate_Status status) {
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

    public Associate_Status getStatus() {
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

    public void setStatus(Associate_Status status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Associate)) return false;
        final Associate other = (Associate) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$salesforce_id = this.getSalesforce_id();
        final Object other$salesforce_id = other.getSalesforce_id();
        if (this$salesforce_id == null ? other$salesforce_id != null : !this$salesforce_id.equals(other$salesforce_id))
            return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$first_name = this.getFirst_name();
        final Object other$first_name = other.getFirst_name();
        if (this$first_name == null ? other$first_name != null : !this$first_name.equals(other$first_name))
            return false;
        final Object this$last_name = this.getLast_name();
        final Object other$last_name = other.getLast_name();
        if (this$last_name == null ? other$last_name != null : !this$last_name.equals(other$last_name)) return false;
        final Object this$manager_id = this.getManager_id();
        final Object other$manager_id = other.getManager_id();
        if (this$manager_id == null ? other$manager_id != null : !this$manager_id.equals(other$manager_id))
            return false;
        final Object this$batch_id = this.getBatch_id();
        final Object other$batch_id = other.getBatch_id();
        if (this$batch_id == null ? other$batch_id != null : !this$batch_id.equals(other$batch_id)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Associate;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $salesforce_id = this.getSalesforce_id();
        result = result * PRIME + ($salesforce_id == null ? 43 : $salesforce_id.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $first_name = this.getFirst_name();
        result = result * PRIME + ($first_name == null ? 43 : $first_name.hashCode());
        final Object $last_name = this.getLast_name();
        result = result * PRIME + ($last_name == null ? 43 : $last_name.hashCode());
        final Object $manager_id = this.getManager_id();
        result = result * PRIME + ($manager_id == null ? 43 : $manager_id.hashCode());
        final Object $batch_id = this.getBatch_id();
        result = result * PRIME + ($batch_id == null ? 43 : $batch_id.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "Associate(id=" + this.getId() + ", salesforce_id=" + this.getSalesforce_id() + ", email=" + this.getEmail() + ", first_name=" + this.getFirst_name() + ", last_name=" + this.getLast_name() + ", manager_id=" + this.getManager_id() + ", batch_id=" + this.getBatch_id() + ", status=" + this.getStatus() + ")";
    }
}
