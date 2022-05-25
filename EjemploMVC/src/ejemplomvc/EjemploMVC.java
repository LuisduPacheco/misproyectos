
package ejemplomvc;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.FrmOperaciones;


public class EjemploMVC {

    public static void main(String[] args) {
     
        // TODO code application logic here
    FrmOperaciones ope = new FrmOperaciones();
    ModeloLogico ml = new ModeloLogico();
    Controlador c = new Controlador(ope, ml);
    ope.setVisible(true);
    ope.setLocationRelativeTo(null);
    }    
}
