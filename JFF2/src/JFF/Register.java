package JFF;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.regex.Pattern;

public class Register extends NewWindow {


    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/Login";

    @FXML
    private TextField regiuser;

    @FXML
    private PasswordField regipass;

    @FXML
    private Button btnRegi;

    public void userRegi() throws IOException {

        newWindow("Home.fxml","Registration Complete");

        String userid = regiuser.getText();
        String password = regipass.getText();

        Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");
        if(userid.length()>= 8){
            if (specailCharPatten.matcher(password ).find()) {
                if (digitCasePatten.matcher(password ).find()) {
                    try {
                        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                        String sqlCode = "INSERT into user (name,password) " +
                                "VALUES (?,?)";
                        PreparedStatement stm = connection.prepareStatement(sqlCode, Statement.RETURN_GENERATED_KEYS);
                        stm.setString(1,userid);
                        stm.setString(2,password);
                        stm.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("database error");
                    }

                }
            }

            else{
                System.out.println("Registration Error");
            }


        }
        String news = "Welcome to JFF's Fishing Store.You can get the perfect fishing items from us....And we have the " +
                "perfect collection for your needs.....We have special offers this weekend come and vist our shop";

        SetMail newMail = new SetMail();
        newMail.mailConfig(news );




    }

}
