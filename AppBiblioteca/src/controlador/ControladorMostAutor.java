
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.AutorDAO;
import modelo.AutorVO;
import vista.FrmMostrarAutor;

public class ControladorMostAutor implements WindowListener, ActionListener {

    FrmMostrarAutor vMostA = new FrmMostrarAutor();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();

    public ControladorMostAutor(FrmMostrarAutor vMostA, AutorDAO adao, AutorVO avo) {
    this.adao = adao;
    this.avo = avo;
    this.vMostA = vMostA;
    
    this.vMostA.btnRegresar.addActionListener(this);
    this.vMostA.addWindowListener(this);
    }
    public void mostrar(){
        DefaultTableModel m = new DefaultTableModel(){
        @Override 
        public boolean isCellEditable(int row, int column){
            return false;
        }
    
    };
    m.setColumnCount(0);
    m.addColumn("Id Autor");
    m.addColumn("Nombre del autor");
    m.addColumn("Apellido del Autor");
    m.addColumn("Nacionalidad del autor");
    
    for (AutorVO avo: adao.consultar()){
    m.addRow(new Object[]{avo.getIdAutor(), avo.getNombreAutor(), avo.getApellidoAutor(),
                avo.getNacionalidadAutor()});
    }
     vMostA.tblMostrar.setModel(m);
    
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
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == vMostA.btnRegresar){
        vMostA.dispose();
    }
    }
    
}
