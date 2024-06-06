package FinalExam.cip.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long Id;
    private String fisrtName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "customer",orphanRemoval = true)
    @JsonIgnore //Bez ova i proektot mi pravese infinite loop vo dodavanje na entitito shto e many to one mapirano
    private List<Order> orders=new ArrayList<>();
    public Customer() {
    }

    public Customer(Long id, String fisrtName, String lastName, String email) {
        Id = id;
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer(String fisrtName, String lastName, String email) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", fisrtName='" + fisrtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer(Long id, String fisrtName, String lastName, String email, List<Order> orders) {
        Id = id;
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.email = email;
        this.orders = orders;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
