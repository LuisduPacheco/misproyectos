package modelo;

import conexion.Conector;
import java.util.ArrayList;
import java.sql.ResultSet;

public class AutorDAO implements ConsultasAutor {

    @Override
    public boolean insertar(AutorVO a) {
        Conector c = new Conector();

        try {
            c.conectar();
            String query = "INSERT INTO autor (nombre_autor, apellido_autor, "
                    + "nacionalidad_autor, fecha_ingreso) "
                    + "VALUES ('" + a.getNombreAutor() + "', '" + a.getApellidoAutor() + "', '" + a.getNacionalidadAutor() + "', '"
                    + a.getFechaInAutor() + "')";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[Minsert]: " + e.getMessage());
            c.desconectar();
            return false;

        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<AutorVO> consultar() {
        Conector c = new Conector();
        ArrayList<AutorVO> info = new ArrayList<>();

        try {
            c.conectar();
            String query = "SELECT id_autor, nombre_autor, apellido_autor, nacionalidad_autor "
                    + "FROM bdbiblioteca.autor";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
            AutorVO avo = new AutorVO();
            avo.setIdAutor(rs.getInt(1));
            avo.setNombreAutor(rs.getString(2));
            avo.setApellidoAutor(rs.getString(3));
            avo.setNacionalidadAutor(rs.getString(4));
            info.add(avo);
            }
            c.desconectar();
            
        } catch (Exception e) {
            System.err.println("Error[MConsultar]: "+e.getMessage());
        c.desconectar();
        }
        return info;
    }

    @Override
    public boolean actualizar(AutorVO a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdbiblioteca.autor "+
                            "SET nombre_autor = '"+a.getNombreAutor()+
                            "', apellido_autor = '"+a.getApellidoAutor()+
                            "', nacionalidad_autor = '"+a.getNacionalidadAutor()+
                            "', fecha_actualiza = '"+a.getFechaActAutor()+
                            "' WHERE id_autor = "+a.getIdAutor();
            c.consultasMultiples(query); 
        } catch (Exception e) {
            System.err.println("Error[MActAutor]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        
    c.desconectar();
    return true;
    }

    @Override
    public boolean eliminar(AutorVO a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "DELETE FROM bdbiblioteca.autor WHERE id_autor = "+a.getIdAutor();
            c.consultasMultiples(query);
            
        } catch (Exception e) {
            System.err.println("Error[MEliminaAutor]: "+e.getMessage());
            c.desconectar();            
        }
        c.desconectar();
        return true;
    }

}
