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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Transactions implements Initializable {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/transactions";

    @FXML
    private TableView<TransactionDB> transactionTable;

    @FXML
    private TableColumn<TransactionDB, String> name;

    @FXML
    private TableColumn<TransactionDB, String> email;

    @FXML
    private TableColumn<TransactionDB, String> address;

    @FXML
    private TableColumn<TransactionDB, String> date;

    @FXML
    private TableColumn<TransactionDB, String> item;

    @FXML
    private TableColumn<TransactionDB, String> code;

    @FXML
    private TableColumn<TransactionDB, Integer> amount;

    @FXML
    private TableColumn<TransactionDB, String> totalorder;

    private ObservableList<TransactionDB> data;
    private Connectivity db;
    public void initialize(URL location, ResourceBundle resources) {
        db = new Connectivity();
    }

    public void transactionControl(){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            data = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM userselects");

            while (resultSet.next()) {
                final boolean add = data.add(new TransactionDB(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8)));
            }

        } catch (SQLException ex) {

            System.out.println("Error" + ex);
        }

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        item.setCellValueFactory(new PropertyValueFactory<>("item"));
        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        totalorder.setCellValueFactory(new PropertyValueFactory<>("total"));

        transactionTable.setItems(null);
        transactionTable.setItems(data);
    }
}
