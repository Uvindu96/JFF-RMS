package JFF;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;


public class Controller extends NewWindow {


    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/Login";

    @FXML
    private TextField usname;

    @FXML
    private PasswordField uspass;

    @FXML
    private Button btnlog;

    @FXML
    private Button btnregi;

    public Controller() throws ClassNotFoundException {
    }

    public void setLogin() throws IOException, ClassNotFoundException, SQLException {



        try{
            Connectivity connectivity = new Connectivity();
            Connection connection = connectivity.getConnection("login");

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM user WHERE name ='"+usname.getText()+"'AND password ='"+uspass.getText()+"';";
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()){

                newWindow("login.fxml","Login Complete");
            }else {

                newWindow("Home.fxml","Login Error Try Again");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public void setRegi() throws IOException {
        newWindow("Register.fxml","Register Now");
    }

    public void getAdmin() throws IOException {

        newWindow("AdminLogin.fxml","JFF Admin");
    }

    public void getEmp() throws IOException {
        newWindow("AdminLogin.fxml","JFF Admin");
    }



}
