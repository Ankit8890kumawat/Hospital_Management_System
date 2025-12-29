package com.codingshuttle.youtube.hospitalManagement.repository;

import org.springframework.data.domain.Pageable;
import java.util.*;

import com.codingshuttle.youtube.hospitalManagement.dto.BloodGroupResponseEntity;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
   // private ParameterNamesModule parameterNamesModule;

   // PatientRepository(ParameterNamesModule parameterNamesModule) {
     //   this.parameterNamesModule = parameterNamesModule;
    //}

    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    @Query("Select p from Patient p where p.bloodGroup = ?1")
    List<Patient>findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate>:birthDate")
    List<Patient>findByBornAfterDate(@Param("birthDate")LocalDate birthDate);

    @Query("select  new com.codingshuttle.youtube.hospitalManagement.dto.BloodGroupResponseEntity(p.bloodGroup, count(p)) from Patient p group by p.bloodGroup")
   // List<Object[]>countEachBloodGroupType();
    List<BloodGroupResponseEntity>countEachBloodGroupType();


    @Query(value = "select * from patient ",nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Patient p set p.email=:email where p.id=:id")
   int updateEmailWithId(@Param("email") String email, @Param("id") Long id);


//    @Query("select p from Patient  p left join fetch  p.appointments a LEFT JOIN fetch a.doctor")
@Query("select p from Patient  p left join fetch  p.appointments ")
    List<Patient>findAllPatientWithAppointment();
}
