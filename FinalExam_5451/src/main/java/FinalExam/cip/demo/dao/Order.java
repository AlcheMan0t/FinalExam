package FinalExam.cip.demo.dao;

import jakarta.persistence.*;

@Entity
@Table(name= "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long Id;
    private int orderNumber;
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Order(Long id, int orderNumber, String date, Customer customer) {
        Id = id;
        this.orderNumber = orderNumber;
        this.date = date;
        this.customer = customer;
    }

    public Order() {
    }

    public Order(Long id, int orderNumber, String date) {
        Id = id;
        this.orderNumber = orderNumber;
        this.date = date;
    }

    public Order(int orderNumber, String date) {
        this.orderNumber = orderNumber;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", orderNumber=" + orderNumber +
                ", date='" + date + '\'' +
                ", customer=" + customer +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
