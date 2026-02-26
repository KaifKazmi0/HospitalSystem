package com.kaif.hospital.service;

import com.kaif.hospital.entity.Appointment;
import com.kaif.hospital.entity.Doctor;
import com.kaif.hospital.entity.Patient;
import com.kaif.hospital.repo.AppointmentRepository;
import com.kaif.hospital.repo.DoctorRepository;
import com.kaif.hospital.repo.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment,Long doctorId,Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId()!=null) throw new IllegalArgumentException("Appointment should not have id");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

       return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reassignAppointmentToNewDoctor(Long appointmentId, Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();

        appointment.setDoctor(doctor);
        return appointment;
    }

}
