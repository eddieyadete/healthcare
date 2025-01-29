package com.healthcaremanagement.service;

import com.healthcaremanagement.model.Appointment;
import com.healthcaremanagement.model.Doctor;
import com.healthcaremanagement.repository.AppointmentRepository;
import com.healthcaremanagement.repository.DoctorRepositoryImpl;

public class appointmentService {
    private final AppointmentRepository appointmentService;


    public appointmentService(AppointmentRepository appointmentService){
        this.appointmentService = appointmentService;
    }

    public void createAppointment(Appointment appointment){
        appointmentService.createAppointment(appointment);

    }
    public void deleteAppointment(int appointmentId){
        appointmentService.deleteAppointment(appointmentId);
    }
    }

