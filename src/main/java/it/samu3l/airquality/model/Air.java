package it.samu3l.airquality.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
public class Air {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "humidity")
    private double umid;
    @Column(name = "temperature")
    private double temp;
    @Column(name = "co2")
    private int co2;
    @Column(name = "room")
    private String room;
    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

    public Air() {
    }

    public Air(String room, int co2, double temp, double umid) {
        this.room = room;
        this.co2 = co2;
        this.temp = temp;
        this.umid = umid;
        this.timestamp = Timestamp.valueOf(ZonedDateTime.now(ZoneId.of("Europe/Rome")).toLocalDateTime());
    }

    public Air(int id, double umid, double temp, int co2, String room, Timestamp timestamp) {
        this.id = id;
        this.umid = umid;
        this.temp = temp;
        this.co2 = co2;
        this.room = room;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUmid() {
        return umid;
    }

    public void setUmid(double umid) {
        this.umid = umid;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CO2{" +
                "id=" + id +
                ", umid=" + umid +
                ", temp=" + temp +
                ", co2=" + co2 +
                ", room='" + room + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
