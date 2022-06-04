package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Extras;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;

public class ControladorActualizar implements ActionListener, WindowListener, MouseListener {

    FrmActualizar vAc = new FrmActualizar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorActualizar(FrmActualizar vAc, PaisVO pvo, PaisDAO pdao) {
    this.vAc = vAc;
    this.pdao = pdao;
    this.pvo = pvo;
    
    vAc.btnActualizar.addActionListener(this);
    vAc.addWindowListener(this);
    vAc.tblMostrar.addMouseListener(this);
    
    
    }
    
    
    private void datosActualizar() {
        DefaultTableModel m = new DefaultTableModel(){
         @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        m.setColumnCount(0); //Hace que la tabla esté vacía
        m.addColumn("Id del País"); // Emcabezado de la columna
        m.addColumn("Nombre del País");
        m.addColumn("Capital del País");
        m.addColumn("Población del País");

        //For each para recorrer el arreglo
        for (PaisVO pvo : pdao.consultar()) { //pvo se llena con todo lo que trae la consulta
            m.addRow(new Object[]{pvo.getIdPais(), pvo.getNombrePais(),
                pvo.getCapitalPais(), pvo.getPoblacionPais()}); //Object puede recibir cualquier valor
        }

        vAc.tblMostrar.setModel(m);
        TableColumn cCero = vAc.tblMostrar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        cCero.setMinWidth(75);

        TableColumn cUno = vAc.tblMostrar.getColumnModel().getColumn(1);
        cUno.setMaxWidth(110);
        cUno.setMinWidth(110);
    }
    
    //Este metodo rellena los txtField al darle doble click
    private void setDatosPais(){
    //Aplicación del getSelectedRosw();
    int numRow;
    numRow = vAc.tblMostrar.getSelectedRow();
    vAc.txtIdPais.setText(String.valueOf(vAc.tblMostrar.getValueAt(numRow, 0)));
    vAc.txtNombrePais.setText(String.valueOf(vAc.tblMostrar.getValueAt(numRow, 1)));
    vAc.txtCapitalPais.setText(String.valueOf(vAc.tblMostrar.getValueAt(numRow, 2)));
    vAc.txtPoblacionPais.setText(String.valueOf(vAc.tblMostrar.getValueAt(numRow, 3)));
    //Agregar la fecha de actualización
    pvo.setFechaActPais(Extras.fechaHoy());
    
    
    }
    
    private void actualizar(){
       //pvo este objeto va a actualizar los datos enviandolos a 
       pvo.setIdPais(Integer.parseInt(vAc.txtIdPais.getText()));
       pvo.setNombrePais(vAc.txtNombrePais.getText());
       pvo.setCapitalPais(vAc.txtCapitalPais.getText());
       pvo.setPoblacionPais(Long.parseLong(vAc.txtPoblacionPais.getText()));
       pvo.getFechaActPais();
       
       //Condición para actualizar los datos
       if(pdao.actualizar(pvo)== true){ // si es True quiere decir que el query se ejecutó correctamente
           vAc.jopMensaje.showMessageDialog(vAc, "Datos actualizados correctametne");
           vAc.txtIdPais.setText("");
           vAc.txtNombrePais.setText("");
           vAc.txtCapitalPais.setText("");
           vAc.txtPoblacionPais.setText("");
       }else{
           vAc.jopMensaje.showMessageDialog(vAc, "Error, Datos no actualizados");
           vAc.txtIdPais.setText("");
           vAc.txtNombrePais.setText("");
           vAc.txtCapitalPais.setText("");
           vAc.txtPoblacionPais.setText("");
       
       }
       
    
        
        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vAc.btnActualizar){
        if(!vAc.txtIdPais.getText().equals("")){
            this.actualizar();
            this.datosActualizar();
        }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.datosActualizar();
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
        this.datosActualizar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() == 2) {
           this.setDatosPais();
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
