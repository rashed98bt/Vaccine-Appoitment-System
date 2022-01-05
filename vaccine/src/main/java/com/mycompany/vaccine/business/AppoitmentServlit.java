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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AppoitmentServlit")
public class AppoitmentServlit extends HttpServlet {
    
    Connector conn = new Connector();    
    String  vTipe ;
    String  vCity ;
    Integer vNo ;
    PersonBean pobj;
    LocalDate appointmentDate = null;
    LocalTime appointmentTime = null;
    String radioType;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        pobj = (PersonBean) request.getSession(true).getAttribute("person");
        vTipe = request.getParameter("vaccineTipe");
        vCity = request.getParameter("vaccineCity");  
        appointmentDate = LocalDate.parse(request.getParameter("meeting-date")); 
        appointmentTime = LocalTime.parse(request.getParameter("meeting-time"));
        radioType = request.getParameter("Radio");
        HttpSession session = request.getSession();
        
        if(this.checkAppoitmentDate()){
            session.invalidate();
            response.sendRedirect("login.jsp");
        } else {
            request.getRequestDispatcher("ui/pages/Appoitment.jsp").forward(request, response);
        }         
    }
           
    public void setAppoitment(int id){       
        try {

            Connection con = conn.getConnection();
            String sql = "UPDATE  person set " +
                        "Appointment_Date = '" + appointmentDate + " ', "+
                        "Appointment_Time = '" + appointmentTime + " ', "+
                        "Vaccine_Tipe = '" + vTipe + "' , " +
                        "Vaccine_City = '" + vCity + "'  " + 
                        " WHERE  Person_Id = " + id;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
    public void setSecoundSeAppoitment(int id){

        try {
            Connection con = conn.getConnection();
            String sql = "UPDATE  person set " +
                        "Appointment_Date = '" + appointmentDate + " ', "+
                        "Appointment_Time = '" + appointmentTime + " ' "+ 
                        " WHERE  Person_Id = " + id;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
    
    public boolean checkAppoitmentDate(){
        
        if(pobj.getVacccinNo() == 0 ){
            setAppoitment(pobj.getPersonId());
        } else {
            if(pobj.getVacccinNo() == 1 ){
                if(pobj.getVacccinTipe().equals("Pfizer") ){
                    return this.pfizerAppoitment();
                } else if(pobj.getVacccinTipe().equals("Sinopharm")){
                    return this.sinopharmAppoitment();
                }
            } else if(pobj.getVacccinNo() == 2 ){
                if(radioType.equals( "YES")){
                    if(pobj.getVacccinTipe().equals("Pfizer") ){
                        return this.pfizerAppoitment();

                    } else if(pobj.getVacccinTipe().equals("Sinopharm")){
                        return this.sinopharmAppoitment();
                    }
                } else if (radioType == "NO"){
                    return false;
                }
            } 
        }
        return true;
    }
    public boolean pfizerAppoitment(){
        if(appointmentDate.getDayOfYear() >= pobj.getLastAppointmentDate().toLocalDate().getDayOfYear()+ 45){
            this.setSecoundSeAppoitment(pobj.getPersonId());
            return true;
        } else {
            return false;
        }
        
    }
    public boolean sinopharmAppoitment(){
        if(appointmentDate.getDayOfYear() >= pobj.getLastAppointmentDate().toLocalDate().getDayOfYear()+ 21){
            this.setSecoundSeAppoitment(pobj.getPersonId());
            return true;
        } else {
            return false;
        }
    }
}
