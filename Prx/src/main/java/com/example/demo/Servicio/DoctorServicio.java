/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.Doctor;
import com.example.demo.Repositorio.DoctorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */
@Service

public class DoctorServicio {
     @Autowired
    private DoctorRepositorio doctorRepositorio;

    public List<Doctor> getAll(){
        return doctorRepositorio.getAll();
    }

    public Optional<Doctor> getDoctor(int doctorId) {
        return doctorRepositorio.getDoctor(doctorId);
    }

    public Doctor save(Doctor doctor){
        if(doctor.getId()==null){
            return doctorRepositorio.save(doctor);
        }else{
            Optional<Doctor> e= doctorRepositorio.getDoctor(doctor.getId());
            if(e.isPresent()){
                return doctorRepositorio.save(doctor);
            }else{
                return doctor;
            }
        }
    } 
     public Doctor update(Doctor doctor){
        if(doctor.getId()!=null){
            Optional<Doctor> e= doctorRepositorio.getDoctor(doctor.getId());
            if(e.isPresent()){
                if(doctor.getName()!=null){
                    e.get().setName(doctor.getName());
                }
                if(doctor.getDepartmen()!=null){
                    e.get().setDescription(doctor.getDescription());
                }
                if(doctor.getYear()!=null){
                    e.get().setYear(doctor.getYear());
                }
                if(doctor.getDescription()!=null){
                    e.get().setDescription(doctor.getDescription());
                }

                doctorRepositorio.save(e.get());
                return e.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }
    
    
     public boolean deleteDoctor (int id){
        Boolean d = getDoctor(id).map(doctor -> {
            doctorRepositorio.delete(doctor);
            return true;
        }).orElse(false);
        return d;
    }
   
}
