package dev.patika.spring.dao;

import dev.patika.spring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// Crud Repository , Jpa Repository
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    Customer findByMail(String mail);  // sadece mail adresi ile arama yapar.  Custom methodlar Mail anahtar kelimesine göre kendi bulur

    Customer findByMailAndGender(String mail , Customer.GENDER gender);    // mail adresi ve cinsiyet ile arama yapar.

    List<Customer> findByMailOrGender(String mail , Customer.GENDER gender);    // mail adresi veya cinsiyet ile arama yapar.

    @Query("FROM Customer as c WHERE c.gender = :gender")
    List<Customer> getQueryByGender(@Param("gender") Customer.GENDER gender);

    void delete(int id);
}
