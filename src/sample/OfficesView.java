package sample;

import javafx.collections.ObservableList;

public class OfficesView {
    private String name;
    private String FIO;
    private String address;
    private int cost;
    private int mobilePhone;
    private String voucher;

    public String getName() {
        return name;
    }

    public String getFIO() {
        return FIO;
    }

    public String getAddress() {
        return address;
    }

    public int getCost() {
        return cost;
    }

    public int getMobilePhone() {
        return mobilePhone;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setMobilePhone(int mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
}
