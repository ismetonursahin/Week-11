package view;

import business.concerets.CustomerManager;
import dao.concerets.CustomerJDBCDao;
import entities.Customer;

public class App {
    public static void main(String[] args) {
        //Dependency Injection
        CustomerManager customerManager = new CustomerManager(new CustomerJDBCDao());

        // Presentation Layer
        Customer customer = new Customer();
        customer.setMail("asda@mail.com");
        customer.setName("test");

        customerManager.save(customer);

    }
}
