package com.kaif.hospital;

import com.kaif.hospital.entity.Appointment;
import com.kaif.hospital.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,3,1,14, 0))
                .reason("Cancer")
                .build();
       var newAppointment =  appointmentService.createAppointment(appointment,1L,2L);
        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reassignAppointmentToNewDoctor(1L,3L);
        System.out.println(updatedAppointment);

    }

}
