/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vaccine.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    
        public  Connection getConnection() throws SQLException {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jordanian_people";
            con = DriverManager.getConnection(url,"root","");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return con;
    }
}
