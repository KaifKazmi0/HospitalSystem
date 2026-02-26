package com.kaif.hospital.service;

import com.kaif.hospital.entity.Insurance;
import com.kaif.hospital.entity.Patient;
import com.kaif.hospital.repo.InsuranceRepository;
import com.kaif.hospital.repo.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient Not Found with id "+patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient);
        return patient;
    }
}
