package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customer;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class UpdateCustomerFormController {

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
                cmbTitle.setValue(String.valueOf(customer.getTitle()));
                dateDob.setValue(customer.getDob());
                txtNumber.setText(customer.getNumber());
                break;
            }
        }
        if (!found){
            JOptionPane.showMessageDialog(null, "Customer Not Found!");
        }
    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {
        String  id = txtId.getText();
        String name = txtName.getText();
        String address= txtAddress.getText();
        String number = txtNumber.getText();
        LocalDate date = dateDob.getValue();
        boolean updated = false;
        List<Customer> list=DBConnection.getInstance().getConnection();
        for (Customer customer:list){
            if (txtSearch.getText().equals(customer.getId())) {
                customer.setName(name);
                customer.setAddress(address);
                customer.setDob(date);
                customer.setNumber(number);

                updated = true;
                JOptionPane.showMessageDialog(null, "Customer updated successfully!");
                break;
            }else {
                JOptionPane.showMessageDialog(null, "Customer Not Found!");
            }
        }
    }

}
