package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import modelo.Extras;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmInsertar;

public class ControladorInsertar implements ActionListener {

    FrmInsertar vIn = new FrmInsertar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    //Unir la vista con la logica
    public ControladorInsertar(FrmInsertar vIn, PaisVO pvo, PaisDAO pdao) {
        this.vIn = vIn;
        this.pvo = pvo;
        this.pdao = pdao;

        vIn.btnRegistrarPais.addActionListener(this);
        vIn.btnCancelarRegistro.addActionListener(this);
    }

    private void registrarPais() {
        pvo.setNombrePais(vIn.txtNombrePais.getText());
        pvo.setCapitalPais(vIn.txtCapitalPais.getText());
        pvo.setPoblacionPais(Long.parseLong(vIn.txtPoblacionPais.getText()));
        pvo.setFechaIngPais(Extras.fechaHoy());
        if (pdao.insertar(pvo) == true) {
            vIn.jopMensaje.showMessageDialog(vIn, "Datos Registrados Correctamente");
            this.vIn.txtNombrePais.setText("");
            this.vIn.txtCapitalPais.setText("");
            this.vIn.txtPoblacionPais.setText("");
        } else {
            vIn.jopMensaje.showMessageDialog(vIn, "Error, Datos no registrados");
            this.vIn.txtNombrePais.setText("");
            this.vIn.txtCapitalPais.setText("");
            this.vIn.txtPoblacionPais.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vIn.btnRegistrarPais) {
            if (!this.vIn.txtNombrePais.getText().equals("")
                    && !this.vIn.txtCapitalPais.getText().equals("")
                    && !this.vIn.txtPoblacionPais.getText().equals("")) {
                this.registrarPais();
            }
            else{
                this.vIn.jopMensaje.showMessageDialog(vIn, "Debe llenar todos los campos");
            }
        }
        if (e.getSource() == vIn.btnCancelarRegistro) {
            vIn.dispose();
        }
    }

}
