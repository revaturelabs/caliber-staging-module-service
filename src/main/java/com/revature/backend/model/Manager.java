package com.revature.backend.model;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        Manager manager = (Manager) o;
        return getId() == manager.getId() && Objects.equals(getEmail(), manager.getEmail()) && Objects.equals(getFirst_name(), manager.getFirst_name()) && Objects.equals(getLast_name(), manager.getLast_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getFirst_name(), getLast_name());
    }

    public String toString() {
        return "Manager(id=" + this.getId() + ", email=" + this.getEmail() + ", first_name=" + this.getFirst_name() + ", last_name=" + this.getLast_name() + ")";
    }
}
