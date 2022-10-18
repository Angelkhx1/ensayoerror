/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.MessageInterface;
import com.example.demo.Interface.SpecialtyInterface;
import com.example.demo.Modelo.Message;
import com.example.demo.Modelo.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */
@Repository

public class SpecialtyRepositorio {

    @Autowired
    private SpecialtyInterface messageCrudRepository;

    public List<Specialty> getAll() {
        return (List<Specialty>) messageCrudRepository.findAll();
    }

    public Optional<Specialty> getSpecialty(int id) {
        return messageCrudRepository.findById(id);
    }

    public Specialty save(Specialty Specialty) {
        return messageCrudRepository.save(Specialty);
    }
     
    public void delete(Specialty Specialty){
        messageCrudRepository.delete(Specialty);
    }
    
    
   
}
