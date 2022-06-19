
package modelo;

import java.util.ArrayList;

public interface ConsultasUsuario {
   
    public ArrayList<UsuarioVO> validarLogin(String username, String contrasenia);

}
