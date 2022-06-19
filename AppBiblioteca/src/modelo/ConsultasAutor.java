
package modelo;

import java.util.ArrayList;

public interface ConsultasAutor {

    public boolean insertar(AutorVO a);
    public ArrayList<AutorVO> consultar();
    public boolean actualizar(AutorVO a);
    public boolean eliminar(AutorVO a);
}
