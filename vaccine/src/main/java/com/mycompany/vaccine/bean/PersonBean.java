/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vaccine.bean;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class PersonBean {
    
    private Integer     personId;
    private String      firsName;
    private String      lastName;
    private String      personAddres;
    private LocalDate   birthDate;
    private String      vacccinTipe;
    private Integer     vacccinNo;
    private String      vaccinCity;
    private Date        appointmentDate;
    private Time        appointmentTime;
    private Date        lastAppointmentDate;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getVacccinNo() {
        return vacccinNo;
    }

    public void setVacccinNo(Integer vacccinNo) {
        this.vacccinNo = vacccinNo;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    

    public String getVacccinTipe() {
        return vacccinTipe;
    }

    public void setVacccinTipe(String vacccinTipe) {
        this.vacccinTipe = vacccinTipe;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonAddres() {
        return personAddres;
    }

    public void setPersonAddres(String personAddres) {
        this.personAddres = personAddres;
    }

    public String getVaccinCity() {
        return vaccinCity;
    }

    public void setVaccinCity(String vaccinCity) {
        this.vaccinCity = vaccinCity;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Date getLastAppointmentDate() {
        return lastAppointmentDate;
    }

    public void setLastAppointmentDate(Date lastAppointmentDate) {
        this.lastAppointmentDate = lastAppointmentDate;
    }

    

    
    
    
}
