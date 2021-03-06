package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.Avanzado;
import vista.FrmAvanzado;

public class ControladorAvan implements ActionListener, WindowListener {

    FrmAvanzado vAvan = new FrmAvanzado();
    Avanzado avan = new Avanzado();

    public ControladorAvan(FrmAvanzado vAvan, Avanzado avan) {
        this.avan = avan;
        this.vAvan = vAvan;

        vAvan.btnNivel.addActionListener(this);
        vAvan.btnRegresa.addActionListener(this);
        vAvan.btnInicio.addActionListener(this);
        vAvan.btnValida1.addActionListener(this);
        vAvan.btnValida2.addActionListener(this);
        vAvan.btnValida3.addActionListener(this);
        vAvan.btnValidaN.addActionListener(this);

        vAvan.addWindowListener(this);

    }

    public void numeroRandom() {
        int numero = (int) (Math.random() * 15);
        System.out.println("numero " + numero);
        avan.setN1(numero);
        vAvan.jopMensaje.showMessageDialog(vAvan, "Se ha generado un número entre 0 y 15.¡Intenta adivinarlo!");
    }

    public void validarNumero() {

        if (avan.getN1() == Integer.parseInt(vAvan.txtNumero.getText())) {
            vAvan.jopMensaje.showMessageDialog(vAvan, "Correcto el número es " + this.avan.getN1());
            vAvan.btnValidaN.setEnabled(false);
            vAvan.txtNumero.setEditable(false);
            vAvan.btnValida1.setEnabled(true);
            vAvan.txtTrad1.setEditable(true);
        } else {
            avan.setI(avan.getI() + 1);
            vAvan.jopMensaje.showMessageDialog(vAvan, "Error. Intento No. " + avan.getI());
            vAvan.txtNumero.setText("");
        }

        if (avan.getI() == 3) {
            this.vAvan.jopMensaje.showMessageDialog(vAvan, "Llegaste a los " + avan.getI() + " intentos, fin del juego");
            vAvan.dispose();
        }
    }

    public void habilitar() {
        vAvan.btnNivel.setEnabled(false);
        vAvan.btnValida1.setEnabled(false);
        vAvan.btnValida2.setEnabled(false);
        vAvan.btnValida3.setEnabled(false);
        vAvan.btnValidaN.setEnabled(false);
        vAvan.txtNumero.setEditable(false);
        vAvan.txtTrad1.setEditable(false);
        vAvan.txtTrad2.setEditable(false);
        vAvan.txtTrad3.setEditable(false);

        vAvan.txtNumero.setText("");
        vAvan.txtTrad1.setText("");
        vAvan.txtTrad2.setText("");
        vAvan.txtTrad3.setText("");
    }

    public void setPalabras() {
        vAvan.lblPalabra1.setText("Hello");
        vAvan.lblPalabra2.setText("Mundo");
        vAvan.lblPalabra3.setText("Keyboard");
    }

    public void traducir1() {
        if (vAvan.txtTrad1.getText().equalsIgnoreCase(avan.getPalabra1())) {
            vAvan.jopMensaje.showMessageDialog(vAvan, "Correcto la tradución es: " + avan.getPalabra1());
            vAvan.btnValida1.setEnabled(false);
            vAvan.txtTrad1.setEditable(false);
            vAvan.btnValida2.setEnabled(true);
            vAvan.txtTrad2.setEditable(true);           
        } else {
            vAvan.jopMensaje.showMessageDialog(vAvan, "Error, traducción incorrecta");
            vAvan.txtTrad1.setText("");
        }
    }
    
    public void traducir2(){
        if (vAvan.txtTrad2.getText().equalsIgnoreCase(avan.getPalabra2())) {
            vAvan.jopMensaje.showMessageDialog(vAvan, "Correcto la tradución es: " + avan.getPalabra2());
            vAvan.btnValida2.setEnabled(false);
            vAvan.txtTrad2.setEditable(false);
            vAvan.btnValida3.setEnabled(true);
            vAvan.txtTrad3.setEditable(true);           
        } else {
            vAvan.jopMensaje.showMessageDialog(vAvan, "Error, traducción incorrecta");
            vAvan.txtTrad2.setText("");
        }
    }
    
    public void traducir3(){
        if (vAvan.txtTrad3.getText().equalsIgnoreCase(avan.getPalabra3())) {
            vAvan.jopMensaje.showMessageDialog(vAvan, "Correcto la tradución es: " + avan.getPalabra3());
            vAvan.btnValida3.setEnabled(false);
            vAvan.txtTrad3.setEditable(false);
            vAvan.jopMensaje.showMessageDialog(vAvan, "Felicidades, completaste el nivel avanzado");
            vAvan.btnNivel.setEnabled(true);
        } else {
            vAvan.jopMensaje.showMessageDialog(vAvan, "Error, traducción incorrecta");
            vAvan.txtTrad2.setText("");
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vAvan.btnInicio) {
            this.numeroRandom();
            this.vAvan.btnInicio.setEnabled(false);
            vAvan.btnValidaN.setEnabled(true);
            vAvan.txtNumero.setEditable(true);
        }
        if (e.getSource() == vAvan.btnValidaN) {
            this.validarNumero();
            this.setPalabras();
        }
        if (e.getSource() == vAvan.btnValida1) {
            this.traducir1();
        }
        if (e.getSource() == vAvan.btnValida2) {
            this.traducir2();
        }
        if (e.getSource() == vAvan.btnValida3) {
            this.traducir3();
        }
        if (e.getSource() == vAvan.btnRegresa){
            vAvan.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //- vAvan.btnInicio.setEnabled(true);
        this.habilitar();

    }

    @Override
    public void windowClosing(WindowEvent e) {
        //vAvan.btnInicio.setEnabled(true);

    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.habilitar();
        vAvan.btnInicio.setEnabled(true);
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
}
