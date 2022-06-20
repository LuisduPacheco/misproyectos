
package modelo;

import java.util.ArrayList;

public interface ConsultasUsuario {
    public ArrayList<UsuarioVO> validarLogin(String username, String contrasenia);
    public boolean insertar(UsuarioVO u);
    public ArrayList<UsuarioVO> consultar();
    public boolean actualizarU(UsuarioVO u);
    public boolean eliminarU(UsuarioVO u);
}
