<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="com.mycompany.vaccine.bean.PersonBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vaccine Appoitment Jo</title>
        <link href="./ui/css/appoitmentStyle.css" rel="stylesheet" type="text/css">
        <link href="../css/appoitmentStyle.css" rel="stylesheet" type="text/css">
    </head>

    <body>
 
        <div class="main_caontainer">
            <h1 style="text-align: center;font-size: 25px;color: white">Reservation System</h1>
            <div class="personalInfo">
                <h1> Full Name
                    <span>
                        <%
                            PersonBean person = (PersonBean)session.getAttribute("person");
                            out.print(person.getFirsName()+" "+person.getLastName());
                        %>
                    </span>
                </h1>

                <h1> Birth Date
                    <span>
                        <%
                            out.print(person.getBirthDate());
                        %>
                    </span>
                </h1>
                <h1> Address
                    <span>
                        <%
                            out.print(person.getPersonAddres());
                        %>
                    </span>
                </h1>
                <h1> Vaccine Tipe
                    <span>
                        <%
                            out.print(person.getVacccinTipe());
                        %>
                    </span>
                </h1>
                <h1> How many doses are taken
                    <span>
                        <%
                            out.print(person.getVacccinNo());
                        %>
                    </span>
                </h1>
                <h1> Vaccine City
                    <span>
                        <%
                            out.print(person.getVaccinCity());
                        %>
                    </span>
                </h1>
                <h1> Last Vaccine Appoitment Date
                    <span>
                        <%
                            out.print(person.getLastAppointmentDate());
                        %>
                    </span>
                </h1>
            </div>
            <div class="appoitmentDate">
                <form method="post" action="AppoitmentServlit">
                    <div >
                        <p> Slect Vaccin Type </p>
                        <select id="vaccineTipe" name="vaccineTipe" required="true">
                            <option value="Pfizer" >Pfizer</option>
                            <option value="Sinopharm">Sinopharm </option>
                        </select>
                    </div>
                    <div>
                        <p>Slect Cuntry </p>
                        <select name="vaccineCity" id="vaccineCity">
                            <option value="Irbid" >Irbid</option>
                            <option value="Amman" >Amman</option>
                            <option value="Zarqa" >Zarqa</option>
                            <option value="Mafraq" >Mafraq</option>
                            <option value="Ajloun" >Ajloun</option>
                            <option value="Aqba" >Aqba</option>
                        </select>
                    </div>
                    <div>
                        <p >Choose a Date for your appointment:</p>
                        <input type="date" id="start" name="meeting-date"
                               value="2022-01-01" min="2022-01-01" required="true" >
                    </div>
                    <div>
                        <p >Choose a Time for your appointment:</p>
                        <input type="time"  name="meeting-time"
                        min="08:00" max="17:55" required="true">
                    </div>
                    <div style="display: none" id="acceptForm">
                        <p  >Are you Shore to take therd vaccine dose</p>
                        <input type="radio"  name="Radio" value="YES">
                        <label >YES</label><br>
                        <input type="radio"  name="Radio" value="NO">
                        <label for="css">NO</label><br>
                    </div>
                    <input value="Reservation" type="submit" id="Reservation_btn" />
                </form>
            </div>
        </div>
        <script>
            <% int doseNo =  person.getVacccinNo(); %> 
            
            var x2 = "<%=doseNo%>";
            if(x2 == 2){
                   document.getElementById('acceptForm').style.display  = 'block';
               }
        </script>
    </body>
</html>
