/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.Specialty;
import com.example.demo.Servicio.SpecialtyServicio;
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
@RequestMapping("/api/Specialty")

public class SpecialtyControlador {
         @Autowired
    private SpecialtyServicio specialtyServicio;
    @GetMapping("/all")
    public List<Specialty> getSpecialty(){
        return specialtyServicio.getALL();
    }

    @GetMapping("/{id}")
    public Optional<Specialty> getSpecialty(@PathVariable("id") int specialtyId) {
        return specialtyServicio.getSpecialty(specialtyId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save(@RequestBody Specialty specialty) {
        return specialtyServicio.save(specialty);
    }
    
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty) {
        return specialtyServicio.update(specialty);
    }
    
    
     @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return specialtyServicio.deleteSpecialty(id);
    }

}
