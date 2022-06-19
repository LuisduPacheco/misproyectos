
package modelo;

import java.util.ArrayList;

public interface ConsultasLibro {
    
     public boolean insertarL(LibroVO l);
     public ArrayList<LibroVO> consultarL();
     public boolean eliminaL(LibroVO l);
     public boolean actualizaL(LibroVO l);        
           //  public ArrayList<AutorVO> consultar();
}
