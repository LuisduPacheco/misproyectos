
package modelo;

import java.util.ArrayList;


public interface Consultas {
    
    public boolean insertarRol(RolUsuarioVO r);
    //public ArrayList<RolUsuarioVO> consultarRol();
    public boolean eliminar (RolUsuarioVO r);
    public boolean actualizar (RolUsuarioVO r);
    public boolean ingresar(RolUsuarioVO r);
    
}
