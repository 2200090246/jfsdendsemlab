package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        // Configure Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Build SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create Session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert Records
        Client client1 = new Client();
        client1.setName("John Doe");
        client1.setGender("Male");
        client1.setAge(30);
        client1.setLocation("New York");
        client1.setEmail("john.doe@example.com");
        client1.setMobileNumber("1234567890");

        Client client2 = new Client();
        client2.setName("Jane Smith");
        client2.setGender("Female");
        client2.setAge(28);
        client2.setLocation("London");
        client2.setEmail("jane.smith@example.com");
        client2.setMobileNumber("9876543210");

        session.save(client1);
        session.save(client2);

        transaction.commit();

        // Retrieve and Print All Records
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        for (Client client : clients) {
            System.out.println(client);
        }

        session.close();
        sessionFactory.close();
    }
}
