package com.kaif.hospital.repo;

import java.time.LocalDate;
import java.util.List;

import com.kaif.hospital.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PatientRepository extends JpaRepository<Patient,Long>{
    Patient findByName(String name);

    @Query(value = "SELECT * FROM patient", nativeQuery = true)
    List<Patient> getAllPatient();

    //Pageable Wala method
    @Query(value = "SELECT * FROM patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);



    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> getPatientByBirthDate(@Param("birthDate") LocalDate birthDate);


    @Transactional
    @Modifying
    @Query("update Patient p SET p.name = :name where p.id = :id")
    int updatePatientData(@Param("name") String name,@Param("id") Long id);


//    @Query("select new com.kaif.hospital.dto.BloodGroupCountResponseEntity(p.bloodGroup, "+" Count(p)) from Patient p group by p.bloodGroup")
//    List<BloodGroupCountResponseEntity> bloodgroupresponse(@Param("bloodGroup")BloodGroup bloodGroup);

}
