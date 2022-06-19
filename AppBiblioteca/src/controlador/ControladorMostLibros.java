
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmMostrarLibro;


/**
 *
 * @author LUIS
 */
public class ControladorMostLibros implements WindowListener, ActionListener {
    
    FrmMostrarLibro vMostL = new FrmMostrarLibro();
    LibroDAO ldao = new LibroDAO ();
    LibroVO lvo = new LibroVO();

    public ControladorMostLibros(FrmMostrarLibro vMostL, LibroDAO ldao, LibroVO lvo){
        this.ldao = ldao;
        this.lvo = lvo;
        this.vMostL = vMostL;
        
        this.vMostL.btnRegresar.addActionListener(this);
        this.vMostL.addWindowListener(this);
    }
    
    
    
    public void mostrar() {
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
        m.addColumn("No. Páginas");
        m.addColumn("Editorial");
        for (LibroVO lvo : ldao.consultarL()) {
            m.addRow(new Object[]{lvo.getIdIsbn(), lvo.getTituloLibro(), lvo.getAutorLibro(), lvo.getNoPaginas(), lvo.getEditoLibro()});
        }
        vMostL.tblMostrar.setModel(m);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vMostL.btnRegresar){
        this.vMostL.dispose();
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

   
    
}
