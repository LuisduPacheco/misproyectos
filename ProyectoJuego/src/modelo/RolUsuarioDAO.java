
package modelo;

import conexion.Conector;
import java.util.ArrayList;

public class RolUsuarioDAO implements Consultas {

    @Override
    public boolean insertarRol(RolUsuarioVO r) {
    
        return true;
    }

//    @Override
//    public ArrayList<RolUsuarioVO> consultarRol() {
//    
//    }

    @Override
    public boolean eliminar(RolUsuarioVO r) {
        return true;
    }

    @Override
    public boolean actualizar(RolUsuarioVO r) {
        return true;
    }

    @Override
    public boolean ingresar(RolUsuarioVO r) {
        Conector c = new Conector();
        try {
            String query = "SELECT l.tipo_usuario FROM bdjuego l "
                            +"WHERE l.username = '"; 
        } catch (Exception e) {
        }
        
        
    return true;
    }
    
}
