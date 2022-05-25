
package edicionarchivosmvc;

import vista.FrmPrincipal;
import modelo.ModeloLogico;
import contolador.Controlador;

public class EdicionArchivosMVC {
    public static void main(String[] args) {
        
        FrmPrincipal principal = new FrmPrincipal();
        ModeloLogico ml = new ModeloLogico();
        Controlador c = new Controlador(principal, ml);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }

    
    
}
