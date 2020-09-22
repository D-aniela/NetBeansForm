package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConectorBD {
    private Connection conexion;
    private Statement sentencia;
    
    private final String servidor = "localhost";
    private final String puerto = "3306";
    private final String BD = "bd_formulario";
    private final String usuario = "root";
    private final String clave = "";
    private final String URL = "jdbc:mysql://localhost:3306/mysql";
    
    public ConectorBD(){
        this.conexion = null;
        this.sentencia = null;
            }
    
    public boolean conectar(){
        boolean estado = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try{
                conexion=DriverManager.getConnection(URL,usuario,clave);
                estado=true;
            }catch(SQLException ex){
                System.err.println("ERROR: ConectorBD.conectar()");
                System.err.println("Al intentar la conexión con la BD");
                System.err.println(ex.getMessage());
            }
        }catch(ClassNotFoundException cex){
            System.err.println("ERROR: ConectorBD.conectar()");
                System.err.println("No se encontro el Driver de conexión con MySQL");
                System.err.println(cex.getMessage());
        }
        return estado;
    }
    
    public ResultSet seleccionar(String sql){
        ResultSet resultado =null;
        try{
            sentencia = conexion.createStatement();
            resultado=sentencia.executeQuery(sql);
        }catch(SQLException sqle){
            System.err.println("ERRORR: ConectorBD.seleccionar(sql)");
            System.err.println(sqle.getMessage());
        }
        return resultado;
    }
    
    public void desconectar(){
        try{
            if( conexion != null){
                conexion.close();
                conexion = null;
            }
        }catch(SQLException sqle){
            System.err.println("ERROR: ConectorBD.desconectar()");
            System.err.println(sqle.getMessage());
        }
    }
    
    public Connection getConnection (){
        return conexion;
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
