/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author USUARIO
 */

@Entity
@Table(name = "doctor")

public class Doctor {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String departmen;
    private String year;
    private Integer description;

 @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="doctor")
    @JsonIgnoreProperties("doctor")
    public List<Message>messages;

   @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "doctor")
   @JsonIgnoreProperties("doctor")
   public List<Reservation>reservations;

    @ManyToOne
    @JoinColumn(name="specialtyId")
    @JsonIgnoreProperties("doctor")
    private Specialty specialty;

    public Integer getId() {        return id;    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmen() {
        return departmen;
    }

    public void setDepartmen(String departmen) {
        this.departmen = departmen;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
