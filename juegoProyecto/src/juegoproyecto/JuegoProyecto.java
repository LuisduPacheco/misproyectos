package juegoproyecto;
import conexion.Conector;
import controlador.ControladorAdmin;
import controlador.ControladorMenu;

import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmMenu;


public class JuegoProyecto {
    public static void main(String[] args) {

    //Conector c = new Conector();
    //c.conectar();
    //VENTANAS  
    FrmMenu vMnu = new FrmMenu();
    FrmAdministrador vAdmin = new FrmAdministrador();
    
    
    //MODELO
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();
    
    //CONTROLADORES
    ControladorMenu cMnu = new ControladorMenu(vAdmin, vMnu);
    ControladorAdmin cAdmin = new ControladorAdmin(vAdmin, uvo, udao);
    
    
    //Apertura del menú
    vMnu.setVisible(true);
    vMnu.setLocationRelativeTo(null);
    vMnu.setResizable(false);
    
    
    }
    
}
