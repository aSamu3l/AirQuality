package it.samu3l.airquality.model;

public class AirDTO {
    private double umid;
    private double temp;
    private int co2;
    private String room;

    public AirDTO() {
    }

    public AirDTO(double umid, double temp, int co2, String room) {
        this.umid = umid;
        this.temp = temp;
        this.co2 = co2;
        this.room = room;
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
}
