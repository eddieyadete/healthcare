package com.healthcaremanagement.service;

import com.healthcaremanagement.model.Doctor;
//import com.ticket.DoctorRepository;
import com.healthcaremanagement.repository.DoctorRepositoryImpl;

import java.util.List;

public class DoctorService {

    private final DoctorRepositoryImpl doctorRepository;

    public DoctorService(DoctorRepositoryImpl doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void createDoctor(Doctor doctor){
        doctorRepository.createDoctor(doctor);

    }

    public Doctor getDoctorByID(int doctorId){
        return doctorRepository.getDoctorById(doctorId);

    }

    public void updateDoctor(Doctor doctor){
        doctorRepository.updateDoctor(doctor);

    }

    public void deleteDoctor(int doctorId){
        doctorRepository.deleteDoctor(doctorId);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.getAllDoctor();
    }

}