package com.revature.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "lastname")
    private String last_name;

    public Manager() {
        // TODO Auto-generated constructor stub
    }

    public Manager(int id, String email, String first_name, String last_name) {
        super();
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Manager(String email, String first_name, String last_name) {
        super();
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getId() {
        return this.id;
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

    public void setId(int id) {
        this.id = id;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Manager)) return false;
        final Manager other = (Manager) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
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
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Manager;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $first_name = this.getFirst_name();
        result = result * PRIME + ($first_name == null ? 43 : $first_name.hashCode());
        final Object $last_name = this.getLast_name();
        result = result * PRIME + ($last_name == null ? 43 : $last_name.hashCode());
        return result;
    }

    public String toString() {
        return "Manager(id=" + this.getId() + ", email=" + this.getEmail() + ", first_name=" + this.getFirst_name() + ", last_name=" + this.getLast_name() + ")";
    }
}
