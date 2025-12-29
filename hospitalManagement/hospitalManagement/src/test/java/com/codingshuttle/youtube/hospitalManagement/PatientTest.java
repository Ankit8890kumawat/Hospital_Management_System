package com.codingshuttle.youtube.hospitalManagement;


import java.util.*;

import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.service.patientservice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private patientservice patientservice;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);

    }

    @Test
    public void testTransactionMethods() {
        // patient patient=patientservice.getPatientById(1L);

        //   patient patient=patientRepository.findByName("Aaman kumar");

        //List<patient>patientList=patientRepository.findByBirthDateOrEmail(LocalDate.of(1990,05,10),"pritikumar@gmail.com");

//        for(patient patient:patientList){
//            System.out.println(patient);
//
//        }

//        List<patient>patientList1=patientRepository.findByBornAfterDate(LocalDate.of(1980,01,01));
//
//        for(patient patient:patientList1){
//            System.out.println(patient);
//        }
//
//      //  List<Object[]>bloodGroupList=patientRepository.countEachBloodGroupType();


Page<Patient> patientList=patientRepository.findAllPatients(PageRequest.of(1,2, Sort.by("name")));
        for(Patient patient:patientList){
            System.out.println(patient);
        }

//        int rowUpdate=patientRepository.updateEmailWithId("ankitkumar@gmail.com",1L);
//
//        System.out.println(rowUpdate);
//    }

//         List<BloodGroupResponseEntity>bloodGroupList=patientRepository.countEachBloodGroupType();
//
//         for(BloodGroupResponseEntity bloodGroupResponseEntity:bloodGroupList){
//             System.out.println(bloodGroupResponseEntity);
         }

}
