package modelo;

import conexion.Conector;
import java.util.ArrayList;
import java.sql.ResultSet;

public class PaisDAO implements ConsultasPais {

    @Override
    public boolean insertar(PaisVO p) {
        Conector c = new Conector();
        try {
            c.conectar(); // Conecta a la base de datos
            String query = "INSERT INTO pais (nombre_pais, "
                    + "capital_pais, poblacion_pais, fecha_ingreso_pais )"
                    + "VALUES ('" + p.getNombrePais() + "', '" + p.getCapitalPais() + "', "
                    + p.getPoblacionPais() + ", '" + p.getFechaIngPais() + "')";
            c.consultasMultiples(query);

        } catch (Exception e) {
            System.err.println("Error[MInsert]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<PaisVO> consultar() { //esto se hizo después de crear el array en la interface PaisVO
        Conector c = new Conector();
        ArrayList<PaisVO> info = new ArrayList<>();

        try {
            c.conectar();
            String query = "SELECT "
                    + "		p.id_pais, "
                    + "		p.nombre_pais, "
                    + "		p.capital_pais, "
                    + "		p.poblacion_pais "
                    + "FROM bdconector.pais p";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()) { //Para saber si el result Set está lleno o vacío
                PaisVO pvo = new PaisVO(); //Objeto para que la info se vaya a VO y VO llene los metodos getter y setter
                pvo.setIdPais(rs.getInt(1)); // 1 es para la columna 1
                pvo.setNombrePais(rs.getString(2));
                pvo.setCapitalPais(rs.getString(3));
                pvo.setPoblacionPais(rs.getLong(4)); //ResultSet cuenta con todos los tipos de datos 
                info.add(pvo); //Llena el arreglo conforme el resultSet lo diga
            }
            c.desconectar();

        } catch (Exception e) {
            System.err.println("Error[MMostrar]: " + e.getMessage());
            c.desconectar();
        }

        return info;
    }

    @Override
    public boolean eliminar(PaisVO p) {
        Conector c = new Conector(); // para conectar a la base de datos 
        try {
            c.conectar();
            String query = "DELETE FROM bdconector.pais "
                    + "WHERE id_pais = " + p.getIdPais();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[MDelete]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean actualizar(PaisVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdconector.pais "+
                    "SET nombre_pais = '"+p.getNombrePais()+"', capital_pais = '"+p.getCapitalPais()+"', "+
                    "poblacion_pais = "+p.getPoblacionPais()+", fecha_actualiza_pais = '"+p.getFechaActPais()+"' "+" WHERE id_pais = "+p.getIdPais();
            c.consultasMultiples(query);
            
        } catch (Exception e) {
            System.err.println("Error[MActualizar]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

}
