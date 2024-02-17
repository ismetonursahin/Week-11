package business.concerets;

import business.abstracts.ICustomerService;
import dao.abstracts.ICustomerDao;
import entities.Customer;

public class CustomerManager implements ICustomerService {
    private ICustomerDao customerDao;

    public CustomerManager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public boolean save(Customer customer) {
        // bu customer mail veri tabanında daha önce eklenmiş mi
        System.out.println("business katmanı çalıştı");

        return this.customerDao.saveCustomer(customer);
    }

    public Customer getById(int id) {
        return this.customerDao.getById(id);

    }
}
