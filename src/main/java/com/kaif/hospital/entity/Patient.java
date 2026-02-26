package com.kaif.hospital.entity;

import com.kaif.hospital.entity.type.BloodGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ToString.Exclude
    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String gender;

    @Column(nullable = false)
    private String name;

    @Column(name="email_id")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group")
    private BloodGroup bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;


    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();

}
