package model;

public class Hotel {
    private int id;
    private String name;
    private int stars;
    private int cities_id;
    public Hotel (int id, String name, int stars, int cities_id){
        this.id = id;
        this.cities_id = cities_id;
        this.name = name;
        this.stars = stars;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getCities_id() {
        return cities_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setCities_id(int cities_id) {
        this.cities_id = cities_id;
    }
}
