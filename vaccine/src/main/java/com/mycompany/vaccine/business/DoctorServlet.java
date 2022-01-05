/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vaccine.business;

import com.mycompany.vaccine.bean.PersonBean;
import com.mycompany.vaccine.connection.Connector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DoctoServlet")
public class DoctorServlet extends HttpServlet{
    
    Connector conn = new Connector();
    String id= null;
    Date lastAppointmentDate;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.id = request.getParameter("Personid");
        updateDoseNo();
        response.sendRedirect("doctorPage.jsp");
    }
    public List<PersonBean> getAllAppoitment(){
        
        List<PersonBean> personlist = new ArrayList<PersonBean>();
        PersonBean personobj = new PersonBean();
        LocalDate nowDay = LocalDate.now();
        try {
            Connection con = conn.getConnection();
            String sql = "SELECT * FROM person WHERE Appointment_Date = " +"'"+ nowDay +"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               personobj = new PersonBean();  
               personobj.setPersonId(rs.getInt("Person_Id"));
               personobj.setFirsName(rs.getString("First_Name"));
               personobj.setLastName(rs.getString("Last_Name"));
               personobj.setPersonAddres(rs.getString("Adress"));
               personobj.setBirthDate(rs.getDate("Birth_Date").toLocalDate());
               personobj.setVacccinTipe(rs.getString("Vaccine_Tipe"));
               personobj.setVacccinNo(rs.getInt("Dose_no"));
               personobj.setVaccinCity(rs.getString("Vaccine_City"));
               Object date = rs.getDate("Appointment_Date");
               Object time = rs.getTime("Appointment_Time");
               if(time != null){
                    personobj.setAppointmentDate((Date)date);
                    personobj.setAppointmentTime((Time)time);
               }
               personlist.add(personobj);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personlist;
    }
    
    public  int  getPersonDose(String id){
        
        Integer doseNo = null;
        try {
            Connection con =  conn.getConnection();
            String sql = "SELECT Appointment_Date , Dose_no FROM person WHERE Person_Id = "+id ;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                doseNo = rs.getInt("Dose_no") + 1;
                lastAppointmentDate = rs.getDate("Appointment_Date");
            }
               
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return doseNo;
    }
    public void updateDoseNo(){
        int doseNo = this.getPersonDose(id);
        try {
            Connection con =  conn.getConnection();
            String sql = "UPDATE person SET Dose_no = " + doseNo +
                         ", Last_Appointment_Date = ' " + lastAppointmentDate +" ' "+
                         ", Appointment_Date = NULL " + 
                         ", Appointment_Time = NULL " +
                         " WHERE Person_Id = "+ id ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }        
}
    
