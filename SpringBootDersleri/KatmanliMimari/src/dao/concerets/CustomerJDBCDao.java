package dao.concerets;

import dao.abstracts.ICustomerDao;
import entities.Customer;

public class CustomerJDBCDao implements ICustomerDao {

    @Override
    public boolean saveCustomer(Customer customer) {
        System.out.println("JDBC dao katmanı çalıştı");
        System.out.println("Customer veri tabanına eklendi");
        return true;
    }

    @Override
    public Customer getById(int id) {
        System.out.println("JDBC katmanı çalıştı");
        System.out.println("customer veri tabanından çekildi");
        return new Customer();

    }
}
