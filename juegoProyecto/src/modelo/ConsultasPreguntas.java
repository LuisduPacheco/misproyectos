
package modelo;

import java.util.ArrayList;

 
public interface ConsultasPreguntas {

    public ArrayList<PreguntasVO> consultar();
    public String consultaP(PreguntasVO p);
    
//public ArrayList<UsuarioVO> validarLogin(String username, String contrasenia);
    
}
