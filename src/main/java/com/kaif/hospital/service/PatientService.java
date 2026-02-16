package com.kaif.hospital.service;

import com.kaif.hospital.entity.Patient;
import com.kaif.hospital.repo.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();

        System.out.println(p1 == p2);

        p1.setName("yoyo");
        return p1;
    }

    public Patient getPatientByName(String name){
        return patientRepository.findByName(name);
    }


    public List<Patient> getAllPatient(){
        return patientRepository.getAllPatient();
    }

    public List<Patient> getPatientByBirthDate(LocalDate birthDate){
        return patientRepository.getPatientByBirthDate(birthDate);
    }

}
