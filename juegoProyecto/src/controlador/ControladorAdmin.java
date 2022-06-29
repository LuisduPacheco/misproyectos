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

    //MOSTRAR LOS DATOS EN LA TABLA
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

    //METODO PARA REGISTRAR UN NUEVO USUARIO
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

    //METODO PARA SETEAR DATOS 
    public void setDatosU() {
        int numRow;
        numRow = vAdmin.tblMostrar.getSelectedRow();

        vAdmin.txtIdU.setText(String.valueOf(vAdmin.tblMostrar.getValueAt(numRow, 0)));
        vAdmin.txtNombreU.setText(String.valueOf(vAdmin.tblMostrar.getValueAt(numRow, 1)));
        vAdmin.txtApellidoU.setText(String.valueOf(vAdmin.tblMostrar.getValueAt(numRow, 2)));
        vAdmin.txtEdadU.setText(String.valueOf(vAdmin.tblMostrar.getValueAt(numRow, 3)));
        vAdmin.txtUsuario.setText(String.valueOf(vAdmin.tblMostrar.getValueAt(numRow, 4)));
        vAdmin.txtRolU.setText(String.valueOf(vAdmin.tblMostrar.getValueAt(numRow, 5)));

    }

    //Metodo para Actualizar datos
    public void actualizaDatos() {
        uvo.setNombreUsuario(vAdmin.txtNombreU.getText());
        uvo.setApellidoUsuario(vAdmin.txtApellidoU.getText());
        uvo.setEdadUsuario(Integer.parseInt(vAdmin.txtEdadU.getText()));
        uvo.setUserName(vAdmin.txtUsuario.getText());
        uvo.setContrasenia(vAdmin.txtContrasenia.getText());
        uvo.setIdUsuario(Integer.parseInt(vAdmin.txtIdU.getText()));
        uvo.setIdRolUsuarioFk(Integer.parseInt(vAdmin.txtRolU.getText()));

        if (udao.actualizarU(uvo) == true) {
            vAdmin.jopMensaje.showMessageDialog(vAdmin, "Actualización correcta");
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

    //Metodo para Eliminar 
    public void eliminaU() {
        uvo.setIdUsuario(Integer.parseInt(vAdmin.txtIdU.getText()));
        udao.eliminarU(uvo);
        if (udao.eliminarU(uvo) == true) {
            vAdmin.jopMensaje.showMessageDialog(vAdmin, "Registro ID Usuario " + vAdmin.txtIdU.getText() + ", eliminado correctamente");
            vAdmin.txtApellidoU.setText("");
            vAdmin.txtContrasenia.setText("");
            vAdmin.txtEdadU.setText("");
            vAdmin.txtIdU.setText("");
            vAdmin.txtNombreU.setText("");
            vAdmin.txtRolU.setText("");
            vAdmin.txtUsuario.setText("");
        } else {
            vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, revise los campos");
        }

    }
    
    public void limpiar(){
        vAdmin.txtApellidoU.setText("");
        vAdmin.txtContrasenia.setText("");
        vAdmin.txtEdadU.setText("");
        vAdmin.txtIdU.setText("");
        vAdmin.txtNombreU.setText("");
        vAdmin.txtRolU.setText("");
        vAdmin.txtUsuario.setText("");
    
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

        //BOTÓN Registrar
        if (e.getSource() == vAdmin.btnRegistra) {
            if (vAdmin.txtIdU.getText().equals("")) {
                if (!vAdmin.txtApellidoU.getText().equals("") && !vAdmin.txtContrasenia.getText().equals("") && !vAdmin.txtEdadU.getText().equals("")
                        && !vAdmin.txtNombreU.getText().equals("") && !vAdmin.txtUsuario.getText().equals("")) {
                    if (vAdmin.txtRolU.getText().equals("1") || vAdmin.txtRolU.getText().equals("2") || vAdmin.txtRolU.getText().equals("3") || vAdmin.txtRolU.getText().equals("4")) {
                        this.insertar();

                    } else {
                        vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, Rol fuera de rango");
                    }
                } else {
                    vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, llene los campos solicitados");
                }
            } else {
                vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, Usuario con ID " + vAdmin.txtIdU.getText() + " ya está registrado");
            }
        }

        //BOTÓN Actualizar
        if (e.getSource() == vAdmin.btnActualiza) {
            if (!vAdmin.txtIdU.getText().equals("")) {
                if (!vAdmin.txtApellidoU.getText().equals("") && !vAdmin.txtContrasenia.getText().equals("") && !vAdmin.txtEdadU.getText().equals("")
                        && !vAdmin.txtNombreU.getText().equals("") && !vAdmin.txtUsuario.getText().equals("")) {
                    if (vAdmin.txtRolU.getText().equals("1") || vAdmin.txtRolU.getText().equals("2") || vAdmin.txtRolU.getText().equals("3") || vAdmin.txtRolU.getText().equals("4")) {
                        this.actualizaDatos();
                        this.mostrar();

                    } else {
                        vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, Rol fuera de rango");
                    }
                } else {
                    vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, llene los campos solicitados");
                }
            } else {
                vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, Usuario con ID " + vAdmin.txtIdU.getText() + " no existe");
            }
        }

        //BOTÓN Eliminar
        if (e.getSource() == vAdmin.btnElimina) {
            if (!vAdmin.txtIdU.getText().equals("")) {
                if (!vAdmin.txtApellidoU.getText().equals("") && !vAdmin.txtEdadU.getText().equals("")
                        && !vAdmin.txtNombreU.getText().equals("") && !vAdmin.txtUsuario.getText().equals("")) {
                    if (vAdmin.txtRolU.getText().equals("1") || vAdmin.txtRolU.getText().equals("2") || vAdmin.txtRolU.getText().equals("3") || vAdmin.txtRolU.getText().equals("4")) {
                        this.eliminaU();
                        this.mostrar();

                    } else {
                        vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, Rol fuera de rango");
                    }
                } else {
                    vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, llene los campos solicitados");
                }
            } else {
                vAdmin.jopMensaje.showMessageDialog(vAdmin, "Error, Usuario con ID " + vAdmin.txtIdU.getText() + " no existe");
            }

        }
        
        //BOTON LIMPIAR 
        if(e.getSource() == vAdmin.btnMuestra){
            this.limpiar();
    
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
        this.limpiar();
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
        if (e.getClickCount() == 2) {
            this.setDatosU();
        }

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
