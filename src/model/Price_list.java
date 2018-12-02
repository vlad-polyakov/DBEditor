package model;

import java.util.Date;

public class Price_list {
private int id;
private int tour_id;
private Date date;
private int cost;
    public Price_list(int id, int tour_id, Date date, int cost){
        this.id = id;
        this.cost = cost;
        this.tour_id = tour_id;
        this.date = date;
    }
    public int getId() {
        return id;
    }

    public int getTour_id() {
        return tour_id;
    }

    public Date getDate() {
        return date;
    }

    public int getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
