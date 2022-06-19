package conexion;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
//import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {

    private String driver = "com.mysql.jdbc.Driver";
    private String Host = "127.0.0.1";
    private String user = "root";
    private String pass = "";
    private String bd = "bdbiblioteca";
    private String cadena;

//Objetos para la conexión
    Connection connection;
    Statement statement;

//Metodos para la conexión 
    public void conectar() {
        this.cadena = "jdbc:mysql://"+this.Host+"/"+this.bd; //este es el Path
        try {
            Class.forName(this.driver).newInstance();
            this.connection = DriverManager.getConnection(this.cadena, this.user, this.pass);
        } catch (Exception e) {
            System.err.println("Error[MConect]: " + e.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println("Error[MDesco]: " + e.getMessage());          
        }    
    }
    
    //Metodo para realizar los querys INSERT, UPDATE y DELETE
    public int consultasMultiples(String query){
        int resultado;
        try {
             this.conectar();
             this.statement = this.connection.createStatement();
             resultado = this.statement.executeUpdate(query);
             
        } catch (Exception e) {
            System.err.println("Error[MConMul]: " + e.getMessage());
            return 0;
        }
        return resultado;
    }
    
    //Metodo para realizar consultas SELECT
    public ResultSet consultaDatos(String consulta){
        try {
            this.conectar();
            ResultSet resultado = null; //Null solo para tener una inicialización del ResultSet
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeQuery(consulta);
            return resultado;
        } catch (Exception e) {
            System.err.println("Error[MConDat]: "+ e.getMessage());
            
        }
        return null;
    }
}
//FIN DE LA API DE CONEXCIÓN