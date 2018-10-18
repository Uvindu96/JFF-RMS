package JFF;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminPanel extends NewWindow implements Initializable {

    @FXML
    private TableView<UserDetails> storeTable;

    @FXML
    private TableColumn<UserDetails, String> itemTable;

    @FXML
    private TableColumn<UserDetails, String> codeTable;

    @FXML
    private TableColumn<UserDetails, Integer> priceTable;

    @FXML
    private Button viewStore;

    private ObservableList<UserDetails> data;
    private Connectivity db;


    @FXML
    void loadStore(ActionEvent event) {
        try {
            Connection connection = db.getConnection("items");
            data = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM shopitems");

            while (resultSet.next()) {
                data.add(new UserDetails(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }

        } catch (SQLException ex) {

            System.out.println("Error" + ex);
        }

        itemTable.setCellValueFactory(new PropertyValueFactory<>("item"));
        codeTable.setCellValueFactory(new PropertyValueFactory<>("code"));
        priceTable.setCellValueFactory(new PropertyValueFactory<>("price"));

        storeTable.setItems(null);
        storeTable.setItems(data);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new Connectivity();
    }

    public void showUserInfo() throws IOException {
        newWindow("CustomerDetails.fxml","JFF Online Store");

    }

    public void showUserTransactions() throws IOException {
        newWindow("Transactions.fxml","JFF Online Store");
    }

    public void loadQuarrey() throws IOException {
        newWindow("AdminQuarrey.fxml","JFF Online Store");
    }

}
