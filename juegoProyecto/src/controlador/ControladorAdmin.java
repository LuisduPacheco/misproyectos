package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;

public class ControladorAdmin implements WindowListener, ActionListener, MouseListener {

    FrmAdministrador vAdmin = new FrmAdministrador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();

    public ControladorAdmin(FrmAdministrador vAdmin, UsuarioVO uvo, UsuarioDAO udao) {

        this.vAdmin = vAdmin;
        this.uvo = uvo;
        this.udao = udao;

        vAdmin.btnActualiza.addActionListener(this);
        vAdmin.btnElimina.addActionListener(this);
        vAdmin.btnMuestra.addActionListener(this);
        vAdmin.btnRegistra.addActionListener(this);
        vAdmin.addWindowListener(this);
        vAdmin.tblMostrar.addMouseListener(this);

    }

    public void mostrar() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id Usuario");
        m.addColumn("Nombre");
        m.addColumn("Apellido");
        m.addColumn("Edad");
        m.addColumn("Usuario");
        m.addColumn("Id Rol");

        for (UsuarioVO uvo : udao.consultar()) {
            m.addRow(new Object[]{uvo.getIdUsuario(), uvo.getNombreUsuario(), uvo.getApellidoUsuario(),
                uvo.getEdadUsuario(), uvo.getUserName(), uvo.getIdRolUsuarioFk()});
        }
        vAdmin.tblMostrar.setModel(m);
    }

    public void insertar() {
        this.uvo.setNombreUsuario(this.vAdmin.txtNombreU.getText());
        this.uvo.setApellidoUsuario(this.vAdmin.txtApellidoU.getText());
        this.uvo.setEdadUsuario(Integer.parseInt(this.vAdmin.txtEdadU.getText()));
        this.uvo.setUserName(this.vAdmin.txtUsuario.getText());
        this.uvo.setContrasenia(this.vAdmin.txtContrasenia.getText());
        this.uvo.setIdRolUsuarioFk(Integer.parseInt(this.vAdmin.txtRolU.getText()));

        if (udao.insertar(uvo) == true) {
            vAdmin.jopMensaje.showMessageDialog(vAdmin, "Registro correcto");
            vAdmin.txtApellidoU.setText("");
            vAdmin.txtContrasenia.setText("");
            vAdmin.txtEdadU.setText("");
            vAdmin.txtIdU.setText("");
            vAdmin.txtNombreU.setText("");
            vAdmin.txtRolU.setText("");
            vAdmin.txtUsuario.setText("");

        } else {
            vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, revise los datos");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vAdmin.btnRegistra) {
            if (vAdmin.txtIdU.getText().equals("")) {
                if (!vAdmin.txtApellidoU.getText().equals("") && !vAdmin.txtContrasenia.getText().equals("") && !vAdmin.txtEdadU.getText().equals("")
                        && !vAdmin.txtNombreU.getText().equals("") && !vAdmin.txtUsuario.getText().equals("")) {
                    if (vAdmin.txtRolU.getText().equals("1") || vAdmin.txtRolU.getText().equals("2") || vAdmin.txtRolU.getText().equals("3") || vAdmin.txtRolU.getText().equals("4")) {
                        this.insertar();
                        
                    }else{
                        vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, Rol fuera de rango");
                    }
                }else{
                    vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, llene los campos solicitados");
                }
            }else {
                vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, Usuario con ID "+vAdmin.txtIdU.getText()+" ya está registrado");
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
