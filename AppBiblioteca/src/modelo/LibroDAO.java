package modelo;

import conexion.Conector;
import java.util.ArrayList;
import java.sql.ResultSet;

public class LibroDAO implements ConsultasLibro {

    @Override
    public boolean insertarL(LibroVO l) {
        Conector c = new Conector();
        try {
            c.conectar();

            String query = "INSERT INTO libro (titulo_libro, no_paginas, autor_libro, editorial_libro, fecha_ingreso, id_autor_fk) "
                    + "VALUES ('" + l.getTituloLibro() + "', " + l.getNoPaginas() + ", '" + l.getAutorLibro() + "', '" + l.getEditoLibro() + "', '" + l.getFechaInLibro() + "', " + l.getIdAutorFk() + ")";
            c.consultasMultiples(query);

        } catch (Exception e) {
            System.err.println("Error[MLinsert]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();

        return true;
    }

    @Override
    public ArrayList<LibroVO> consultarL() {
        Conector c = new Conector();
        ArrayList<LibroVO> info = new ArrayList();
        try {
            c.conectar();
            String query = "SELECT l.id_isbn, l.titulo_libro, l.no_paginas, l.autor_libro, l.editorial_libro, l.id_autor_fk "
                    + "FROM bdbiblioteca.libro l";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()) {
                LibroVO lvo = new LibroVO();
                lvo.setIdIsbn(rs.getInt(1));
                lvo.setTituloLibro(rs.getString(2));
                lvo.setNoPaginas(rs.getString(3));
                lvo.setAutorLibro(rs.getString(4));
                lvo.setEditoLibro(rs.getString(5));
                lvo.setIdAutorFk(rs.getInt(6));
                info.add(lvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error[MConsultar]: " + e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public boolean eliminaL(LibroVO l) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "DELETE FROM bdbiblioteca.libro WHERE id_isbn = " + l.getIdIsbn();
            c.consultasMultiples(query);

        } catch (Exception e) {
            System.err.println("Error[MeliminaL]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean actualizaL(LibroVO l) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdbiblioteca.libro "+
                            "SET editorial_libro = '"+l.getEditoLibro()+
                            "', no_paginas = "+l.getNoPaginas()+
                            ", titulo_libro = '"+l.getTituloLibro()+
                            "', fecha_actualiza = '"+l.getFechaActLibro()+
                            "' WHERE id_isbn = "+l.getIdIsbn();
            c.consultasMultiples(query);

        } catch (Exception e) {
            System.err.println("Error[MactLibro]: " + e.getMessage());
            c.desconectar();
        }
        c.desconectar();
        return true;
    }

}
