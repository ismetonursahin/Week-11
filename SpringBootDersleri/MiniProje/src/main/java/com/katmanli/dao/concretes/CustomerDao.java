package com.katmanli.dao.concretes;

import com.katmanli.core.HibernateSession;
import com.katmanli.dao.abstracts.ICustomerDao;
import com.katmanli.entity.Customer;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CustomerDao implements ICustomerDao {  // sadece veritabanı işlemleri var.

    private final Session session;

    public CustomerDao() {
        this.session = HibernateSession.getSession();  // hibernate sessiona erişebilmek için
    }

    @Override
    public void save(Customer customer) {
        this.session.beginTransaction();  // veritabanına ekleme işlemi
        this.session.persist(customer);   // veritabanına bu veriyi ekler
        this.session.getTransaction().commit();  //
    }

    @Override
    public Customer findById(int id) {
        return this.session.get(Customer.class, id);
    }

    @Override
    public void update(Customer customer) {
        this.session.beginTransaction();
        this.session.persist(customer);    //   veriyi günceller , veri yoksa insert eder
        this.session.getTransaction().commit();  //
    }

    @Override
    public void delete(Customer customer) {     // burada silme işlemini obje şeklinde yapar , manager kısmında id den siler,.
        this.session.beginTransaction();
        this.session.remove(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public List<Customer> findAll() {
        return this.session.createSelectionQuery("FROM Customer",Customer.class).getResultList();
    }

    @Override
    public Customer findByMail(String mail) {
        SelectionQuery<Customer> query = this.session.createSelectionQuery("FROM Customer WHERE mail = :mail", Customer.class);
        query.setParameter("mail",mail);
        return query.getSingleResultOrNull();
    }
}
