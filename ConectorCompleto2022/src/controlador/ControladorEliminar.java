package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmEliminar;

public class ControladorEliminar implements ActionListener, WindowListener, MouseListener {

    FrmEliminar vEl = new FrmEliminar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorEliminar(FrmEliminar vEl, PaisVO pvo, PaisDAO pdao) {

        this.vEl = vEl;
        this.pvo = pvo;
        this.pdao = pdao;

        vEl.btnDelete.addActionListener(this);
        vEl.btnCancel.addActionListener(this);
        vEl.addWindowListener(this);
        vEl.tblEliminar.addMouseListener(this);
    }

    private void datosEliminar() {
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

        vEl.tblEliminar.setModel(m);
        TableColumn cCero = vEl.tblEliminar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        cCero.setMinWidth(75);

        TableColumn cUno = vEl.tblEliminar.getColumnModel().getColumn(1);
        cUno.setMaxWidth(110);
        cUno.setMinWidth(110);
    }
    
    private void setiD(){
    int numRow;
    numRow = vEl.tblEliminar.getSelectedRow();
    vEl.txtDeleteID.setText(String.valueOf(vEl.tblEliminar.getValueAt(numRow, 0)));
    
    }
    
    private void eliminar(){
    pvo.setIdPais(Integer.parseInt(vEl.txtDeleteID.getText()));
    pdao.eliminar(pvo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vEl.btnCancel) {
            vEl.dispose();
        }
        if(e.getSource() == vEl.btnDelete){
        if (!this.vEl.txtDeleteID.getText().equals("")
                  ) {
                this.eliminar();
                this.vEl.jopAviso.showMessageDialog(vEl, "Datos de ID "+this.vEl.txtDeleteID.getText()+" eliminados correctamente");
                
            }
        else{
            this.vEl.jopAviso.showMessageDialog(vEl, "Debe colocar un ID existente");
        }
            
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.datosEliminar();
        
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
        this.datosEliminar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            this.setiD();
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
