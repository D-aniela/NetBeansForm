/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Codellege
 */
public class connector {
    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn=(Connection)
        DriverManager.getConnection("jdbc:mysql://localhost:3306/formulario", "daniela", "yes");
        
        return cn;
    }
    
}
