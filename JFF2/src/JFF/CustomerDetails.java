package JFF;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerDetails implements Initializable {

    @FXML
    private TableView<CustomerDB> userInfoTable;

    @FXML
    private TableColumn<CustomerDB, String> userNmaeCol;

    @FXML
    private TableColumn<CustomerDB, String> userPasswordCol;

    private ObservableList<CustomerDB> data;
    private Connectivity db;
    public void initialize(URL location, ResourceBundle resources) {
        db = new Connectivity();
    }


    public void showInfo(){

        try {
            Connection connection = db.getConnection("login");
            data = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
                data.add(new CustomerDB(resultSet.getString(1), resultSet.getString(2)));
            }

        } catch (SQLException ex) {

            System.out.println("Error" + ex);
        }

        userNmaeCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        userPasswordCol.setCellValueFactory(new PropertyValueFactory<>("password"));

        userInfoTable.setItems(data);
    }

}
