
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
import modelo.Utilidades;
import vista.FrmEliminaAutor;

public class ControladorEliminaAutor implements ActionListener, WindowListener, MouseListener{
    
    FrmEliminaAutor vElimA = new FrmEliminaAutor();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();

    public ControladorEliminaAutor(FrmEliminaAutor vElimA, AutorDAO adao, AutorVO avo) {
    this.adao = adao;
    this.avo = avo;
    this.vElimA = vElimA;
    
    this.vElimA.btnEliminar.addActionListener(this);
    this.vElimA.btnRegresar.addActionListener(this);
    this.vElimA.tblMostrar.addMouseListener(this);
    this.vElimA.addWindowListener(this);
    
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
    vElimA.tblMostrar.setModel(m);    
    }
    
    //Metodo para setear 
    public void setDatosAutor(){
    int numRow;
    numRow = vElimA.tblMostrar.getSelectedRow();
    vElimA.txtIdAutor.setText(String.valueOf(vElimA.tblMostrar.getValueAt(numRow, 0))); //Preguntar error
    vElimA.txtNombreA.setText(String.valueOf(vElimA.tblMostrar.getValueAt(numRow, 1)));
    vElimA.txtApellidoA.setText(String.valueOf(vElimA.tblMostrar.getValueAt(numRow, 2)));
    vElimA.txtNacionA.setText(String.valueOf(vElimA.tblMostrar.getValueAt(numRow, 3)));
    }
    
    public void eliminaAutor(){
        avo.setIdAutor(Integer.parseInt(vElimA.txtIdAutor.getText()));
        adao.eliminar(avo);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == vElimA.btnEliminar ){
           if(!vElimA.txtIdAutor.getText().equals("")){
           this.eliminaAutor();
           this.vElimA.jopMensaje.showMessageDialog(vElimA, "Datos eliminados correctamente");
           vElimA.txtIdAutor.setText("");
           vElimA.txtNombreA.setText("");
           vElimA.txtApellidoA.setText("");
           vElimA.txtNacionA.setText("");
           }else{
           this.vElimA.jopMensaje.showMessageDialog(vElimA, "Error, seleccione un dato a Eliminar");
           }
           
       }
       if(e.getSource() == vElimA.btnRegresar){
           vElimA.txtIdAutor.setText("");
           vElimA.txtNombreA.setText("");
           vElimA.txtApellidoA.setText("");
           vElimA.txtNacionA.setText("");
           vElimA.dispose();
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
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
        this.setDatosAutor();
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
