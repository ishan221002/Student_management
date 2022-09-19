package com.example.demo.Controller;

import com.example.demo.Model.PatientRecord;
import com.example.demo.Repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/patient")
    public List<PatientRecord> getAllPatientsRecord() {
        return patientRecordRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public PatientRecord getPatientRecord(@PathVariable long id) {
        return patientRecordRepository.findById(id).get();
    }
    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deletePatientRecord(@PathVariable long id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }

    // Add new student
    @PostMapping("/patient")
    public List<PatientRecord> addPatientRecord(@RequestBody PatientRecord patientRecord) {
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }


    @PutMapping("/patient/{id}")
    public List<PatientRecord> updatePatientRecord (@RequestBody PatientRecord patientRecord, @PathVariable long id) {
        PatientRecord patientObj = patientRecordRepository.findById(id).get();
        patientObj.setName(patientRecord.getName());
        patientObj.setAddress(patientRecord.getAddress());
        patientObj.setAge(patientRecord.getAge());
        patientRecordRepository.save(patientObj);
        return patientRecordRepository.findAll();

    }



}
