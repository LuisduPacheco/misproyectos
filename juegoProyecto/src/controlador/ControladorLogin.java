package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmAvanzado;
import vista.FrmIntermedio;
import vista.FrmLogin;
import vista.FrmPrincipiante;

public class ControladorLogin implements ActionListener {

    FrmLogin vLog = new FrmLogin();
    FrmAdministrador vAdmin = new FrmAdministrador();
    FrmAvanzado vAvan = new FrmAvanzado();
    FrmIntermedio vInter = new FrmIntermedio();
    FrmPrincipiante vPrin = new FrmPrincipiante();

    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();

    public ControladorLogin(FrmLogin vLog, FrmAdministrador vAdmin, FrmAvanzado vAvan, FrmIntermedio vInter, FrmPrincipiante vPrin, UsuarioDAO udao, UsuarioVO uvo) {
        this.vLog = vLog;
        this.udao = udao;
        this.uvo = uvo;

        this.vAdmin = vAdmin;
        this.vAvan = vAvan;
        this.vInter = vInter;
        this.vPrin = vPrin;

        this.vLog.btnCancela.addActionListener(this);
        this.vLog.btnIngresa.addActionListener(this);
    }

    public void validarLogin() {

        if (!vLog.txtUserLogin.getText().equals("") && !String.valueOf(vLog.txtPassLogin.getPassword()).equals("")) { // IF para validar que no estén vacíos los campos del login
            System.out.println(uvo.getUserName()); //sout para testear

            for (UsuarioVO uvo : udao.validarLogin(vLog.txtUserLogin.getText(), String.valueOf(vLog.txtPassLogin.getPassword()))) { //FOR EACH para recorrer el ArrayList y buscar en la BD

                System.out.println("Ingresó al for"); // sout solo para testear
                System.out.println(uvo.getContrasenia()); //Sout para ver si seteó la variable uvo
                System.out.println(String.valueOf(vLog.txtPassLogin.getPassword()));

                System.out.println(uvo.getUserName());  //Sout para ver si seteó la variable uvo
                System.out.println(vLog.txtUserLogin.getText());

                System.out.println();

                System.out.println(uvo.getIdRolUsuarioFk());

                if (vLog.txtUserLogin.getText().equals(uvo.getUserName()) && String.valueOf(vLog.txtPassLogin.getPassword()).equals(uvo.getContrasenia())) { // Comparando los valores ingresados con la BD              
                    System.out.println("Ingresó al if que valida los datos del login");
                    if (uvo.getIdRolUsuarioFk() == 1) {
                        System.out.println("Es Administrador");
                        vAdmin.setVisible(true);
                        vAdmin.setLocationRelativeTo(vLog);
                        vAdmin.setResizable(false);
                        
                    } else if (uvo.getIdRolUsuarioFk() == 2) {
                        vAvan.setVisible(true);
                        vAvan.setLocationRelativeTo(vLog);
                        vAvan.setResizable(false);
                        System.out.println("Es Avanzado");
                        
                    } else if (uvo.getIdRolUsuarioFk() == 3) {
                        vInter.setVisible(true);
                        vInter.setLocationRelativeTo(vLog);
                        vInter.setResizable(false);
                        System.out.println("Es intermedio");
                        
                    } else if (uvo.getIdRolUsuarioFk() == 4) {
                        vPrin.setVisible(true);
                        vPrin.setLocationRelativeTo(vLog);
                        vPrin.setResizable(false);
                        System.out.println("Es principiante");
                    } else {
                        System.out.println("Error en el tipo de usuario");
                    }
                } else {
                    System.out.println("No se encontraron datos");
                }

            }
        } else {
            vLog.jopMensaje.showMessageDialog(vAdmin, "Verifique los datos");
        }

    }

    public void login() {
        System.out.println("Metodo Login");
        System.out.println(uvo.getUserName());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vLog.btnIngresa) {
            this.validarLogin();
            this.login();
        }
        if (e.getSource() == vLog.btnCancela) {
            this.vLog.txtPassLogin.setText("");
            this.vLog.txtUserLogin.setText("");
        }
    }

}
