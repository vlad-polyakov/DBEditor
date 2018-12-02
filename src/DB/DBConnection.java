package DB;

import DB.DBInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection extends DBInfo {
   Connection connection;

        public Connection getConnection()  {
            try {
                String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(connectionString, dbUser, dbPassw);
            }
            catch (SQLException ex){System.out.println("sql");}
            catch (ClassNotFoundException ex){System.out.println("class");}
        return connection;
    }
}
