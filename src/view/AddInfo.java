package view;

import DB.CityDB;
import DB.HotelDB;
import DB.OfficesDB;
import DB.TourDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class AddInfo {
    private Stage addStage;
    private TextField textFields[];
    private Button addBut;
    private TablesInfo tablesInfo;

    public AddInfo(TablesInfo tablesInfo){
        this.tablesInfo = tablesInfo;
    }
    public void addOfficeWindow(TableView<Office> table){
        List<Label> list = new ArrayList<>();
        VBox root = new VBox(5);
        addStage = new Stage();
        addStage.setTitle("Add info");
        addStage.setScene(new Scene(root, 500, 500));
        addStage.show();
        textFields = new TextField[6];
        HBox hBox[] = new HBox[6];
      Label nameLabel = new Label("Name");
      list.add(nameLabel);
        Label voucherLabel = new Label("Voucher");
        list.add(voucherLabel);
        Label addressLabel = new Label("Address");
        list.add(addressLabel);
        Label fioLabel = new Label("FIO");
        list.add(fioLabel);
        Label numberLabel = new Label("Phone number");
        list.add(numberLabel);
        Label costLabel = new Label("Cost");
        list.add(costLabel);
        for(int i=0;i<6;i++){
            hBox[i] = new HBox(5);
            textFields[i] = new TextField();
            hBox[i].getChildren().addAll(list.get(i),textFields[i]);
            root.getChildren().add(hBox[i]);
        }
        addBut = new Button("Add");
        root.getChildren().addAll(addBut);
        addBut.setOnAction(event->{
            for(int i=0;i<6;i++){
                if (textFields[i].equals("")){
                    errorMessage();
                }
            }
            ObservableList<Office> offices = tablesInfo.getOfficeList();
                    offices.add(new Office(textFields[0].getText(),textFields[1].getText(),textFields[2].getText(),
                            textFields[3].getText(),Integer.parseInt(textFields[4].getText()),Integer.parseInt(textFields[5].getText())));
                    table.setItems(offices);
                    tablesInfo.setOfficeList(offices);
            OfficesDB officesDB = new OfficesDB();
            officesDB.write(offices);

            addStage.close();
        });
    }
    public void addCityInfo(TableView<City> table){
        List<Label> list = new ArrayList<>();
        VBox root = new VBox(5);
        addStage = new Stage();
        addStage.setTitle("Add info");
        addStage.setScene(new Scene(root, 500, 500));
        addStage.show();
        textFields = new TextField[6];
        HBox hBox[] = new HBox[6];
        Label idLabel = new Label("ID");
        list.add(idLabel);
        Label nameLabel = new Label("Name");
        list.add(nameLabel);
        Label countryLabel = new Label("Country");
        list.add(countryLabel);
        for(int i=0;i<3;i++){
            hBox[i] = new HBox(5);
            textFields[i] = new TextField();
            hBox[i].getChildren().addAll(list.get(i),textFields[i]);
            root.getChildren().add(hBox[i]);
        }
        addBut = new Button("Add");
        root.getChildren().addAll(addBut);
        addBut.setOnAction(event->{
            for(int i=0;i<3;i++){
                if (textFields[i].equals("")){
                    errorMessage();
                }
            }
            ObservableList<City> cities = tablesInfo.getCityList();
            cities.add(new City(Integer.parseInt(textFields[0].getText()),textFields[1].getText(),textFields[2].getText()));
            table.setItems(cities);
            tablesInfo.setCityList(cities);
            CityDB cityDB = new CityDB();
            cityDB.write(cities);
            addStage.close();
        });
    }
    public void addHotelInfo(TableView<Hotel> table){
        List<Label> list = new ArrayList<>();
        VBox root = new VBox(5);
        addStage = new Stage();
        addStage.setTitle("Add info");
        addStage.setScene(new Scene(root, 500, 500));
        addStage.show();
        textFields = new TextField[6];
        HBox hBox[] = new HBox[6];
        Label idLabel = new Label("ID");
        list.add(idLabel);
        Label nameLabel = new Label("Name");
        list.add(nameLabel);
        Label starsLabel = new Label("Stars");
        list.add(starsLabel);
        Label citiesIdLabel = new Label("Cities ID");
        list.add(citiesIdLabel);
        for(int i=0;i<4;i++){
            hBox[i] = new HBox(5);
            textFields[i] = new TextField();
            hBox[i].getChildren().addAll(list.get(i),textFields[i]);
            root.getChildren().add(hBox[i]);
        }
        addBut = new Button("Add");
        root.getChildren().addAll(addBut);
        addBut.setOnAction(event->{
            for(int i=0;i<3;i++){
                if (textFields[i].equals("")){
                    errorMessage();
                }
            }
            ObservableList<Hotel> hotels = tablesInfo.getHotelList();
            hotels.add(new Hotel(Integer.parseInt(textFields[0].getText()),textFields[1].getText(),
                    Integer.parseInt(textFields[2].getText()),Integer.parseInt(textFields[3].getText())));
            table.setItems(hotels);
            tablesInfo.setHotelList(hotels);
            HotelDB hotelDB = new HotelDB();
            hotelDB.write(hotels);
            addStage.close();
        });
    }
    public void addTourInfo(TableView<Tour> table){
        List<Label> list = new ArrayList<>();
        VBox root = new VBox(5);
        addStage = new Stage();
        addStage.setTitle("Add info");
        addStage.setScene(new Scene(root, 500, 500));
        addStage.show();
        textFields = new TextField[8];
        HBox hBox[] = new HBox[8];
        Label tour_idLabel = new Label("Tour ID");
        list.add(tour_idLabel);
        Label typeLabel = new Label("Type");
        list.add(typeLabel);
        Label daysLabel = new Label("Duration Days");
        list.add(daysLabel);
        Label city_idLabel = new Label("Cities ID");
        list.add(city_idLabel);
        Label hotel_idLabel = new Label("Hotel ID");
        list.add(hotel_idLabel);
        Label transportLabel = new Label("Transport");
        list.add(transportLabel);
        Label departLabel = new Label("Departure Point");
        list.add(departLabel);
        Label officeLabel = new Label("Office Name");
        list.add(officeLabel);
        for(int i=0;i<8;i++){
            hBox[i] = new HBox(5);
            textFields[i] = new TextField();
            hBox[i].getChildren().addAll(list.get(i),textFields[i]);
            root.getChildren().add(hBox[i]);
        }
        addBut = new Button("Add");
        root.getChildren().addAll(addBut);
        addBut.setOnAction(event->{
            for(int i=0;i<8;i++){
                if (textFields[i].equals("")){
                    errorMessage();
                }
            }
            ObservableList<Tour> tours = tablesInfo.getTourList();
            tours.add(new Tour(Integer.parseInt(textFields[0].getText()),textFields[1].getText(),
                    Integer.parseInt(textFields[2].getText()),Integer.parseInt(textFields[3].getText()),
                    Integer.parseInt(textFields[4].getText()),textFields[5].getText(),textFields[6].getText(),textFields[7].getText()));
            table.setItems(tours);
            tablesInfo.setTourList(tours);
            TourDB tourDB = new TourDB();
            tourDB.write(tours);
            addStage.close();
        });
    }
    public void errorMessage(){
        Alert warn = new Alert(Alert.AlertType.INFORMATION);
        warn.setTitle("Warning!");
        warn.setContentText("There is no word.");
        warn.showAndWait();
        return;
    }
}
