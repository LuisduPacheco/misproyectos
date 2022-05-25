
package calculadoramvc;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.FrmCalculadora;


public class CalculadoraMVC {
    public static void main(String[] args) {
        
        FrmCalculadora calc = new FrmCalculadora();
        ModeloLogico ml = new ModeloLogico();
        Controlador cl = new Controlador (calc, ml);
        
        calc.setVisible(true);
        calc.setLocationRelativeTo(null);
        
        
    }
    
       

    
}
