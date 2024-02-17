package com.katmanli.core;

import com.katmanli.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
  public  static Session session = null;

  public static Session getSession(){
      if (session == null){  // null ise oluştur
          SessionFactory factory = new Configuration()
                  .configure("hibernate.cfg.xml")
                  .addAnnotatedClass(Customer.class)
                  .buildSessionFactory();

          session = factory.openSession();
      }
      return session;  // null değilse oluşmuş olanı getir.
  }

}

