package com.healthcaremanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Offices")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int officeId;

    @Column(name = "Location")
    private String location;
    @Column(name = "Phone")
    private String phone;
    @OneToOne
    @JoinColumn(name = "DoctorId")
    private Doctor doctor;

    public Office(int officeId, String location, String phone, Doctor doctor) {
        this.officeId = officeId;
        this.location = location;
        this.phone = phone;
        this.doctor = doctor;

    }
    public Office() {}

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
