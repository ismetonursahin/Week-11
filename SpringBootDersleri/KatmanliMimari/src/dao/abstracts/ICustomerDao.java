package dao.abstracts;

import entities.Customer;

public interface ICustomerDao {

    boolean saveCustomer(Customer customer);
    Customer getById(int id);
}
