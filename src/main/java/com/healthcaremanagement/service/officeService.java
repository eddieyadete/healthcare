package com.healthcaremanagement.service;

import com.healthcaremanagement.model.Office;
import com.healthcaremanagement.model.Patient;
import com.healthcaremanagement.repository.OfficeRepositoryImpl;

import java.util.List;

public class officeService {
    private final OfficeRepositoryImpl officeRepository;

    public officeService(OfficeRepositoryImpl officeRepository) {
        this.officeRepository = officeRepository;
    }

    public void createOffice(Office office) {
        officeRepository.createOffice(office);
    }

    public Office getOfficeById(int officeId) {
        return officeRepository.getOfficeById(officeId);
    }

    public List<Office> getAllOffices() {
        return officeRepository.getAllOffices();
    }

    public void updateOffice(Office officeId) {
        officeRepository.updateOffice(officeId);
    }

    public void deleteOffice(int officeId) {
        officeRepository.deleteOffice(officeId);
    }
}
