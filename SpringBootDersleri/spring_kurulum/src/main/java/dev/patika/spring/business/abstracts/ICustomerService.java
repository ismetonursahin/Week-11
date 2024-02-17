package dev.patika.spring.business.abstracts;

import dev.patika.spring.entities.Customer;

import java.util.List;

public interface ICustomerService  {
    Customer getById(int id);
    Customer save(Customer customer);
    Customer delete(int id);
    Customer update(Customer customer);

    List<Customer> findAll();
}
