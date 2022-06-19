package modelo;

import conexion.Conector;
import java.sql.ResultSet;
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

}
