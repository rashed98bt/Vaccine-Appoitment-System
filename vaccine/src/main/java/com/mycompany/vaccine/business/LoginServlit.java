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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlit extends HttpServlet{
    
    Connector conn = new Connector();
    String id= null;
    PersonBean person;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        id = req.getParameter("id");
        person = getUserId(id);
        req.getSession().setAttribute("person", person);
        if(checkAge() == true){
            resp.sendRedirect("ui/pages/UnderAge.html");
        } else {    
            
            req.getRequestDispatcher("ui/pages/Appoitment.jsp").forward(req, resp);
        }
    }

    
    public  PersonBean getUserId(String id){
        PersonBean person = null;
        
        try {
            Connection con =  conn.getConnection();
            String sql = "SELECT * FROM person WHERE Person_Id = "+id ;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               person = new PersonBean();  
               person.setPersonId(rs.getInt("Person_Id"));
               person.setFirsName(rs.getString("First_Name"));
               person.setLastName(rs.getString("Last_Name"));
               person.setPersonAddres(rs.getString("Adress"));
               person.setBirthDate(rs.getDate("Birth_Date").toLocalDate());
               person.setVacccinTipe(rs.getString("Vaccine_Tipe"));
               person.setVacccinNo(rs.getInt("Dose_no"));
               person.setVaccinCity(rs.getString("Vaccine_City"));
               Object date = rs.getDate("Appointment_Date");
               Object time = rs.getTime("Appointment_Time");
               Object ldate = rs.getDate("Last_Appointment_Date");
               if(time != null){
                    person.setAppointmentDate((Date)date);
                    person.setAppointmentTime((Time)time);
               }
               if(ldate != null){
                   person.setLastAppointmentDate((Date) ldate);
               }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return person;
    }
    
    public boolean checkAge(){
        LocalDate local = LocalDate.now();
        int x = local.getYear() - person.getBirthDate().getYear();
        if(x < 12 ){
            return true;
        } else {
            if(person.getVacccinNo() == 3){
               return true; 
            }
            return false;
        }    
    }

}
