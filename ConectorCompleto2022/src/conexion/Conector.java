package conexion;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conector {
//Aqui se crean los objetos de conexión 
//1. Crear unas variables generales (de clase)    

    private String driver = "com.mysql.jdbc.Driver";  //Va la referencia a las librerias que insertamos
    private String host = "127.0.0.1"; //Dirección a la que me voy a conectar 
    private String user = "root"; //Usuario de conexión 
    private String pass = "";
    private String db = "bdconector"; //db = DATABASE, nombre de la base de datos que se va a usar
    private String cadena;

//Declaración de objetos para la conexion 
    Connection connection;
    Statement statement;

//Declaración de metodos para la conexión
//Metodo de conectar
    public void conectar() {
        this.cadena = "jdbc:mysql://" + this.host + "/" + this.db; //esta es la ruta de conexion 
        try {
            Class.forName(this.driver).newInstance(); //Convierte el driver en una clase
            this.connection = DriverManager.getConnection(this.cadena, this.user, this.pass);
        } catch (Exception e) {
            System.err.println("Error[MCon]: " + e.getMessage());
        }
    }

//Metodo desconectar
    public void desconectar() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println("Error[MDes: ]" + e.getMessage());
        }
    }
//Metodo para realizar los querys de INSERT, UPDATE , DELETE 
    //Este metodo va a retornar un 0 o 1

    public int consultasMultiples(String query) {
        int resultado;
        try {
            this.conectar(); //conectando a la base de datos
            this.statement = this.connection.createStatement(); // para poder realizar la consulta
            resultado = this.statement.executeUpdate(query);//La consulta puede ser Update, delete o insert

        } catch (Exception e) {
            System.err.println("Error[MCMultiples]:" + e.getMessage());
            return 0;
        }
        return resultado;
    }

//Metodo para realizar consultas SELECT 
    public ResultSet consultaDatos(String consulta) {
        try {
            this.conectar();
            ResultSet resultado = null;
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeQuery(consulta);
            return resultado;
        } catch (Exception e) {
            System.err.println("Error[CDatos]:" + e.getMessage());
            return null;
        }
    }
//fin de la API
}
