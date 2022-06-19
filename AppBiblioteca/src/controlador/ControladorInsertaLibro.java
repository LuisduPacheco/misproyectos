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
import vista.FrmInsertaLibro;

public class ControladorInsertaLibro implements ActionListener, WindowListener, MouseListener {

    FrmInsertaLibro vInL = new FrmInsertaLibro();
    LibroDAO ldao = new LibroDAO();
    LibroVO lvo = new LibroVO();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();

    public ControladorInsertaLibro(FrmInsertaLibro vInL, LibroDAO ldao, LibroVO lvo, AutorVO avo, AutorDAO adao) {
        this.vInL = vInL;
        this.ldao = ldao;
        this.lvo = lvo;
        this.avo = avo;
        this.adao = adao;

        this.vInL.btnCancelar.addActionListener(this);
        this.vInL.btnRegistrar.addActionListener(this);
        this.vInL.tblMostarAutores.addMouseListener(this);
        this.vInL.addWindowListener(this);

    }

    public void mostrar() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id Autor");
        m.addColumn("Nombre del autor");
        m.addColumn("Apellido del Autor");

        for (AutorVO avo : adao.consultar()) {
            m.addRow(new Object[]{avo.getIdAutor(), avo.getNombreAutor(), avo.getApellidoAutor()});
        }
        vInL.tblMostarAutores.setModel(m);
    }

    public void setDatosLibro() {
        int numRow;
        numRow = vInL.tblMostarAutores.getSelectedRow();
        vInL.txtAutorId.setText(String.valueOf(vInL.tblMostarAutores.getValueAt(numRow, 0)));
        vInL.txtAutorNombre.setText(String.valueOf(vInL.tblMostarAutores.getValueAt(numRow, 1) + " " + vInL.tblMostarAutores.getValueAt(numRow, 2)));

    }

    private void insertaLibro() {
        this.lvo.setTituloLibro(this.vInL.txtTitulo.getText());
        this.lvo.setNoPaginas(this.vInL.txtPaginas.getText());
        this.lvo.setAutorLibro(this.vInL.txtAutorNombre.getText());
        this.lvo.setIdAutorFk(Integer.parseInt(this.vInL.txtAutorId.getText()));
        this.lvo.setEditoLibro(this.vInL.txtEditorial.getText());
        this.lvo.setFechaInLibro(Utilidades.fechaActual());

        if (ldao.insertarL(lvo) == true) {
            vInL.jopMensaje.showMessageDialog(vInL, "Datos registrados correctamente");
            this.vInL.txtTitulo.setText("");
            this.vInL.txtPaginas.setText("");
            this.vInL.txtAutorNombre.setText("");
            this.vInL.txtAutorId.setText("");
            this.vInL.txtEditorial.setText("");
        } else {
            vInL.jopMensaje.showMessageDialog(vInL, "Error, datos no registrados");
            this.vInL.txtTitulo.setText("");
            this.vInL.txtPaginas.setText("");
            this.vInL.txtAutorNombre.setText("");
            this.vInL.txtAutorId.setText("");
            this.vInL.txtEditorial.setText("");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vInL.btnRegistrar) {
            if (!vInL.txtAutorId.getText().equals("") && !vInL.txtTitulo.getText().equals("") && !vInL.txtPaginas.getText().equals("")
                    && !vInL.txtEditorial.getText().equals("")) {
                //if (Integer.parseInt(vInL.txtPaginas.getText()) > 0 && Integer.parseInt(vInL.txtPaginas.getText()) <= 10000 ) {}
                this.insertaLibro();

            } else {
                if (vInL.txtAutorId.getText().equals("")) {
                    vInL.jopMensaje.showMessageDialog(vInL, "Debe seleccionar un autor registrado");
                } else {

                    vInL.jopMensaje.showMessageDialog(vInL, "Error revise los campos");
                }
            }

        }

        if (e.getSource() == vInL.btnCancelar) {
            vInL.txtAutorId.setText("");
            vInL.txtAutorNombre.setText("");
            vInL.txtTitulo.setText("");
            vInL.txtPaginas.setText("");
            vInL.txtEditorial.setText("");
            this.vInL.dispose();

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
    public void windowClosed(WindowEvent e
    ) {
    }

    @Override
    public void windowIconified(WindowEvent e
    ) {
    }

    @Override
    public void windowDeiconified(WindowEvent e
    ) {
    }

    @Override
    public void windowActivated(WindowEvent e
    ) {
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e
    ) {
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {
        if (e.getClickCount() == 2) {
            this.setDatosLibro();
        }

    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }

}
