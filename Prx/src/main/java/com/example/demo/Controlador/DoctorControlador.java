/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Doctor;
import com.example.demo.Servicio.DoctorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Doctor")

public class DoctorControlador {
         @Autowired
    private DoctorServicio doctorServicio;
    @GetMapping("/all")
    public List<Doctor> getDoctor(){
        return doctorServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int doctorId) {
        return doctorServicio.getDoctor(doctorId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor) {
        return doctorServicio.save(doctor);
    }
    
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor doctor) {
        return doctorServicio.update(doctor);
    }
    
    
     @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return doctorServicio.deleteDoctor(id);
    }

}
