package JFF;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectivity {

    public Connection connection;
    public Connection getConnection(String dbname){

        String dbName = dbname;
        String username ="root";
        String password ="";

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }


        return connection;
    }

}
