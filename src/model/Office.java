package model;

public class Office {
    private String name;
    private String voucher;
    private int cost;
    private String address;
    private String FIO;
    private int phone_number;
    private String tableName = "offices";

   public Office(String name, String voucher, String address, String FIO, int phone_number, int cost){
        this.name = name;
        this.voucher = voucher;
        this.address = address;
        this.FIO = FIO;
        this.phone_number = phone_number;
        this.cost = cost;
    }
    public String getName() {
        return name;
    }

    public String getVoucher() {
        return voucher;
    }

    public int getCost() {
        return cost;
    }

    public String getAddress() {
        return address;
    }

    public String getFIO() {
        return FIO;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
}
