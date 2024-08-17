package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customer;

import javax.swing.*;
import java.util.List;

public class SearchCustomerFormController {

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
    private TextField txtSearch;

    @FXML
    private TextField txtNumber;

    @FXML
    void btnSearch(ActionEvent event) {
        List<Customer> customerList= DBConnection.getInstance().getConnection();
        boolean found=false;
        for (Customer customer:customerList){
            if (txtSearch.getText().equals(customer.getId())){
                found=true;
                txtId.setText(customer.getId());
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtNumber.setText(customer.getNumber());
                cmbTitle.setValue(String.valueOf(customer.getTitle()));
                dateDob.setValue(customer.getDob());

                break;
            }else {
                JOptionPane.showMessageDialog(null,"No Customer Found!!!");
            }
        }
    }

}
