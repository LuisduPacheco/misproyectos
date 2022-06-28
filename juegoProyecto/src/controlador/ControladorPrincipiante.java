package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import modelo.Principiante;
import vista.FrmLogin;
//import vista.FrmMenu;
import vista.FrmPrincipiante;

public class ControladorPrincipiante implements ActionListener, WindowListener {

    FrmLogin vLog = new FrmLogin();
    Principiante pri = new Principiante();
    FrmPrincipiante vPri = new FrmPrincipiante();

    public ControladorPrincipiante(FrmPrincipiante vPri, FrmLogin vLog, Principiante pri) {
        this.vLog = vLog;
        this.pri = pri;
        this.vPri = vPri;

        vPri.btnComprobar1.addActionListener(this);
        vPri.btnComprobar2.addActionListener(this);
        vPri.btnComprobar3.addActionListener(this);
        vPri.btnComprobar4.addActionListener(this);
        vPri.btnComprobar5.addActionListener(this);
        vPri.btnComprobar6.addActionListener(this);
        vPri.btnFinaliza.addActionListener(this);
        vPri.btnRegresa.addActionListener(this);
        this.vPri.addWindowListener(this);

    }

    public int resta() {
        pri.setN1((int) (Math.random() * 10));
        pri.setN2((int) (Math.random() * 10));
        this.vPri.lblNum1.setText(String.valueOf((pri.getN1())));
        this.vPri.lblNum2.setText(String.valueOf((pri.getN2())));
        this.pri.resta();
        return this.pri.getI();
    }

    public int resta2() {
        pri.setN1((int) (Math.random() * 10));
        pri.setN2((int) (Math.random() * 10));
        this.vPri.lblNum3.setText(String.valueOf((pri.getN1())));
        this.vPri.lblNum4.setText(String.valueOf((pri.getN2())));
        this.pri.resta();
        this.pri.setI(15);
        return pri.getI();
    }

    public int suma() {
        pri.setN1((int) (Math.random() * 10));
        pri.setN2((int) (Math.random() * 10));
        this.vPri.lblNum5.setText(String.valueOf((pri.getN1())));
        this.vPri.lblNum6.setText(String.valueOf((pri.getN2())));
        this.pri.suma();
        this.pri.setI(30);
        return pri.getI();
    }

    public int suma2() {
        pri.setN1((int) (Math.random() * 10));
        pri.setN2((int) (Math.random() * 10));
        this.vPri.lblNum7.setText(String.valueOf((pri.getN1())));
        this.vPri.lblNum8.setText(String.valueOf((pri.getN2())));
        this.pri.suma();
        this.pri.setI(45);
        return pri.getI();
    }

    public int multiplicacion() {
        pri.setN1((int) (Math.random() * 10));
        pri.setN2((int) (Math.random() * 10));
        this.vPri.lblNum9.setText(String.valueOf((pri.getN1())));
        this.vPri.lblNum10.setText(String.valueOf((pri.getN2())));
        this.pri.multiplicacion();
        this.pri.setI(60);
        return pri.getI();
    }

    public int division() {
        pri.setN1((int) (Math.random() * 10));
        pri.setN2((int) (Math.random() * 10));
        this.vPri.lblNum11.setText(String.valueOf((pri.getN1())));
        this.vPri.lblNum12.setText(String.valueOf((pri.getN2())));
        this.pri.division();
        this.pri.setI(80);
        return pri.getI();
    }

    public void habilitar() {
        this.vPri.txtResultado2.setEditable(false);
        this.vPri.btnComprobar2.setEnabled(false);
        this.vPri.txtResultado3.setEditable(false);
        this.vPri.btnComprobar3.setEnabled(false);
        this.vPri.txtResultado4.setEditable(false);
        this.vPri.btnComprobar4.setEnabled(false);
        this.vPri.txtResultado5.setEditable(false);
        this.vPri.btnComprobar5.setEnabled(false);
        this.vPri.txtResultado6.setEditable(false);
        this.vPri.btnComprobar6.setEnabled(false);
        this.vPri.btnFinaliza.setEnabled(false);
    }

