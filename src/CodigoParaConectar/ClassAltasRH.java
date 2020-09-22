/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoParaConectar;

import conexion.ConectorBD;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Codellege
 */
public class ClassAltasRH {
    private final String SQL_INSERT = "INSERT INTO altasrh (NoEmpleado,Nombre,Apellidos,FechaNac,CURP,RFC,SueldoBruto,Puesto,FechaIngreso) values (?,?,?,?,?,?,?,?,?)";
    private PreparedStatement PS;
    private final ConectorBD CN;
    
    
    //constructor
    public ClassAltasRH(){
        PS = null;
        CN = new ConectorBD();
    }
    
    public int insertDatos(int num, String nombre, String apellido, Date fechaNac, String curp, float rfc, float sueldoBruto, Date fechaIng){
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setInt(1, num);
            PS.setString(2, nombre);
            PS.setString(3, apellido);
            PS.setDate(4, (java.sql.Date) fechaNac);
            PS.setString(5, curp);
            PS.setFloat(6, sueldoBruto);
            PS.setDate(7, (java.sql.Date) fechaIng);
            int res = PS.executeUpdate();
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Registro guardado");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al guardar los datos en la base de datos" + e.getMessage());
        }finally{
            PS = null;
            CN.close();
        }
        return 0;
    }

    public void insertDatos(int numero, String nombre, String apellido, DateTimeFormatter fechaNac, String curp, String rfc, float sueldoBruto, DateTimeFormatter fechaIng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertDatos(int numero, String nombre, String apellido, ZonedDateTime fechaNac2, String curp, String rfc, float sueldoBruto, ZonedDateTime fechaIng2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
