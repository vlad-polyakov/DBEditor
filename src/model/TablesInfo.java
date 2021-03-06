package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TablesInfo {
    private ObservableList<Office> officeList;
    private ObservableList<Hotel> hotelList;
    private ObservableList<City> cityList;
    private ObservableList<Price_list> priceList;
    private ObservableList<Tour> tourList;
    private ObservableList<Tour> taskList;
    private ObservableList<Hotel> FiveStarsHotelList;
    private ObservableList<PriceOffice> priceOfficeList;

    public TablesInfo(){
        officeList = FXCollections.observableArrayList();
        hotelList = FXCollections.observableArrayList();
        cityList = FXCollections.observableArrayList();
        priceList = FXCollections.observableArrayList();
        tourList = FXCollections.observableArrayList();
        taskList = FXCollections.observableArrayList();
        FiveStarsHotelList = FXCollections.observableArrayList();
        priceOfficeList = FXCollections.observableArrayList();
    }

    public ObservableList<PriceOffice> getPriceOfficeList() {
        return priceOfficeList;
    }

    public void setPriceOfficeList(ObservableList<PriceOffice> priceOfficeList) {
        this.priceOfficeList = priceOfficeList;
    }

    public ObservableList<Hotel> getFiveStarsHotelList() {
        return FiveStarsHotelList;
    }

    public void setFiveStarsHotelList(ObservableList<Hotel> fiveStarsHotelList) {
        FiveStarsHotelList = fiveStarsHotelList;
    }

    public ObservableList<Tour> getTaskList() {
        return taskList;
    }

    public void setTaskList(ObservableList<Tour> taskList) {
        this.taskList = taskList;
    }

    public void setOfficeList(ObservableList<Office> officeList) {
        this.officeList = officeList;
    }

    public void setHotelList(ObservableList<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public void setCityList(ObservableList<City> cityList) {
        this.cityList = cityList;
    }

    public void setPriceList(ObservableList<Price_list> priceList) {
        this.priceList = priceList;
    }

    public void setTourList(ObservableList<Tour> tourList) {
        this.tourList = tourList;
    }

    public ObservableList<Office> getOfficeList() {
        return officeList;
    }

    public ObservableList<Hotel> getHotelList() {
        return hotelList;
    }

    public ObservableList<City> getCityList() {
        return cityList;
    }

    public ObservableList<Price_list> getPriceList() {
        return priceList;
    }

    public ObservableList<Tour> getTourList() {
        return tourList;
    }
}
