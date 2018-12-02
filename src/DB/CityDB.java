package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.City;
import model.Office;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDB {
    public ObservableList<City> getDataFromDB(){
        ObservableList<City> data = FXCollections.observableArrayList();
        DBConnection dbConnection = new DBConnection();
        try {
            ResultSet rs =  dbConnection.getConnection().createStatement().executeQuery("SELECT * FROM cities");
            while (rs.next()) {
                City city = new City(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
              /* Office office = new Office();
               office.setName(rs.getString(1));
               office.setVoucher(rs.getString(2));
               office.setCost(rs.getInt(5));
               off*/
                data.add(city);
            }
        } catch (SQLException ex){
            System.out.print("fuck");
        }
        return data;
    }
    public void write(ObservableList<City> list){
        City city = list.get(list.size()-1);
        System.out.println(city.getId()+","+city.getName());
        String InsertInfo = "INSERT INTO cities (id,name,country)" +"VALUES(?,?,?)";

        DBConnection dbConnection = new DBConnection();
        try{
            PreparedStatement prst = dbConnection.getConnection().prepareStatement(InsertInfo);
            prst.setInt(1,city.getId());
            prst.setString(2,city.getName());
            prst.setString(3,city.getCountry());
            prst.execute();
        }
        catch (SQLException ex){System.out.print("No");}
        //catch (ClassNotFoundException ex){System.out.print("www");}
    }
}
