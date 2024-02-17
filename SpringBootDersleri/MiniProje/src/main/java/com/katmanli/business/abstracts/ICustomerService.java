package com.katmanli.business.abstracts;

import com.katmanli.entity.Customer;

import java.util.List;

public interface ICustomerService {
    void save(Customer customer);
    Customer findById(int id);
    void update (Customer customer);
    void deleteById(int id);
    List<Customer> findAll();

    Customer findByMail(String mail);
}
