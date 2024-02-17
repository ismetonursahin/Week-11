package com.katmanli.dao.abstracts;

import com.katmanli.entity.Customer;

import java.util.List;

public interface ICustomerDao {

    void save(Customer customer);
    Customer findById(int id);
    void update(Customer customer);
    void delete(Customer customer);
    List<Customer> findAll();
    Customer findByMail(String mail);
}
