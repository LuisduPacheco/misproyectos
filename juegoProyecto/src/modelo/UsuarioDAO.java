package modelo;

import java.sql.ResultSet;
import conexion.Conector;
import java.util.ArrayList;

public class UsuarioDAO implements ConsultasUsuario {

    @Override
    public ArrayList<UsuarioVO> validarLogin(String username, String contrasenia) {
        Conector c = new Conector();

        ArrayList<UsuarioVO> datos = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT username, contrasenia, id_rol_usuario_fk "
                    + "FROM bdjuego.usuario WHERE username = '" + username + "' AND contrasenia = '" + contrasenia + "'";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()) {
                UsuarioVO uvo = new UsuarioVO();
                uvo.setUserName(rs.getString(1));
                uvo.setContrasenia(rs.getString(2));
                uvo.setIdRolUsuarioFk(rs.getInt(3));
                datos.add(uvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error[MValLog]: " + e.getMessage());
            c.desconectar();
        }
        return datos;
    }

    @Override
    public boolean insertar(UsuarioVO u) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO usuario (nombre_usuario, apellido_usuario, edad_usuario, username, contrasenia, id_rol_usuario_fk) VALUES "
                        +"('"+u.getNombreUsuario()+"', '"+u.getApellidoUsuario()
                        +"', "+u.getEdadUsuario()+", '"+u.getUserName()
                        +"', '"+u.getContrasenia()+"', "+u.getIdRolUsuarioFk()+")";
        
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[MInserta]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<UsuarioVO> consultar() {
        Conector c = new Conector ();
        ArrayList<UsuarioVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT id_usuario, nombre_usuario, apellido_usuario, "+
                            "edad_usuario, username, contrasenia, id_rol_usuario_fk "+
                            "FROM bdjuego.usuario";
                            
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
            UsuarioVO uvo = new UsuarioVO();
            uvo.setIdUsuario(rs.getInt(1));
            uvo.setNombreUsuario(rs.getString(2));
            uvo.setApellidoUsuario(rs.getString(3));
            uvo.setEdadUsuario(rs.getInt(4));
            uvo.setUserName(rs.getString(5));
            uvo.setContrasenia(rs.getString(6));
            uvo.setIdRolUsuarioFk(rs.getInt(7));
            info.add(uvo);
            
            }
        } catch (Exception e) {
            System.err.println("Error[MConsul]: "+e.getMessage());
            c.desconectar();        
        }
        return info;
    }
    
    

}
