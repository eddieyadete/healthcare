package com.healthcaremanagement.repository;

import com.healthcaremanagement.model.Office;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.module.Configuration;

public class OfficeRepositoryImpl {
    private SessionFactory sessionFactory;

    public OfficeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    void createOffice(Office office) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(office);
        session.getTransaction().commit();
    }
    void updateOffice(Office office) {
        Session session = sessionFactory.openSession();
        return session.get(Office.class,officeId);
    }
}
