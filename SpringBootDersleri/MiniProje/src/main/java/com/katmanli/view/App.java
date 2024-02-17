package com.katmanli.view;


import com.katmanli.business.concretes.CustomerManager;
import com.katmanli.dao.concretes.CustomerDao;
import com.katmanli.entity.Customer;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(new CustomerDao());
//
//        Customer customer = new Customer();
//        customer.setName("Test Dersleri");
//        customer.setMail("test@mail.com");
//        customer.setGender(Customer.GENDER.MALE);
//        customer.setOnDate(LocalDate.now());
//
//        customerManager.save(customer);


//        Customer customer1 = customerManager.findById(1);         id li veriyi getirmek
//        System.out.println(customer1.toString());

//
//        Customer customer = customerManager.findById(3);
//     //   customer.setMail("test@mail.com");
//        customer.setName("Değişti");
//        customerManager.update(customer);
//
//
//

        List<Customer> customers = customerManager.findAll();
        System.out.println(customers.toString());

    }
}