package JFF;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

public class AddUser extends NewWindow {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/admin";

    @FXML
    private TextField newUser;

    @FXML
    private PasswordField newPassword;


    public void addUserBtn() throws IOException {
        String userid = newUser.getText();
        String password =  newPassword.getText();


                    try {
                        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                        String sqlCode = "INSERT into adminlogin (username,password) " +
                                "VALUES (?,?)";
                        PreparedStatement stm = connection.prepareStatement(sqlCode, Statement.RETURN_GENERATED_KEYS);
                        stm.setString(1,userid);
                        stm.setString(2,password);
                        stm.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("database error");
                    }

        newWindow("AdminLogin.fxml","JFF Online Store");

                }
            }