    public void operaciones() {
        if (pri.getI() == 0) {
            this.resta();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vPri.btnComprobar1) {
            if (!vPri.txtResultado1.getText().equals("")) {
                if (pri.resta() == Integer.parseInt(vPri.txtResultado1.getText())) {
                    this.vPri.jopMensaje.showMessageDialog(vPri, "Correcto, resultado: " + pri.resta());
                    this.vPri.txtResultado2.setEditable(true);
                    this.vPri.btnComprobar2.setEnabled(true);
                    this.vPri.txtResultado1.setEditable(false);
                    this.vPri.btnComprobar1.setEnabled(false);
                    this.resta2();
                } else {
                    vPri.jopMensaje.showMessageDialog(vPri, "Resultado incorrecto");
                }
            } else {
                vPri.jopMensaje.showMessageDialog(vPri, "Resultado vacío");
            }

        }

        if (e.getSource() == vPri.btnComprobar2) {
            if (!vPri.txtResultado2.getText().equals("")) {
                if (pri.resta() == Integer.parseInt(vPri.txtResultado2.getText())) {
                    this.vPri.jopMensaje.showMessageDialog(vPri, "Correcto, resultado: " + pri.resta());
                    this.vPri.txtResultado3.setEditable(true);
                    this.vPri.btnComprobar3.setEnabled(true);
                    this.vPri.txtResultado2.setEditable(false);
                    this.vPri.btnComprobar2.setEnabled(false);
                    this.suma();
                } else {
                    vPri.jopMensaje.showMessageDialog(vPri, "Resultado incorrecto");
                }
            } else {
                vPri.jopMensaje.showMessageDialog(vPri, "Resultado vacío");
            }
        }
        if (e.getSource() == vPri.btnComprobar3) {
            if (!vPri.txtResultado3.getText().equals("")) {
                if (pri.suma() == Integer.parseInt(vPri.txtResultado3.getText())) {
                    this.vPri.jopMensaje.showMessageDialog(vPri, "Correcto, resultado: " + pri.suma());
                    this.vPri.txtResultado4.setEditable(true);
                    this.vPri.btnComprobar4.setEnabled(true);
                    this.vPri.txtResultado3.setEditable(false);
                    this.vPri.btnComprobar3.setEnabled(false);
                    this.suma2();
                } else {
                    vPri.jopMensaje.showMessageDialog(vPri, "Resultado incorrecto");
                }
            } else {
                vPri.jopMensaje.showMessageDialog(vPri, "Resultado vacío");
            }
        }

        if (e.getSource() == vPri.btnComprobar4) {
            if (!vPri.txtResultado4.getText().equals("")) {
                if (pri.suma() == Integer.parseInt(vPri.txtResultado4.getText())) {
                    this.vPri.jopMensaje.showMessageDialog(vPri, "Correcto, resultado: " + pri.suma());
                    this.vPri.txtResultado4.setEditable(false);
                    this.vPri.btnComprobar4.setEnabled(false);
                    this.vPri.txtResultado5.setEditable(true);
                    this.vPri.btnComprobar5.setEnabled(true);
                    this.multiplicacion();
                } else {
                    vPri.jopMensaje.showMessageDialog(vPri, "Resultado incorrecto");
                }
            } else {
                vPri.jopMensaje.showMessageDialog(vPri, "Resultado vacío");
            }
        }
        if (e.getSource() == vPri.btnComprobar5) {
            if (!vPri.txtResultado5.getText().equals("")) {
                if (pri.multiplicacion() == Integer.parseInt(vPri.txtResultado5.getText())) {
                    this.vPri.jopMensaje.showMessageDialog(vPri, "Correcto, resultado: " + pri.multiplicacion());
                    this.vPri.txtResultado6.setEditable(true);
                    this.vPri.btnComprobar6.setEnabled(true);
                    this.vPri.txtResultado5.setEditable(false);
                    this.vPri.btnComprobar5.setEnabled(false);
                    this.division();
                } else {
                    vPri.jopMensaje.showMessageDialog(vPri, "Resultado incorrecto");
                }
            } else {
                vPri.jopMensaje.showMessageDialog(vPri, "Resultado vacío");
            }
        }

        if (e.getSource() == vPri.btnComprobar6) {
            if (!vPri.txtResultado6.getText().equals("")) {
                if (pri.division() == Integer.parseInt(vPri.txtResultado6.getText())) {
                    this.vPri.jopMensaje.showMessageDialog(vPri, "Correcto, resultado: "+ pri.division());
                    this.pri.setI(100);
                    this.vPri.jopMensaje.showMessageDialog(vPri, "Felicidades, completaste el juego "+
                                                                  "Puntaje: "+this.pri.getI());
                    this.vPri.txtResultado6.setEditable(false);
                    this.vPri.btnComprobar6.setEnabled(false);
                    this.vPri.btnFinaliza.setEnabled(true);
                    
                   
                } else {
                    vPri.jopMensaje.showMessageDialog(vPri, "Resultado incorrecto");
                }
            } else {
                vPri.jopMensaje.showMessageDialog(vPri, "Resultado vacío");
            }
        }

        if (e.getSource() == vPri.btnRegresa) {
            JOptionPane.showMessageDialog(vPri, "Gracias por participar, puntaje: " + pri.getI());
            this.vPri.dispose();            
        }
        if(e.getSource() == vPri.btnFinaliza){
            this.vPri.jopMensaje.showMessageDialog(vPri, "Solicite al Administrador el cambio de nivel");
        }
    }

    @Override
    public void windowOpened(WindowEvent e
    ) {
        this.resta();
        this.habilitar();
    }

    @Override
    public void windowClosing(WindowEvent e
    ) {
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

    }

    @Override
    public void windowDeactivated(WindowEvent e
    ) {
    }

}
