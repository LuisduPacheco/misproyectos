package juegoproyecto;


import conexion.Conector;
import controlador.ControladorAdmin;
import controlador.ControladorAvan;
import controlador.ControladorInter;
import controlador.ControladorLogin;
import controlador.ControladorPrincipiante;
import modelo.Avanzado;
import modelo.PreguntasDAO;
import modelo.PreguntasVO;
import modelo.Principiante;
import modelo.RespuestaDAO;
import modelo.RespuestaVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmAvanzado;
import vista.FrmIntermedio;
import vista.FrmLogin;
import vista.FrmPrincipiante;

public class JuegoProyecto {

    public static void main(String[] args) {


        

//Objetos de las ventanas
        FrmLogin vLog = new FrmLogin();
        FrmAdministrador vAdmin = new FrmAdministrador();
        FrmAvanzado vAvan = new FrmAvanzado();
        FrmIntermedio vInter = new FrmIntermedio();
        FrmPrincipiante vPrin = new FrmPrincipiante();
        

        //Modelo
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioVO uvo = new UsuarioVO();
        Principiante prin = new Principiante();
        RespuestaDAO rdao = new RespuestaDAO();
        RespuestaVO rvo = new RespuestaVO();
        PreguntasDAO pdao = new PreguntasDAO();
        PreguntasVO pvo = new PreguntasVO();
        Avanzado ava = new Avanzado();

        //Controladores
        ControladorLogin cLog = new ControladorLogin(vLog, vAdmin, vAvan, vInter, vPrin, udao, uvo);
        ControladorAdmin cAdmin = new ControladorAdmin(vAdmin, uvo, udao);
        ControladorPrincipiante cPrin = new ControladorPrincipiante(vPrin, vLog, prin);
        ControladorInter cInter = new ControladorInter(vInter, pvo, pdao, rvo, rdao);
        ControladorAvan cAvan = new ControladorAvan(vAvan, ava);

        //Apertura de la ventana login
        vLog.setVisible(true);
        vLog.setLocationRelativeTo(null);
        vLog.setResizable(false);

    }

}
