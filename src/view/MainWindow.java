package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;
import sample.Controller;

import java.util.Date;


public class MainWindow {
    private TableView<Office> officeTab;
    private TableView<City> cityTab;
    private TableView<Hotel> hotelTab;
    private TableView<Price_list> priceListTab;
    private TableView<Tour> tourTab;
    private TableView<Tour> taskTab;
    private TableView<PriceOffice> priceOfficeTab;
    private Controller controller;
    public Stage addStage;
    private TablesInfo tablesInfo = new TablesInfo();
    public VBox createWindow(){
        controller = new Controller(this);
        VBox mainVBox = new VBox(20);
        HBox cityOfficeBox = new HBox();
        HBox priceListAndHotelBox = new HBox();
        Button nextTasksbut = new Button("Next Tasks");
        nextTasksbut.setOnAction(event -> nextTaskStage());
        priceListAndHotelBox.setAlignment(Pos.CENTER);
        cityOfficeBox.setAlignment(Pos.CENTER);
        priceListAndHotelBox.getChildren().addAll(createHotelsTab(),createPriceListsTab());
        cityOfficeBox.getChildren().addAll(createOfficesTab(),createCitiesTab());
        mainVBox.getChildren().addAll(cityOfficeBox,priceListAndHotelBox,createToursTab(),nextTasksbut);
        return mainVBox;
    }
    public VBox createOfficesTab(){
        officeTab = new TableView<>();
        VBox sceneBox = new VBox(5);
        officeTab.setEditable(true);
        HBox buttonsBox = new HBox(5);
        buttonsBox.setAlignment(Pos.CENTER);
        Button getOfficedataBut = new Button("Get data");
        getOfficedataBut.setOnAction(event -> controller.getOfficesFromDataBase(officeTab));
        Button addOfficedataBut = new Button("Add data");
        addOfficedataBut.setOnAction(event -> controller.addInfoIntoTable(officeTab));
        Button deleteOfficedataBut = new Button("Delete");
        deleteOfficedataBut.setOnAction(event->controller.deleteOffice(officeTab));
        buttonsBox.getChildren().addAll(getOfficedataBut,addOfficedataBut,deleteOfficedataBut);
        TableColumn<Office, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellFactory(TextFieldTableCell.<Office> forTableColumn());
        nameCol.setOnEditCommit((TableColumn.CellEditEvent<Office, String> event) -> {
            TablePosition<Office, String> pos = event.getTablePosition();

            String newFullName = event.getNewValue();

            int row = pos.getRow();
            Office office = event.getTableView().getItems().get(row);

            office.setName(newFullName);
        });

        TableColumn<Office, String> voucherCol = new TableColumn<>("Voucher");
        TableColumn<Office, Integer> costCol = new TableColumn<>("Cost");
        TableColumn<Office, String> addressCol = new TableColumn<>("Address");
        TableColumn<Office, String> fioCol = new TableColumn<>("FIO");
        TableColumn<Office, Integer> numberCol = new TableColumn<>("Phone Number");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        voucherCol.setCellValueFactory(new PropertyValueFactory<>("voucher"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        fioCol.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        numberCol.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
        officeTab.getColumns().addAll(nameCol, voucherCol, addressCol, fioCol, numberCol, costCol);
        sceneBox.getChildren().addAll(officeTab,buttonsBox);
        return sceneBox;
    }
    public VBox createCitiesTab(){
        cityTab = new TableView<>();
        VBox sceneBox = new VBox(5);
        HBox buttonsBox = new HBox(5);
        buttonsBox.setAlignment(Pos.CENTER);
        Button getOfficedataBut = new Button("Get data");
        getOfficedataBut.setOnAction(event -> controller.getCitiesfromDB(cityTab));
        Button addOfficedataBut = new Button("Add data");
        addOfficedataBut.setOnAction(event -> controller.addInfoIntoCityTable(cityTab));
        Button deleteOfficedataBut = new Button("Delete");
        deleteOfficedataBut.setOnAction(event -> controller.deleteCity(cityTab));
        buttonsBox.getChildren().addAll(getOfficedataBut,addOfficedataBut,deleteOfficedataBut);
        TableColumn<City, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        TableColumn<City, String> countryCol = new TableColumn<>("Country");
        TableColumn<City, Integer> idCol = new TableColumn<>("Id");


        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        cityTab.getColumns().addAll(idCol,nameCol,countryCol);
        sceneBox.getChildren().addAll(cityTab,buttonsBox);
        return sceneBox;
    }
    public VBox createHotelsTab(){
        hotelTab = new TableView<>();
        VBox sceneBox = new VBox(5);
        HBox buttonsBox = new HBox(5);
        buttonsBox.setAlignment(Pos.CENTER);
        Button getOfficedataBut = new Button("Get data");
        getOfficedataBut.setOnAction(event -> controller.getHotelsfromDB(hotelTab));
        Button addOfficedataBut = new Button("Add data");
        addOfficedataBut.setOnAction(event -> controller.setAddInfoIntoHotel(hotelTab));
        Button deleteOfficedataBut = new Button("Delete");
        Button show5StarsHotelsBut = new Button("5 Stars Hotels");
        show5StarsHotelsBut.setOnAction(event -> controller.show5StarsHotels(hotelTab));
        deleteOfficedataBut.setOnAction(event -> controller.deleteHotel(hotelTab));
        buttonsBox.getChildren().addAll(getOfficedataBut,addOfficedataBut,deleteOfficedataBut,show5StarsHotelsBut);
        TableColumn<Hotel, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        TableColumn<Hotel, Integer> idCol = new TableColumn<>("Id");
        TableColumn<Hotel, Integer> citiesIdCol = new TableColumn<>("Cities Id");
        TableColumn<Hotel, Integer> starsCol = new TableColumn<>("Stars");


        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        citiesIdCol.setCellValueFactory(new PropertyValueFactory<>("cities_id"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        starsCol.setCellValueFactory(new PropertyValueFactory<>("stars"));
        sceneBox.getChildren().addAll(hotelTab,buttonsBox);
        hotelTab.getColumns().addAll(idCol,nameCol,starsCol,citiesIdCol);
        return sceneBox;
    }
    public VBox createPriceListsTab(){
        priceListTab = new TableView<>();
        VBox sceneBox = new VBox(5);
        sceneBox.setAlignment(Pos.CENTER);
        HBox buttonsBox = new HBox(5);
        buttonsBox.setAlignment(Pos.CENTER);
        Button getOfficedataBut = new Button("Get data");
        getOfficedataBut.setOnAction(event -> controller.getPricesfromDB(priceListTab));
        Button addOfficedataBut = new Button("Add data");
        Button deleteOfficedataBut = new Button("Delete");
        buttonsBox.getChildren().addAll(getOfficedataBut,addOfficedataBut,deleteOfficedataBut);
        TableColumn<Price_list, Integer> tourIdCol = new TableColumn<>("Tour Id");
        TableColumn<Price_list, Integer> idCol = new TableColumn<>("Id");
        TableColumn<Price_list, Date> dateCol = new TableColumn<>("Date");
        TableColumn<Price_list, Integer> costCol = new TableColumn<>("Cost");

        tourIdCol.setCellValueFactory(new PropertyValueFactory<>("tour_id"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));

        priceListTab.getColumns().addAll(idCol,tourIdCol,dateCol,costCol);
        sceneBox.getChildren().addAll(priceListTab,buttonsBox);
        return sceneBox;
    }
    public VBox createToursTab(){
        tourTab = new TableView<>();
        priceListTab = new TableView<>();
        VBox sceneBox = new VBox(5);
        HBox buttonsBox = new HBox(5);
        buttonsBox.setAlignment(Pos.CENTER);
        Button getOfficedataBut = new Button("Get data");
        getOfficedataBut.setOnAction(event -> controller.getToursfromDB(tourTab));
        Button addOfficedataBut = new Button("Add data");
        addOfficedataBut.setOnAction(event -> controller.addInfoIntoTour(tourTab));
        Button deleteOfficedataBut = new Button("Delete");
        deleteOfficedataBut.setOnAction(event -> controller.deleteTour(tourTab));
        buttonsBox.getChildren().addAll(getOfficedataBut,addOfficedataBut,deleteOfficedataBut);
        TableColumn<Tour, String> typeCol = new TableColumn<>("Type");
        TableColumn<Tour, Integer> idCol = new TableColumn<>("Id");
        TableColumn<Tour, Integer> daysCol = new TableColumn<>("Days");
        TableColumn<Tour, Integer> cityIdCol = new TableColumn<>("City Id");
        TableColumn<Tour, Integer> hotelIdCol = new TableColumn<>("Hotel Id");
        TableColumn<Tour, String> transportCol = new TableColumn<>("Transport");
        TableColumn<Tour, String> departureCol = new TableColumn<>("Departure Point");
        TableColumn<Tour,String> officeCol = new TableColumn<>("Office Name");
        transportCol.setCellValueFactory(new PropertyValueFactory<>("transport_type"));
        hotelIdCol.setCellValueFactory(new PropertyValueFactory<>("hotel_id"));
        departureCol.setCellValueFactory(new PropertyValueFactory<>("departure_point"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        daysCol.setCellValueFactory(new PropertyValueFactory<>("days"));
        officeCol.setCellValueFactory(new PropertyValueFactory<>("officeName"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        cityIdCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
        sceneBox.getChildren().addAll(tourTab,buttonsBox);
        tourTab.getColumns().addAll(idCol, typeCol,daysCol,transportCol,departureCol,cityIdCol,hotelIdCol,officeCol);
        return sceneBox;
    }

    public void nextTaskStage(){
        VBox root = new VBox(5);
        addStage = new Stage();
        addStage.setTitle("Next Task");
        addStage.setScene(new Scene(root, 700, 700));
        addStage.show();
        root.getChildren().addAll(createToursTaskTab(),createPriceOffice());
    }
    public VBox createToursTaskTab(){
        taskTab = new TableView<>();
        VBox sceneBox = new VBox(5);
        HBox buttonsBox = new HBox(5);
        buttonsBox.setAlignment(Pos.CENTER);
        Label idLabel = new Label("Input ID");
        TextField inputIDField = new TextField();
        Button showInfoBut = new Button("Show Info");
        showInfoBut.setOnAction(event -> controller.showToursInfo(taskTab,inputIDField.getText()));
        buttonsBox.getChildren().addAll(idLabel,inputIDField,showInfoBut);
        TableColumn<Tour, String> typeCol = new TableColumn<>("Type");
        TableColumn<Tour, Integer> daysCol = new TableColumn<>("Days");
        TableColumn<Tour, Integer> cityIdCol = new TableColumn<>("City Id");
        TableColumn<Tour, Integer> hotelIdCol = new TableColumn<>("Hotel Id");
        TableColumn<Tour, String> transportCol = new TableColumn<>("Transport");
        TableColumn<Tour, String> departureCol = new TableColumn<>("Departure Point");
        TableColumn<Tour,String> officeCol = new TableColumn<>("Office Name");
        transportCol.setCellValueFactory(new PropertyValueFactory<>("transport_type"));
        hotelIdCol.setCellValueFactory(new PropertyValueFactory<>("hotel_id"));
        departureCol.setCellValueFactory(new PropertyValueFactory<>("departure_point"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        daysCol.setCellValueFactory(new PropertyValueFactory<>("days"));
        officeCol.setCellValueFactory(new PropertyValueFactory<>("officeName"));
        cityIdCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
        sceneBox.getChildren().addAll(taskTab,buttonsBox);
        taskTab.getColumns().addAll(typeCol,daysCol,transportCol,departureCol,cityIdCol,hotelIdCol,officeCol);
        return sceneBox;
    }
    public VBox createPriceOffice(){
        priceOfficeTab = new TableView<>();
        VBox sceneBox = new VBox(5);
        priceOfficeTab.setEditable(true);
        HBox buttonsBox = new HBox(5);
        buttonsBox.setAlignment(Pos.CENTER);
        Label label = new Label("Input Data (dd/mm/yyyy");
        TextField textField = new TextField();
        Button getOfficedataBut = new Button("Get data");
        getOfficedataBut.setOnAction(event -> controller.showPriceList(priceOfficeTab,textField.getText()));
        buttonsBox.getChildren().addAll(label,textField,getOfficedataBut);
        TableColumn<PriceOffice, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        TableColumn<PriceOffice, Integer> costCol = new TableColumn<>("Cost");
        TableColumn<PriceOffice, String> addressCol = new TableColumn<>("Address");
        TableColumn<PriceOffice, String> typeCol = new TableColumn<>("Type");
        TableColumn<PriceOffice, String> fioCol = new TableColumn<>("FIO");
        TableColumn<PriceOffice, Integer> numberCol = new TableColumn<>("Phone Number");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        fioCol.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        numberCol.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
        priceOfficeTab.getColumns().addAll(nameCol, addressCol, fioCol, numberCol, costCol,typeCol);
        sceneBox.getChildren().addAll(priceOfficeTab,buttonsBox);
        return sceneBox;
    }

}
