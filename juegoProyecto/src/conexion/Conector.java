package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {

    //Variables para la conexión
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "127.0.0.1";
    private String user = "root";
    private String pass = "";
    private String bd = "bdjuego";
    private String cadena;

    //Crear objetos para la conexión
    public Connection connection;
    Statement statement;

    //Crear el método conectar
    public void conectar() {
        this.cadena = "jdbc:mysql://" + this.host + "/" + this.bd; //Esta es la rúta de conexión
        try {
            Class.forName(this.driver).newInstance(); //Convierte el driver en una clase
            this.connection = DriverManager.getConnection(this.cadena, this.user, this.pass);
        } catch (Exception e) {
            System.err.println("Error[MCon]: " + e.getMessage());
        }
    }

    //Crear el método desconectar
    public void desconectar() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println("Error[MDes]: " + e.getMessage());
        }

    }

    //Método para realizar los querys de INSERT, UPDATE, DELETE
    public int consultasMultiples(String query) {
        int resultado;
        try {
            this.conectar(); // Conectado a la base de datos 
            this.statement = this.connection.createStatement(); //PARA PODER REALIZAR LA CONSULTA
            resultado = this.statement.executeUpdate(query); //La consulta puede ser UPDATE, DELETE O INSERT

        } catch (Exception e) {
            System.err.println("Erro[MCMultiples]: " + e.getMessage());
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
            System.err.println("Error [MCDatos]: " + e.getMessage());

        }
        return null;
    }
    //FIN DEL API DE CONEXIÓN

}
