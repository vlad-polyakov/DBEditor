package model;

public class PriceOffice {
    private String name;
    private String address;
    private int phone_number;
    private String FIO;
    private String type;
    private int cost;
    public PriceOffice(String name, String address, int phone_number, String FIO, String type, int cost){
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.FIO = FIO;
        this.type = type;
        this.cost = cost;
    }
    public int getCost() {
        return cost;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public String getFIO() {
        return FIO;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public void setType(String type) {
        this.type = type;
    }

}
