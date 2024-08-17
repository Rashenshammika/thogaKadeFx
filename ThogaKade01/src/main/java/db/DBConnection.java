package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection instance;

    private List<Customer> connection;
    private List<Customer> allCustomers;

    private DBConnection(){
        connection = new ArrayList<>();
    }

    public List<Customer> getConnection(){
        return connection;
    }

    public static DBConnection getInstance(){
        return instance == null ? instance = new DBConnection() : instance;
    }

    public void updateCustomer(Customer updatedCustomer) {
        for (int i = 0; i < connection.size(); i++) {
            Customer customer = connection.get(i);
            if (customer.getId().equals(updatedCustomer.getId())) {
                connection.set(i, updatedCustomer);
                break;
            }
        }
    }

    public void deleteCustomer(Customer customerToDelete) {
        connection.removeIf(customer ->
                customer.getId().equals(customerToDelete.getId()) &&
                        customer.getName().equals(customerToDelete.getName()) &&
                        customer.getAddress().equals(customerToDelete.getAddress()) &&
                        customer.getDob().equals(customerToDelete.getDob())
        );
    }

    public List<Customer> getAllCustomers() {
        return allCustomers;
    }
}
