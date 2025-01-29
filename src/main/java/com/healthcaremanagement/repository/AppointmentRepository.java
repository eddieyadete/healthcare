package com.healthcaremanagement.repository;

import com.healthcaremanagement.model.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AppointmentRepository {
    private SessionFactory sessionFactory;


    public AppointmentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createAppointment(Appointment appointment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
        }
    }

    public Appointment getAppointmentById(int appointmentId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(com.healthcaremanagement.model.Appointment.class, appointmentId);
        }
    }


    public void updateAppointment(Appointment appointment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(appointment);
            transaction.commit();
        }
    }

    public void deleteAppointment(int appointmentId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            com.healthcaremanagement.model.Appointment doctor = session.get(Appointment.class, appointmentId);
            if (doctor != null) {
                session.delete(appointmentId);
            }
            transaction.commit();
        }
    }

    public List<Appointment> getAllAppointments() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Appointment", Appointment.class).list();
        }
    }
}
