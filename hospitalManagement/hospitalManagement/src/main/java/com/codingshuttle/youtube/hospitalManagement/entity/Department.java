package com.codingshuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

import java.util.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = false,length = 100)
    private String name;

    @OneToOne
    private Doctor headdoctor;

    @ManyToMany
    @JoinTable(
            name="my_dpt_doctors",
            joinColumns = @JoinColumn(name="dpt_id"),
            inverseJoinColumns = @JoinColumn(name="doctor_id")
    )
    private Set<Doctor>doctors =new HashSet<>();
}
