
package traductormvc;
import controlador.Controlador;
import modelo.ModeloLogico;
import vista.FrmTraductor;
public class TraductorMVC {

    public static void main(String[] args) {
        
        FrmTraductor traduce = new FrmTraductor();
        ModeloLogico ml = new ModeloLogico();
        Controlador c = new Controlador(traduce,ml);
        traduce.setVisible(true);
        traduce.setLocationRelativeTo(null);
        
    }    
}
