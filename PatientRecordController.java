package com.example.demo.controller;
import com.example.demo.model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="https://app-dummy123.herokuapp.com")
public class PatientRecordController {

    @Autowired

    PatientRecordRepository patientRecordRepository;

    @GetMapping("/listPatient")

    public List<PatientRecord> getAllPatientRecord() {
        return patientRecordRepository.findAll();
    }


    // Get the patient information
    @GetMapping("/patient/{id}")
    public PatientRecord getpatient(@PathVariable Integer id) {
        return patientRecordRepository.findById(id).get();
    }

    // Delete the patient
    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deletepatient(@PathVariable Integer id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }

    // Add new patient
    @PostMapping("/patient")
    public List<PatientRecord> addpatient(@RequestBody PatientRecord patient) {
        patientRecordRepository.save(patient);
        return patientRecordRepository.findAll();
    }

    // Update the patient information
    @PutMapping("/patient/{id}")
    public List<PatientRecord> updatepatient(@RequestBody PatientRecord patient, @PathVariable Integer id) {
        PatientRecord patientObj = patientRecordRepository.findById(id).get();
        patientObj.setName(patient.getName());
        patientObj.setAddress(patient.getAddress());
        patientRecordRepository.save(patientObj);
        return patientRecordRepository.findAll();

    }
}