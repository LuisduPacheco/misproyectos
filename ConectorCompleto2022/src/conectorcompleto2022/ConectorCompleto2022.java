
package conectorcompleto2022;

import conexion.Conector;
import controlador.ControladorActualizar;
import controlador.ControladorEliminar;
import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorMostrar;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInsertar;
import vista.FrmMenu;
import vista.FrmMostrar;

public class ConectorCompleto2022 {

   
    public static void main(String[] args) {
     //  Conector c = new Conector();
     //  c.conectar();
       
       //Vistas
       FrmMenu fm = new FrmMenu();
       FrmInsertar fi = new FrmInsertar();
       FrmMostrar fmo = new FrmMostrar();
       FrmEliminar fel = new FrmEliminar(); //Nuevo Eliminar
       FrmActualizar fac = new FrmActualizar();
       
//Modelo
       PaisVO pvo = new PaisVO();
       PaisDAO pdao = new PaisDAO();
       
       
       //Controladores
       ControladorMenu cm = new ControladorMenu(fm, fi, fmo, fel, fac);
       ControladorInsertar ci = new ControladorInsertar(fi, pvo, pdao);
        ControladorMostrar cmo = new ControladorMostrar(fmo, pvo, pdao);
        ControladorEliminar cel = new ControladorEliminar(fel, pvo, pdao); //NUEVO controlador eliminar
        ControladorActualizar cal = new ControladorActualizar(fac, pvo, pdao);
//Configuración de pantalla menu
       fm.setVisible(true);
       fm.setLocationRelativeTo(null);
       fm.setResizable(false);
    }
    
}
