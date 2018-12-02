package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.PriceOffice;
import model.Price_list;
import model.Tour;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PriceDB {
    public ObservableList<Price_list> getDataFromDB(){
        ObservableList<Price_list> data = FXCollections.observableArrayList();
        DBConnection dbConnection = new DBConnection();
        try {
            ResultSet rs =  dbConnection.getConnection().createStatement().executeQuery("SELECT * FROM price_lists");
            while (rs.next()) {
                Price_list priceList = new Price_list(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getInt(4)
                );
              /* Office office = new Office();
               office.setName(rs.getString(1));
               office.setVoucher(rs.getString(2));
               office.setCost(rs.getInt(5));
               off*/
                data.add(priceList);
            }
        } catch (SQLException ex){
            System.out.print("fuck");
        }
        return data;
    }
    public ObservableList<PriceOffice> getData(LocalDate date){
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        ObservableList<PriceOffice> data = FXCollections.observableArrayList();
        DBConnection dbConnection = new DBConnection();
        String selectStr = "select o.name, o.adress, o.phone_number, o.FIO, t.type,pr.cost\n" +
                "from price_lists pr\n" +
                "inner join tours t on pr.tour_id =t.tour_id\n" +
                "inner join offices o on t.office_name = o.name\n" +
                "where date = ?";
        try {
            PreparedStatement ps =  dbConnection.getConnection().prepareStatement(
                    "select o.name, o.adress, o.phone_number, o.FIO, t.type,pr.cost " +
                    "from price_lists pr " +
                    "inner join tours t on pr.tour_id =t.tour_id " +
                    "inner join offices o on t.office_name = o.name " +
                    "where date = '" + sqlDate +"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PriceOffice priceList = new PriceOffice(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
              /* Office office = new Office();
               office.setName(rs.getString(1));
               office.setVoucher(rs.getString(2));
               office.setCost(rs.getInt(5));
               off*/
                data.add(priceList);
            }
        } catch (SQLException ex){
            System.out.print("fuck");
        }
        return data;
    }
}
