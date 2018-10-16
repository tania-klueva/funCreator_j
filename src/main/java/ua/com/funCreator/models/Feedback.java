package ua.com.funCreator.models;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
        Feedback feedback = (Feedback) o;
        return id == feedback.id &&
                Objects.equals(body, feedback.body) &&
                Objects.equals(dateTime, feedback.dateTime) &&
                Objects.equals(user, feedback.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, dateTime, user);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
