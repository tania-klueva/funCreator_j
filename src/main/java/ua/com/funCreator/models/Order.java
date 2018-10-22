package ua.com.funCreator.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phone;

    private Date date;

    private Time time;

    private short amountOfPeople;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Order(String phone, Date date, Time time, short amountOfPeople) {
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.amountOfPeople = amountOfPeople;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public short getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(short amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                amountOfPeople == order.amountOfPeople &&
                Objects.equals(phone, order.phone) &&
                Objects.equals(date, order.date) &&
                Objects.equals(time, order.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, date, time, amountOfPeople);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", amountOfPeople=" + amountOfPeople +
                '}';
    }
}
