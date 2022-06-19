
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
import vista.FrmActAutor;


public class ControladorActAutor implements ActionListener, WindowListener, MouseListener {

    FrmActAutor vAct = new FrmActAutor();
    AutorDAO adao = new AutorDAO();
    AutorVO avo = new AutorVO();

    public ControladorActAutor(FrmActAutor vAct, AutorVO avo, AutorDAO adao) {
        this.vAct = vAct;
        this.avo = avo;
        this.adao = adao;
        
        this.vAct.btnActualiza.addActionListener(this);
        this.vAct.btnCancela.addActionListener(this);
        this.vAct.tblMostrarAutor.addMouseListener(this);
        this.vAct.addWindowListener(this);
    }
    
    //Metodo para mostrar datos
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
    vAct.tblMostrarAutor.setModel(m);
    
    }
    
    //Metodo para setear 
    public void setDatosAutor(){
    int numRow;
    numRow = vAct.tblMostrarAutor.getSelectedRow();
    vAct.txtIdAutor.setText(String.valueOf(vAct.tblMostrarAutor.getValueAt(numRow, 0))); //Preguntar error
    vAct.txtActNombre.setText(String.valueOf(vAct.tblMostrarAutor.getValueAt(numRow, 1)));
    vAct.txtActApellido.setText(String.valueOf(vAct.tblMostrarAutor.getValueAt(numRow, 2)));
    vAct.txtActNacion.setText(String.valueOf(vAct.tblMostrarAutor.getValueAt(numRow, 3)));

    //Fecha de actualización, no se ve en la tabla, solo en la Base dedatos
    avo.setFechaActAutor(Utilidades.fechaActual());
    }
    //Método para actualizar
    public void actualizar(){
    avo.setIdAutor(Integer.parseInt(vAct.txtIdAutor.getText()));
    avo.setNombreAutor(vAct.txtActNombre.getText());
    avo.setApellidoAutor(vAct.txtActApellido.getText());
    avo.setNacionalidadAutor(vAct.txtActNacion.getText());
    avo.getFechaActAutor();
    
    //Condicionar
    if(adao.actualizar(avo) == true){
        vAct.jopMensaje.showMessageDialog(vAct, "Actualización correcta");
        vAct.txtIdAutor.setText("");
        vAct.txtActNombre.setText("");
        vAct.txtActApellido.setText("");
        vAct.txtActNacion.setText("");
    }else{
     vAct.jopMensaje.showMessageDialog(vAct, "Error, Datos no actualizados");
        vAct.txtIdAutor.setText("");
        vAct.txtActNombre.setText("");
        vAct.txtActApellido.setText("");
        vAct.txtActNacion.setText("");   
    }
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vAct.btnActualiza){
           if(!vAct.txtActNombre.getText().equals("") && !vAct.txtActApellido.getText().equals("") && !vAct.txtActNacion.getText().equals("") && !vAct.txtIdAutor.getText().equals("") ){
           this.actualizar();
           this.mostrar();
           }else{
           vAct.jopMensaje.showMessageDialog(vAct, "Error, llene todos los campos");
           }
        }
        if(e.getSource() == vAct.btnCancela){
        vAct.txtIdAutor.setText("");
        vAct.txtActNombre.setText("");
        vAct.txtActApellido.setText("");
        vAct.txtActNacion.setText("");
        vAct.dispose();
        }
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
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
