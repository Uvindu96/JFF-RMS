package JFF;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;
import java.util.regex.Pattern;

import static sun.plugin.javascript.navig.JSType.URL;

public class AdminlLogin extends NewWindow {

    /*private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/admin";*/

    @FXML
    private TextField adminusname;

    @FXML
    private PasswordField adminuspass;




public void getadminLogin2() throws IOException {

    try{
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection("admin");

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM adminlogin WHERE username ='"+adminusname.getText()+"'AND password ='"+adminuspass.getText()+"';";
        ResultSet resultSet = statement.executeQuery(sql);

        if(resultSet.next()){

           newWindow("AdminPanel.fxml","Login Complete");
        }else {

           newWindow("Home.fxml","Login Error Try Again");
        }

    }catch (SQLException e){
        e.printStackTrace();

    }

}

public void addUser() throws IOException {
   newWindow("AddUser.fxml","JFF Online Store");


}


}
