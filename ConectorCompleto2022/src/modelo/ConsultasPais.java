package modelo;

import java.util.ArrayList;

public interface ConsultasPais {
    public boolean insertar(PaisVO p);
    public ArrayList<PaisVO> consultar(); //El retorno es lo que va dentro de <> y va a retornar VO porque ahí están las variables para trabajar
    public boolean eliminar (PaisVO p);
    public boolean actualizar(PaisVO p);
}
