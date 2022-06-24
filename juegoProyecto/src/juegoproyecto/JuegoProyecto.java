package juegoproyecto;
import conexion.Conector;
import controlador.ControladorAdmin;
import controlador.ControladorMenu;
import controlador.ControladorPrincipiante;
import modelo.Principiante;

import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmMenu;
import vista.FrmPrincipiante;


public class JuegoProyecto {
    public static void main(String[] args) {

    //Conector c = new Conector();
    //c.conectar();
    //VENTANAS  
    FrmMenu vMnu = new FrmMenu();
    FrmAdministrador vAdmin = new FrmAdministrador();
    FrmPrincipiante vPri = new FrmPrincipiante();
    
    //MODELO
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();
    Principiante pri = new Principiante();
    //CONTROLADORES
    ControladorMenu cMnu = new ControladorMenu(vAdmin, vMnu, vPri);
    ControladorAdmin cAdmin = new ControladorAdmin(vAdmin, uvo, udao);
    ControladorPrincipiante cPri = new ControladorPrincipiante (vPri,vMnu, pri);
    
    //Apertura del menú
    vMnu.setVisible(true);
    vMnu.setLocationRelativeTo(null);
    vMnu.setResizable(false);
    
    
    }
    
}
