package com.healthcaremanagement;

import com.healthcaremanagement.model.Appointment;
import com.healthcaremanagement.model.Doctor;
import com.healthcaremanagement.model.Office;
import com.healthcaremanagement.model.Patient;
import com.healthcaremanagement.repository.AppointmentRepository;
import com.healthcaremanagement.repository.DoctorRepositoryImpl;
import com.healthcaremanagement.repository.OfficeRepositoryImpl;
import com.healthcaremanagement.repository.PatientRepositoryImpl;
import com.healthcaremanagement.service.DoctorService;
import com.healthcaremanagement.service.PatientService;
import com.healthcaremanagement.service.appointmentService;
import com.healthcaremanagement.service.officeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.print.Doc;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
////
//        factory.close();
//        session.close();
//
//        manageDoctors();
//        managePatients();
//        officeService office = new OfficeRepositoryImpl(SessionFactory sessionFactory);
//manageOffice();
        manageOffices();
//        manageDoctors();
    }
    private static void manageOffices(){

//
//
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        OfficeRepositoryImpl officeRepository = new OfficeRepositoryImpl(sessionFactory);
        officeService officeService = new officeService(officeRepository);
        DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl(sessionFactory);
        DoctorService doctorService = new DoctorService(doctorRepository);


        Transaction transaction = session.beginTransaction();
        Scanner scanner = new Scanner(System.in);

        Office newOffice = new Office();
        System.out.print("Enter Office Location: ");
        newOffice.setLocation(scanner.nextLine());
        System.out.print("Enter Office Phone: ");
        newOffice.setPhone(scanner.nextLine());
        Doctor doctor = getDoctorById(doctorService,scanner);
        if (doctor != null) {
            newOffice.setDoctor(doctor);
        } else {
            System.out.println("Doctor not found.");
        }
        officeService.createOffice(newOffice);
        System.out.println("Office created Successfully.");
        scanner.close();
        sessionFactory.close();
    }
    private static Doctor getDoctorById(DoctorService doctorService, Scanner scanner) {
        System.out.print("Enter Doctor ID: ");
        int id = getValidChoice(scanner);
        Doctor doctor = doctorService.getDoctorByID(id);
        if (doctor == null) System.out.println("Doctor not found.");
        return doctor;
    }
    private static int getValidChoice(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return choice;
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Discard invalid input
            }
        }
    }
//        Doctor doctor = new Doctor();
//        doctor.getDoctorId();
//
//
//        Office office = new Office();
////        office.setDoctor(doctor);
//        System.out.println("Enter location:");
//        office.setLocation(scanner.nextLine());
//        System.out.println("Enter phone Number:");
//        office.setPhone(scanner.nextLine());
//        System.out.println("Enter doctor");
//        office.setDoctor(doctor);

//        session.save(office);
//        session.save(doctor);



//        transaction.commit();
//        session.persist(office);


//        officeService.createOffice(office);
//



    private static void manageDoctors() {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl(sessionFactory);
        DoctorService doctorService = new DoctorService(doctorRepository);
        Scanner scanner = new Scanner(System.in);

        Doctor doc = new Doctor();
        System.out.println("Enter First Name:");
        doc.setFirstName(scanner.nextLine());
        System.out.println("Enter Last Name:");
        doc.setLastName(scanner.nextLine());
        System.out.println("Enter Speciality:");
        doc.setSpecialty(scanner.nextLine());
        System.out.println("Enter Email:");
        doc.setEmail(scanner.nextLine());

        doctorService.createDoctor(doc);
        scanner.close();
        sessionFactory.close();
    }
//
    public static void manageAppointments() {
//
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        AppointmentRepository appointmentRepository = new AppointmentRepository(sessionFactory);
        appointmentService appointmentService = new appointmentService(appointmentRepository);
        Scanner scan = new Scanner(System.in);
        Appointment appointment = new Appointment();
        System.out.println("Enter patientId :");
        appointment.setPatientId(scan.nextInt());
        System.out.println("Enter DoctorId:");
        appointment.setDoctorId(scan.nextInt());
        System.out.println("Enter AppointmentDate:");
        appointment.setAppointmentDate(scan.nextInt());
        System.out.println("Enter Notes:");
        appointment.setNotes(scan.nextLine());

        appointmentService.createAppointment(appointment);
        scan.close();
        sessionFactory.close();
        appointmentService.deleteAppointment(1);

    }
    public static void managePatients() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        PatientRepositoryImpl patientRepository = new PatientRepositoryImpl(sessionFactory);

        PatientService patientService = new PatientService(patientRepository);
        Scanner scanner = new Scanner(System.in);


//        Session patientSession = sessionFactory.openSession();
        Patient patient = new Patient();

        System.out.println("firstname");
        patient.setFirstName(scanner.nextLine());
        System.out.println("lastName");
        patient.setLastName(scanner.nextLine());
        System.out.println("dateOfBirth");
       patient.setDateOfBirth(scanner.nextLine());
        System.out.println("email");
        patient.setEmail(scanner.nextLine());
        System.out.println("phoneNumber");
        patient.setPhoneNumber(scanner.nextLine());

        patientService.createPatient(patient);
        sessionFactory.close();
        scanner.close();

}
}






