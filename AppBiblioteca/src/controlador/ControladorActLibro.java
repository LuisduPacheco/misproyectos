package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.LibroDAO;
import modelo.LibroVO;
import modelo.Utilidades;
import vista.FrmActLibro;

public class ControladorActLibro implements ActionListener, WindowListener, MouseListener {

    FrmActLibro vActL = new FrmActLibro();
    LibroDAO ldao = new LibroDAO();
    LibroVO lvo = new LibroVO();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();

    public ControladorActLibro(FrmActLibro vActL, LibroDAO ldao, LibroVO lvo, AutorDAO adao, AutorVO avo) {
        this.vActL = vActL;
        this.lvo = lvo;
        this.ldao = ldao;
        this.adao = adao;
        this.avo = avo;

        this.vActL.addWindowListener(this);
        this.vActL.btnActualiza.addActionListener(this);
        this.vActL.btnCancela.addActionListener(this);
        // this.vActL.tblMostrarA.addMouseListener(this);
        this.vActL.tblMostrarL.addMouseListener(this);
    }

    public void mostrarL() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("ISBN");
        m.addColumn("Titulo");
        m.addColumn("No. Páginas");
        m.addColumn("Editorial");
        for (LibroVO lvo : ldao.consultarL()) {
            m.addRow(new Object[]{lvo.getIdIsbn(), lvo.getTituloLibro(), lvo.getNoPaginas(), lvo.getEditoLibro()});
        }
        vActL.tblMostrarL.setModel(m);

    }

//    public void mostrarA() {
//        DefaultTableModel m = new DefaultTableModel() {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//
//        };
//        m.setColumnCount(0);
//        m.addColumn("Id Autor");
//        m.addColumn("Nombre");
//        m.addColumn("Apellido");
//
//        for (AutorVO avo : adao.consultar()) {
//            m.addRow(new Object[]{avo.getIdAutor(), avo.getNombreAutor(), avo.getApellidoAutor()});
//        }
//        vActL.tblMostrarA.setModel(m);
//
//    }
    public void setDatosL() {
        int numRowL;
        numRowL = vActL.tblMostrarL.getSelectedRow();
        vActL.txtActIsbn.setText(String.valueOf(vActL.tblMostrarL.getValueAt(numRowL, 0)));
        vActL.txtActTitulo.setText(String.valueOf(vActL.tblMostrarL.getValueAt(numRowL, 1)));
        vActL.txtActPag.setText(String.valueOf(vActL.tblMostrarL.getValueAt(numRowL, 2)));
        vActL.txtActEdito.setText(String.valueOf(vActL.tblMostrarL.getValueAt(numRowL, 3)));
        
        lvo.setFechaActLibro(Utilidades.fechaActual());
        //avo.setFechaActAutor(Utilidades.fechaActual());
    }

//    public void setDatosA() {
//        int numRowA;
//        numRowA = vActL.tblMostrarA.getSelectedRow();
//        vActL.txtActId.setText(String.valueOf(vActL.tblMostrarA.getValueAt(numRowA, 0)));
//        vActL.txtActAut.setText(String.valueOf(vActL.tblMostrarA.getValueAt(numRowA, 1)));
//    }
    public void actualizaL() {
        lvo.setIdIsbn(Integer.parseInt(vActL.txtActIsbn.getText()));
        lvo.setEditoLibro(vActL.txtActEdito.getText());
        lvo.setNoPaginas((vActL.txtActPag.getText()));
        lvo.setTituloLibro(vActL.txtActTitulo.getText());
        lvo.getFechaActLibro();
        ldao.actualizaL(lvo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vActL.btnActualiza) {
            if (!vActL.txtActIsbn.getText().equals("")) {
                this.actualizaL();
                this.mostrarL();
                this.vActL.txtActIsbn.setText("");
                this.vActL.txtActEdito.setText("");
                this.vActL.txtActPag.setText("");
                this.vActL.txtActTitulo.setText("");
                this.vActL.jopMensaje.showMessageDialog(vActL, "Datos actualizados con éxito");
            }else{
                this.vActL.jopMensaje.showMessageDialog(vActL, "Error, revise los campos");
            }
            
            
        }if(e.getSource() == vActL.btnCancela){
            this.vActL.dispose();
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

        this.mostrarL();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.vActL.txtActIsbn.setText("");
        this.vActL.txtActEdito.setText("");
        this.vActL.txtActPag.setText("");
        this.vActL.txtActTitulo.setText("");
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {

        this.mostrarL();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2) {
            this.setDatosL();
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
