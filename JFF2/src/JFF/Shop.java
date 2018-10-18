package JFF;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Shop extends NewWindow implements Initializable {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/transactions";

    public Shop() {
    }


    public void getPayment() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Payment.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("JFF Online Store");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField getCustomerName;

    @FXML
    private TextField getCustomerMail;

    @FXML
    private TextField getAddress;

    @FXML
    private DatePicker getDate;

    @FXML
    private TextField getTotal;

    @FXML
    private ComboBox<String> itemList;

    @FXML
    private ComboBox<String> codeList;

    @FXML
    private ComboBox<String> amountList;

    @FXML
    private TableView<UserDetails> itemTable;

    @FXML
    private
    TableColumn<UserDetails, String> colomitem;

    @FXML
    private TableColumn<UserDetails, String> colomcode;

    @FXML
    private TableColumn<UserDetails, Integer> colomprice;

    @FXML
    private Button btnLoad;

    @FXML
    private Button getSubmit;


    @FXML
    private Label shopid;

    @FXML
    private Label shopAddress;

    @FXML
    private Label shopiRecipt;

    @FXML
    private Label shopDate;

    @FXML
    private Label shopCustomerName;

    @FXML
    private Label shopCustomerAddress;

    @FXML
    private Label shopItem;

    @FXML
    private Label shopCode;

    @FXML
    private Label shopAmount;

    @FXML
    private Label shopTotal;

    @FXML
    private Label shopRegards;

    @FXML
    private Label shopCustomerNo;

    @FXML
    private Label shopCustomerMail;

    @FXML
    private Label shopInvoice;

    ObservableList<String> getItemList = FXCollections.observableArrayList("Fishing Line", "Sinkers", "Swivels", "Swivels(Medium)", "Swivels(Large)");
    ObservableList<String> getCodeList = FXCollections.observableArrayList("FL", "SI", "SW", "SW2", "SW3");
    ObservableList<String> getAmountList = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");

    private ObservableList<UserDetails> data;
    private Connectivity db;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new Connectivity();
        itemList.setValue("Select");
        itemList.setItems(getItemList);
        codeList.setValue("Select");
        codeList.setItems(getCodeList);
        amountList.setValue("Select");
        amountList.setItems(getAmountList);

    }

    @FXML
    void loadData(ActionEvent event) {


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

        colomitem.setCellValueFactory(new PropertyValueFactory<>("item"));
        colomcode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colomprice.setCellValueFactory(new PropertyValueFactory<>("price"));

        itemTable.setItems(null);
        itemTable.setItems(data);
    }

    public void getQuuarrey() throws IOException {
        newWindow("Quarrey.fxml","JFF Online Store");

    }

    public void submitItems() throws IOException {

        String userName9 = getCustomerName.getText();
        String userMail9 = getCustomerMail.getText();
        String address9 = getAddress.getText();
        String dateset9 = ((TextField) getDate.getEditor()).getText();
        String item9 = itemList.getValue();
        String code9 = codeList.getValue();
        String amount9 = amountList.getValue();
        String total9 = getTotal.getText();

        SetMail newmail = new SetMail();
        newmail.mailConfig(userName9,userMail9,address9,dateset9,item9,code9,amount9,total9);


        if (item9.equals("Fishing Line") && (amount9.equals("1"))) {
            getTotal.setText("Rs.500");
        }
        if (item9.equals("Fishing Line") && (amount9.equals("2"))) {
            getTotal.setText("Rs.1000");
        }
        if (item9.equals("Fishing Line") && (amount9.equals("3"))) {
            getTotal.setText("Rs.1500");
        }
        if (item9.equals("Fishing Line") && (amount9.equals("4"))) {
            getTotal.setText("Rs.2000");
        }
        if (item9.equals("Fishing Line") && (amount9.equals("5"))) {
            getTotal.setText("Rs.2500");
        }
        if (item9.equals("Fishing Line") && (amount9.equals("6"))) {
            getTotal.setText("Rs.3000");
        }
        if (item9.equals("Fishing Line") && (amount9.equals("7"))) {
            getTotal.setText("Rs.3500");
        }
        if (item9.equals("Fishing Line") && (amount9.equals("8"))) {
            getTotal.setText("Rs.4000");
        }
        if (item9.equals("Fishing Line") && (amount9.equals("9"))) {
            getTotal.setText("Rs.4500");
        }
        if (item9.equals("Fishing Line") && (amount9.equals("10"))) {
            getTotal.setText("Rs.5000");
        }

        if (item9.equals("Sinkers") &&(amount9.equals("1"))) {
            getTotal.setText("Rs.1000");
        }
        if (item9.equals("Sinkers") && (amount9.equals("2"))) {
            getTotal.setText("Rs.2000");
        }
        if (item9.equals("Sinkers") && (amount9.equals("3"))) {
            getTotal.setText("Rs.3000");
        }
        if (item9.equals("Sinkers") && (amount9.equals("4"))) {
            getTotal.setText("Rs.4000");
        }
        if (item9.equals("Sinkers") && (amount9.equals("5"))) {
            getTotal.setText("Rs.5000");
        }
        if (item9.equals("Sinkers") && (amount9.equals("6"))) {
            getTotal.setText("Rs.6000");
        }
        if (item9.equals("Sinkers") && (amount9.equals("7"))) {
            getTotal.setText("Rs.7000");
        }
        if (item9.equals("Sinkers") &&(amount9.equals("8"))) {
            getTotal.setText("Rs.8000");
        }
        if (item9.equals("Sinkers") && (amount9.equals("9"))) {
            getTotal.setText("Rs.9000");
        }
        if (item9.equals("Sinkers") && (amount9.equals("10"))) {
            getTotal.setText("Rs.10000");
        }

        if (item9.equals("Swivels") && (amount9.equals("1"))) {
            getTotal.setText("Rs.1500");
        }
        if (item9.equals("Swivels") &&(amount9.equals("2"))) {
            getTotal.setText("Rs.3000");
        }
        if (item9.equals("Swivels") && (amount9.equals("3"))) {
            getTotal.setText("Rs.4500");
        }
        if (item9.equals("Swivels") && (amount9.equals("4"))) {
            getTotal.setText("Rs.6000");
        }
        if (item9.equals("Swivels") &&(amount9.equals("5"))) {
            getTotal.setText("Rs.7500");
        }
        if (item9.equals("Swivels") && (amount9.equals("6"))) {
            getTotal.setText("Rs.9000");
        }
        if (item9.equals("Swivels") && (amount9.equals("7"))) {
            getTotal.setText("Rs.10500");
        }
        if (item9.equals("Swivels") &&(amount9.equals("8"))) {
            getTotal.setText("Rs.12000");
        }
        if (item9.equals("Swivels") && (amount9.equals("9"))) {
            getTotal.setText("Rs.13500");
        }
        if (item9.equals("Swivels") && (amount9.equals("10"))) {
            getTotal.setText("Rs.15000");
        }

        if (item9.equals("Swivels(Medium)") &&(amount9.equals("1"))) {
            getTotal.setText("Rs.1800");
        }
        if (item9.equals("Swivels(Medium)") && (amount9.equals("2"))) {
            getTotal.setText("Rs.3600");
        }
        if (item9.equals("Swivels(Medium)") && (amount9.equals("3"))) {
            getTotal.setText("Rs.5400");
        }
        if (item9.equals("Swivels(Medium)") && (amount9.equals("4"))) {
            getTotal.setText("Rs.7200");
        }
        if (item9.equals("Swivels(Medium)") &&(amount9.equals("5"))) {
            getTotal.setText("Rs.9000");
        }
        if (item9.equals("Swivels(Medium)") && (amount9.equals("6"))) {
            getTotal.setText("Rs.10800");
        }
        if (item9.equals("Swivels(Medium)") && (amount9.equals("7"))) {
            getTotal.setText("Rs.12600");
        }
        if (item9.equals("Swivels(Medium)") && (amount9.equals("8"))) {
            getTotal.setText("Rs.14400");
        }
        if (item9.equals("Swivels(Medium)") && (amount9.equals("9"))) {
            getTotal.setText("Rs.16200");
        }
        if (item9.equals("Swivels(Medium)") && (amount9.equals("10"))) {
            getTotal.setText("Rs.18000");
        }

        if (item9.equals("Swivels(Large)") &&(amount9.equals("1"))) {
            getTotal.setText("Rs.2000");
        }
        if (item9.equals("Swivels(Large)") && (amount9.equals("2"))) {
            getTotal.setText("Rs.4000");
        }
        if (item9.equals("Swivels(Large)") && (amount9.equals("3"))) {
            getTotal.setText("Rs.6000");
        }
        if (item9.equals("Swivels(Large)") && (amount9.equals("4"))) {
            getTotal.setText("Rs.8000");
        }
        if (item9.equals("Swivels(Large)") && (amount9.equals("5"))) {
            getTotal.setText("Rs.10000");
        }
        if (item9.equals("Swivels(Large)") &&(amount9.equals("6"))) {
            getTotal.setText("Rs.12000");
        }
        if (item9.equals("Swivels(Large)") && (amount9.equals("7"))) {
            getTotal.setText("Rs.14000");
        }
        if (item9.equals("Swivels(Large)") && (amount9.equals("8"))) {
            getTotal.setText("Rs.16000");
        }
        if (item9.equals("Swivels(Large)") && (amount9.equals("9"))) {
            getTotal.setText("Rs.18000");
        }
        if (item9.equals("Swivels(Large)") && (amount9.equals("10"))) {
            getTotal.setText("Rs.20000");
        }



        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sqlCode = "INSERT into userselects (name,email,address,date,item,code,amount,total) " +
                    "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sqlCode, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, userName9);
            stm.setString(2, userMail9);
            stm.setString(3, address9);
            stm.setString(4, dateset9);
            stm.setString(5, item9);
            stm.setString(6, code9);
            stm.setString(7, amount9);
            stm.setString(8, getTotal.getText());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("database error");

        }

        shopid.setText("JFF'S Fishing Shack");
        shopInvoice.setText("TAX INVOICE");
        shopAddress.setText("Address:JFF'S Fishing Shack,Trading as: Octopus pty Ltd,shop4,Hillary Boat Harbour,Hillarys,WA,6025/nT:08 9402 2222\nE:Sales@JFF.com");
        shopiRecipt.setText("Recipt:#45678");
        shopDate.setText("Date"+dateset9);
        shopCustomerName.setText("Customer Name:"+userName9);
        shopCustomerAddress.setText("Customer Address:"+address9);
        shopCustomerNo.setText("Customer No:#54689");
        shopCustomerMail.setText("Customer Mail:"+userMail9);
        shopItem.setText("ITEM\n"+item9);
        shopCode.setText("CODE\n"+code9);
        shopAmount.setText("AMOUNT\n"+amount9);
        shopTotal.setText("TOTAL PAID:"+getTotal.getText());
        shopRegards.setText("Thank You For Your Buisness\nJFF's Where the real fishermen shop");


    }

    public void newOrder() throws IOException {

        newWindow("Shop.fxml","JFF Online Store");
    }

   /* public void getReceipt(){

    }*/
}