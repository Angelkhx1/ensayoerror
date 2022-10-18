/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Specialty;
import com.example.demo.Repositorio.SpecialtyRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */
@Service

public class SpecialtyServicio {
    @Autowired
    private SpecialtyRepositorio specialtyRepositorio;

    public List<Specialty> getALL(){ return specialtyRepositorio.getAll();    }
    public Optional<Specialty> getSpecialty(int id){ return specialtyRepositorio.getSpecialty(id); }
    public Specialty save(Specialty p){
        if(p.getId()==null){
            return specialtyRepositorio.save(p);
        }else{
            Optional<Specialty> e = specialtyRepositorio.getSpecialty(p.getId());
            if(e.isPresent()){

                return p;
            }else{
                return specialtyRepositorio.save(p);
            }
        }
    }
    public Specialty update(Specialty specialty){
        if(specialty.getId()!=null){
            Optional<Specialty> e = specialtyRepositorio.getSpecialty(specialty.getId());
            if(e.isPresent()){
                if(specialty.getName()!=null){
                    e.get().setName(specialty.getName());
                }
                if(specialty.getDescritption()!=null){
                    e.get().setDescritption(specialty.getDescritption());
                }
                specialtyRepositorio.save(e.get());
                return e.get();
            }else{
                return specialty;
            }
        }else{
            return specialty;
        }
    }
    public boolean deleteSpecialty(int id){
        boolean flag=false;
        Optional<Specialty>p= specialtyRepositorio.getSpecialty(id);
        if(p.isPresent()){
            specialtyRepositorio.delete(p.get());
            flag=true;
        }
        return flag;

    }
}
