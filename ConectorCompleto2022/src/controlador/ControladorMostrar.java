package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmMostrar;

public class ControladorMostrar implements ActionListener, WindowListener {

    FrmMostrar vMo = new FrmMostrar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorMostrar(FrmMostrar vMo, PaisVO pvo, PaisDAO pdao) {

        this.vMo = vMo;
        this.pvo = pvo;
        this.pdao = pdao;

        vMo.btnCancelar.addActionListener(this);
        vMo.addWindowListener(this); //Para laventana, cuando se abra va a llenar los datos 
    }

    private void mostrar() { //Para hacer la estructura de la tabla
        DefaultTableModel m = new DefaultTableModel() {
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

        vMo.tblMostrar.setModel(m);
        TableColumn cCero = vMo.tblMostrar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        cCero.setMinWidth(75);

        TableColumn cUno = vMo.tblMostrar.getColumnModel().getColumn(1);
        cUno.setMaxWidth(110);
        cUno.setMinWidth(110);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vMo.btnCancelar) {
            vMo.dispose();
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
