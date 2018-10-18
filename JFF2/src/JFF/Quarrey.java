package JFF;

import java.io.IOException;
import java.sql.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Quarrey extends NewWindow {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/qury";

    @FXML
    private TextField qname;

    @FXML
    private TextField qurydetail;

    public void getUserQuarrey() throws IOException {




        newWindow("Shop.fxml","JFF Online Store");

        String name = qname.getText();
        String detail = qurydetail.getText();

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sqlCode = "INSERT into userqury (name,userquarrey) " +
                    "VALUES (?,?)";
            PreparedStatement stm = connection.prepareStatement(sqlCode, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, name);
            stm.setString(2, detail);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("database error");

        }


    }


}
