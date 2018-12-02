package sample;

import DB.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.*;
import view.AddInfo;
import view.MainWindow;

import java.sql.*;

public class Controller {
    AddInfo addInfo;
    DBConnection dbConnection ;
    private Connection connection;
    private TablesInfo tablesInfo;
    private MainWindow mainWindow;
    public ObservableList<String> list = FXCollections.observableArrayList();
    public Controller(MainWindow mainWindow){
         tablesInfo = new TablesInfo();
        dbConnection = new DBConnection();
        this.mainWindow = mainWindow;
        addInfo = new AddInfo(tablesInfo);
    }
    public void write(){
        String InsertInfo = "INSERT INTO offices (name, voucher, cost, adress, FIO, phone_number)" +"VALUES(?,?,?,?,?,?)";

        try{
            PreparedStatement prst = dbConnection.getConnection().prepareStatement(InsertInfo);
            prst.setString(1,"aqwerty");
            prst.setString(2,"No");
            prst.setInt(3,50000);
            prst.setString(4,"Minsk, Independent st. 1");
            prst.setString(5,"Peter Kawka");
            prst.setInt(6,2507099);
            prst.execute();
        }
        catch (SQLException ex){System.out.print("No");}
        //catch (ClassNotFoundException ex){System.out.print("www");}
    }
    public void getOfficesFromDataBase(TableView<Office> table){
        OfficesDB officesDB = new OfficesDB();
        tablesInfo.getOfficeList().addAll(officesDB.getDataFromDB());
        table.setItems(tablesInfo.getOfficeList());
}
    public void getCitiesfromDB(TableView<City> table){
        CityDB cityDB = new CityDB();
        tablesInfo.getCityList().addAll(cityDB.getDataFromDB());
        table.setItems(tablesInfo.getCityList());
    }
    public void getHotelsfromDB(TableView<Hotel> table){
        HotelDB hotelDB = new HotelDB();
        tablesInfo.getHotelList().addAll(hotelDB.getDataFromDB());
        table.setItems(tablesInfo.getHotelList());
    }
    public void getToursfromDB(TableView<Tour> table){
        TourDB tourDB = new TourDB();
        tablesInfo.getTourList().addAll(tourDB.getDataFromDB());
        table.setItems(tablesInfo.getTourList());
    }
    public void getPricesfromDB(TableView<Price_list> table){
        PriceDB priceDB = new PriceDB();
        tablesInfo.getPriceList().addAll(priceDB.getDataFromDB());
        table.setItems(tablesInfo.getPriceList());
    }
    public void addInfoIntoTable(TableView table){
        addInfo.addOfficeWindow(table);
        //mainWindow.createAddWindow();
    }
    public void addInfoIntoCityTable(TableView table){
        addInfo.addCityInfo(table);
        //mainWindow.createAddWindow();
    }
    public void setAddInfoIntoHotel(TableView table){
        addInfo.addHotelInfo(table);
        //mainWindow.createAddWindow();
    }
    public void addInfoIntoTour(TableView table){
        addInfo.addTourInfo(table);
        //mainWindow.createAddWindow();
    }
}
