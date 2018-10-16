package ua.com.funCreator.dto;

public class OrderDTO {
    private String phone;

    private String date;

    private String time;

    private short amountOfPeople;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public short getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(short amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", amountOfPeople=" + amountOfPeople +
                '}';
    }
}
