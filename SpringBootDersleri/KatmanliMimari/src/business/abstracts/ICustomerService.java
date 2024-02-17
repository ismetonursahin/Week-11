package business.abstracts;

import entities.Customer;

public interface ICustomerService {


    boolean save(Customer customer);

    Customer getById(int id);

}