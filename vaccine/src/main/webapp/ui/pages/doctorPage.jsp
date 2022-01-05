<%@page import="com.mycompany.vaccine.business.DoctorServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.vaccine.bean.PersonBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vaccine Jo Appoitment</title>
    </head>
    <body>
        <%
            DoctorServlet persons = new DoctorServlet();
            List<PersonBean> personList= new  ArrayList<PersonBean>();
            personList = persons.getAllAppoitment();
            pageContext.setAttribute("variables", personList);
        %>

            <table border="1">
                <thead>
                    <tr>
                        <td>National Id</td>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Adress</td>
                        <td>Birth Date</td>
                        <td>Vaccine Tipe</td>
                        <td>Vaccine City</td>
                        <td>Dose Numbr</td>
                        <td>Appointment Date</td>
                        <td>Appointment Time</td>
                    </tr>
                </thead>
                <tbody>
                        <c:forEach var="person" items="${variables}">
                                <tr>
                                    <td>${person.personId}</td>
                                    <td>${person.firsName}</td>
                                    <td>${person.lastName}</td>
                                    <td>${person.personAddres}</td>
                                    <td>${person.birthDate}</td>
                                    <td>${person.vacccinTipe}</td>
                                    <td>${person.vaccinCity}</td>
                                    <td>${person.vacccinNo}</td>
                                    <td>${person.appointmentDate}</td>
                                    <td>${person.appointmentTime}</td>

                                </tr>
                        </c:forEach>
                </tbody>
            </table>
        <form action="DoctoServlet" method="post">
            <p>Person id</p>
            <input type="number" name="Personid" />
            <input type="submit" value="Add Dose" />
        </form>
        
    </body>
</html>
