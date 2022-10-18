/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.DoctorInterface;
import com.example.demo.Modelo.Doctor;
import com.example.demo.Modelo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */
@Repository

public class DoctorRepositorio {

    @Autowired
    private DoctorInterface doctorCrudRepository;

    public List<Doctor> getAll() {
        return (List<Doctor>) doctorCrudRepository.findAll();
    }

    public Optional<Doctor> getDoctor(int id) {
        return doctorCrudRepository.findById(id);
    }

    public Doctor save(Doctor doctor) { return doctorCrudRepository.save(doctor);
    }
     
    public void delete(Doctor doctor){
        doctorCrudRepository.delete(doctor);
    }
    
    
   
}
