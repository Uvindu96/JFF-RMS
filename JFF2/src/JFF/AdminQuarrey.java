package JFF;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AdminQuarrey {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/qury";

    @FXML
    private TableView< QuarreySet> quryTable;

    @FXML
    private TableColumn< QuarreySet, String> nameCol;

    @FXML
    private TableColumn< QuarreySet, String> QuaryCol;

    private ObservableList< QuarreySet> data;
    private Connectivity db;

    public void initialize(java.net.URL location, ResourceBundle resources) {
        db = new Connectivity();
    }

    public void getUserQuarrey(){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            data = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM userqury");

            while (resultSet.next()) {
                data.add(new  QuarreySet(resultSet.getString(1), resultSet.getString(2)));
            }

        } catch (SQLException ex) {

            System.out.println("Error" + ex);
        }

        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        QuaryCol.setCellValueFactory(new PropertyValueFactory<>("Quarrey"));


        quryTable.setItems(data);

    }
    }




