package dao.concerets;

import dao.abstracts.ICustomerDao;
import entities.Customer;

public class CustomerHibernateDao implements ICustomerDao {

    @Override
    public boolean saveCustomer(Customer customer) {
        System.out.println("Hibernate dao katmanı çalıştı");
        System.out.println("Customer veri tabanına eklendi");
        return true;
    }

    @Override
    public Customer getById(int id) {  System.out.println("Hibernate DAo katmanı çalıştı");
        System.out.println("customer veri tabanından çekildi");
        return new Customer();

    }
}
