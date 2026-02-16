package com.kaif.hospital.repo;

import java.time.LocalDate;
import java.util.List;

import com.kaif.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PatientRepository extends JpaRepository<Patient,Long>{
    Patient findByName(String name);

    @Query(value = "SELECT * FROM patient", nativeQuery = true)
    List<Patient> getAllPatient();


    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> getPatientByBirthDate(@Param("birthDate") LocalDate birthDate);

}
