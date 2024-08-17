package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private DatePicker dateDob;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("MRS");
        titles.add("Miss");
        cmbTitle.setItems(titles);
    }



    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String title = cmbTitle.getValue();
        LocalDate dob = dateDob.getValue();
        String number = txtNumber.getText();
        Customer customer = new Customer(id,title, name, address,dob,number);
        System.out.println(customer);


        List<Customer> customerList= DBConnection.getInstance().getConnection();

        customerList.add(customer);
    }


    private  boolean isValidPhoneNumber(String number){

        return number!=null && number.length()==10;
    }
    private boolean isValidBirthday(String birthday){
        LocalDate today=LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate birthDate = LocalDate.parse(birthday, formatter);
            return birthDate.isBefore(today);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
