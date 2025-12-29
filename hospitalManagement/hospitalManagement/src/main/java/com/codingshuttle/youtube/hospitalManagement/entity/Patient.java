package com.codingshuttle.youtube.hospitalManagement.entity;
import java.util.*;
import com.codingshuttle.youtube.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString

@Getter
@Setter

@Table(
        name="patient",
        uniqueConstraints = {
                @UniqueConstraint(name="unique_patient_email",columnNames={"email"})

        },

        indexes={@Index(name="idx_patient_birth_date",columnList = "birth_date")}
)
public class Patient {
    @Id

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    private String name;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(unique = true,nullable=false)
    private String email;

    private String gender;


    @CreationTimestamp

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)
    @JoinColumn(name="patient_insurance_id")//owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)
   // @ToString.Exclude
    private List<Appointment>appointments=new ArrayList<>();
}
