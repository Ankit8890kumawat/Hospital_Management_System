package com.codingshuttle.youtube.hospitalManagement.service;

import com.codingshuttle.youtube.hospitalManagement.entity.Insurance;
import com.codingshuttle.youtube.hospitalManagement.repository.InsuranceRepository;
import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor
public class insuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient=patientRepository.findById(patientId)
                .orElseThrow(()->new EntityNotFoundException("patient Not found with id: "+patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient);//bidirectional consistency maintain

        return patient;
    }

    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId){
        Patient patient=patientRepository.findById(patientId)
                .orElseThrow(()->new EntityNotFoundException("patient not found with id:"+patientId));

        patient.setInsurance(null);
        return patient;
    }
}
