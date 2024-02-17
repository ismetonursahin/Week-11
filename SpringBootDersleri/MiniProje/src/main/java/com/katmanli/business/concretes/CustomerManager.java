package com.katmanli.business.concretes;

import com.katmanli.business.abstracts.ICustomerService;
import com.katmanli.dao.abstracts.ICustomerDao;
import com.katmanli.entity.Customer;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CustomerManager implements ICustomerService {

    private final ICustomerDao customerDao;

    public CustomerManager(ICustomerDao customerDao) {  // Dependecy Injection
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        Customer checkMailCustomer = this.customerDao.findByMail(customer.getMail());
        if (checkMailCustomer != null) {
            throw new RuntimeException(customer.getMail() + "Bu e-posta adresi daha önce eklenmiş");
        }
        this.customerDao.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.customerDao.findById(id);
    }

    @Override
    public void update(Customer customer) {
        Customer checkMailCustomer = this.customerDao.findByMail(customer.getMail());
        if(checkMailCustomer != null && checkMailCustomer.getId() != customer.getId()){
            throw new RuntimeException(customer.getMail() + " Bu e-posta daha önce eklenmiş");
        }
        this.customerDao.update(customer);
    }

    @Override
    public void deleteById(int id) {   // bir obje istediği için findbyid ile veriyi getirip delete ettirdik
        this.customerDao.delete(this.findById(id));
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDao.findAll();
    }

    @Override
    public Customer findByMail(String mail) {

        return null;
    }
}
