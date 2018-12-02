package model;

public class Tour {
    private int id;
    private String type;
    private int days;
    private int city_id;
    private int hotel_id;
    private String transport_type;
    private String departure_point;
    public Tour(int id, String type, int days, int city_id,int hotel_id,String transport_type,String departure_point){
        this.city_id = city_id;
        this.days = days;
        this.departure_point = departure_point;
        this.hotel_id = hotel_id;
        this.id = id;
        this.transport_type = transport_type;
        this.type = type;
    }
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getDays() {
        return days;
    }

    public int getCity_id() {
        return city_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public String getTransport_type() {
        return transport_type;
    }

    public String getDeparture_point() {
        return departure_point;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setTransport_type(String transport_type) {
        this.transport_type = transport_type;
    }

    public void setDeparture_point(String departure_point) {
        this.departure_point = departure_point;
    }
}
