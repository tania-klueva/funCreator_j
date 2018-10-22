package ua.com.funCreator.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String phone;
    @Column
    private Date date;
    @Column
    private Time time;
    @Column
    private short amountOfPeople;

    @ManyToOne
    private User user;

    public UserOrder() {
    }

    public UserOrder(String phone, Date date, Time time, short amountOfPeople) {
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
        UserOrder userOrder = (UserOrder) o;
        return id == userOrder.id &&
                amountOfPeople == userOrder.amountOfPeople &&
                Objects.equals(phone, userOrder.phone) &&
                Objects.equals(date, userOrder.date) &&
                Objects.equals(time, userOrder.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, date, time, amountOfPeople);
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", amountOfPeople=" + amountOfPeople +
                '}';
    }
}
