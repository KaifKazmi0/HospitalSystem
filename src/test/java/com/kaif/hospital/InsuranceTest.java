package com.kaif.hospital;

import com.kaif.hospital.entity.Insurance;
import com.kaif.hospital.entity.Patient;
import com.kaif.hospital.service.InsuranceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;


    @Test
    public void setInsurance(){
        Insurance insurance = Insurance.builder()
                .policyProvider("HDFC_1234")
                .policyNumber("1234")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

       Patient patient =  insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);
    }

}
