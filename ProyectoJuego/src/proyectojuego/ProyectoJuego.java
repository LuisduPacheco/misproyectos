package proyectojuego;

import conexion.Conector;
import controlador.ControladorLogin;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmAvanzado;
import vista.FrmIntermedio;
import vista.FrmLogin;
import vista.FrmPrincipiante;

public class ProyectoJuego {

    public static void main(String[] args) {

        //Prueba de conexión
        // Conector c = new Conector();
        //c.conectar();
        //Objetos de las ventanas
        FrmLogin vLog = new FrmLogin();
        FrmAdministrador vAdmin = new FrmAdministrador();
        FrmAvanzado vAvan = new FrmAvanzado();
        FrmIntermedio vInter = new FrmIntermedio();
        FrmPrincipiante vPrin = new FrmPrincipiante();
        
        //Modelo
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioVO uvo = new UsuarioVO();
        
        //Controladores
        ControladorLogin cLog = new ControladorLogin(vLog, vAdmin, vAvan, vInter, vPrin, udao, uvo);

        //Apertura de la ventana login
        vLog.setVisible(true);
        vLog.setLocationRelativeTo(null);
        vLog.setResizable(false);

    }

}
