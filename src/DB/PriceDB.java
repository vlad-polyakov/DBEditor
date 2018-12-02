package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Price_list;
import model.Tour;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
