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
import vista.FrmEliminaLibro;

public class ControladorElimiinaLibro implements ActionListener, MouseListener, WindowListener {

    FrmEliminaLibro vElimL = new FrmEliminaLibro();
    LibroDAO ldao = new LibroDAO();
    LibroVO lvo = new LibroVO();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();

    public ControladorElimiinaLibro(FrmEliminaLibro vElimL, LibroDAO ldao, LibroVO lvo, AutorDAO adao, AutorVO avo) {

        this.vElimL = vElimL;
        this.ldao = ldao;
        this.lvo = lvo;
        this.adao = adao;
        this.avo = avo;

        vElimL.btnEliminaL.addActionListener(this);
        vElimL.btnRegresaL.addActionListener(this);
        vElimL.addWindowListener(this);
        vElimL.tblMostrar.addMouseListener(this);

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
        m.addColumn("Autor");
        m.addColumn("ID autor");

        for (LibroVO lvo : ldao.consultarL()) {
            m.addRow(new Object[]{lvo.getIdIsbn(), lvo.getTituloLibro(), lvo.getAutorLibro(), lvo.getIdAutorFk()});
        }
        vElimL.tblMostrar.setModel(m);
    }

    public void setDatos() {

        int numRow;

        numRow = vElimL.tblMostrar.getSelectedRow();
        vElimL.txtIsbn.setText(String.valueOf(vElimL.tblMostrar.getValueAt(numRow, 0)));
        vElimL.txtTituloL.setText(String.valueOf(vElimL.tblMostrar.getValueAt(numRow, 1)));
        vElimL.txtAutorL.setText(String.valueOf(vElimL.tblMostrar.getValueAt(numRow, 2)));
        vElimL.txtIdLibro.setText(String.valueOf(vElimL.tblMostrar.getValueAt(numRow, 3)));
    }

    public void eliminaL() {
        lvo.setIdIsbn(Integer.parseInt(vElimL.txtIsbn.getText()));
        ldao.eliminaL(lvo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vElimL.btnEliminaL){
            if(!vElimL.txtIsbn.getText().equals("")){
                this.eliminaL();
                vElimL.jopMensaje.showMessageDialog(vElimL, "Libro "+vElimL.txtTituloL.getText()+" eliminado con éxito");
                vElimL.txtIsbn.setText("");
                vElimL.txtTituloL.setText("");
                vElimL.txtIdLibro.setText("");
                vElimL.txtAutorL.setText("");
                
            }else{
            vElimL.jopMensaje.showMessageDialog(vElimL, "Error Revise los campos");
            }
        }if(e.getSource() == vElimL.btnRegresaL){
            this.vElimL.dispose();
        }
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    if(e.getClickCount() == 2){
        this.setDatos();
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

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrarL();
    }

    @Override
    public void windowClosing(WindowEvent e) {
                

    }

    @Override
    public void windowClosed(WindowEvent e) {
                vElimL.txtIsbn.setText("");
                vElimL.txtTituloL.setText("");
                vElimL.txtIdLibro.setText("");
                vElimL.txtAutorL.setText("");
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

}
