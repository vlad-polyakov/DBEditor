package sample;

import DB.*;
import javafx.scene.control.TableView;
import model.*;
import view.AddInfo;
import view.MainWindow;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    AddInfo addInfo;
    DBConnection dbConnection ;
    private TablesInfo tablesInfo;
    private MainWindow mainWindow;
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
        tablesInfo.getOfficeList().remove(0,tablesInfo.getOfficeList().size());
        tablesInfo.getOfficeList().addAll(officesDB.getDataFromDB());
        table.setItems(tablesInfo.getOfficeList());
}
    public void getCitiesfromDB(TableView<City> table){
        CityDB cityDB = new CityDB();
        tablesInfo.getCityList().remove(0,tablesInfo.getCityList().size());
        tablesInfo.getCityList().addAll(cityDB.getDataFromDB());
        table.setItems(tablesInfo.getCityList());
    }
    public void getHotelsfromDB(TableView<Hotel> table){
        HotelDB hotelDB = new HotelDB();
        tablesInfo.getHotelList().remove(0,tablesInfo.getHotelList().size());
        tablesInfo.getHotelList().addAll(hotelDB.getDataFromDB());
        table.setItems(tablesInfo.getHotelList());
    }
    public void getToursfromDB(TableView<Tour> table){
        TourDB tourDB = new TourDB();
        tablesInfo.getTourList().remove(0,tablesInfo.getTourList().size());
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
    public void deleteOffice(TableView<Office> table){
        int row = table.getSelectionModel().getSelectedIndex();
        OfficesDB officesDB = new OfficesDB();
        officesDB.delete(table.getItems().get(row));
        table.getItems().remove(row);
    }
    public void deleteCity(TableView<City> table){
        int row = table.getSelectionModel().getSelectedIndex();
        CityDB cityDB = new CityDB();
        cityDB.delete(table.getItems().get(row));
        table.getItems().remove(row);
    }
    public void deleteHotel(TableView<Hotel> table){
        int row = table.getSelectionModel().getSelectedIndex();
        HotelDB hotelDB = new HotelDB();
        hotelDB.delete(table.getItems().get(row));
        table.getItems().remove(row);
    }
    public void deleteTour(TableView<Tour> table){
        int row = table.getSelectionModel().getSelectedIndex();
        TourDB tourDB = new TourDB();
        tourDB.delete(table.getItems().get(row));
        table.getItems().remove(row);
    }
    public void showToursInfo(TableView table, String idStr){
        int id = Integer.parseInt(idStr);
        TourDB tourDB = new TourDB();
        tablesInfo.getTaskList().remove(0,tablesInfo.getTaskList().size());
        tablesInfo.getTaskList().addAll(tourDB.getInfo(id));
        table.setItems(tablesInfo.getTaskList());
    }
    public void show5StarsHotels(TableView table){
        HotelDB hotelDB = new HotelDB();
        tablesInfo.getFiveStarsHotelList().remove(0,tablesInfo.getFiveStarsHotelList().size());
        tablesInfo.getFiveStarsHotelList().addAll(hotelDB.showInfo());
        table.setItems(tablesInfo.getFiveStarsHotelList());
    }
    public void showPriceList(TableView tableView, String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = dateStr;
        LocalDate localDate = LocalDate.parse(date, formatter);
        PriceDB priceDB = new PriceDB();
        tablesInfo.getPriceOfficeList().remove(0,tablesInfo.getPriceOfficeList().size());
        tablesInfo.getPriceOfficeList().addAll(priceDB.getData(localDate));
        tableView.setItems( tablesInfo.getPriceOfficeList());
    }
}
