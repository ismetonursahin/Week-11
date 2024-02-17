package dev.patika.spring.business.concretes;

import dev.patika.spring.entities.Customer;
import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.dao.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements ICustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer getById(int id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer delete(int id) {
        this.customerRepo.delete(id);
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        if (customer.getId() == 0){
            throw new RuntimeException("Lütfen id değeri olan bir veri giriniz");
        }
        return this.customerRepo.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
