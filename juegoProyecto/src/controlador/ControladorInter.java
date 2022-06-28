package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.PreguntasDAO;
import modelo.PreguntasVO;
import modelo.RespuestaDAO;
import modelo.RespuestaVO;
import vista.FrmIntermedio;

public class ControladorInter implements ActionListener, WindowListener {

    FrmIntermedio vInter = new FrmIntermedio();
    PreguntasVO pvo = new PreguntasVO();
    PreguntasDAO pdao = new PreguntasDAO();
    RespuestaVO rvo = new RespuestaVO();
    RespuestaDAO rdao = new RespuestaDAO();
    int i = 0;

    public ControladorInter(FrmIntermedio vInter, PreguntasVO pvo, PreguntasDAO pdao, RespuestaVO rvo, RespuestaDAO rdao) {
        this.pdao = pdao;
        this.pvo = pvo;
        this.rdao = rdao;
        this.rvo = rvo;
        this.vInter = vInter;

        vInter.btnValida1.addActionListener(this);
        vInter.btnValida2.addActionListener(this);
        vInter.btnValida3.addActionListener(this);
        vInter.btnValida4.addActionListener(this);
        vInter.btnValida5.addActionListener(this);
        vInter.btnRegresa.addActionListener(this);
        vInter.addWindowListener(this);

    }
    
    public void habilitar() {
        vInter.jcbOpcion2.setEnabled(false);
        vInter.btnValida2.setEnabled(false);
        vInter.jcbOpcion3.setEnabled(false);
        vInter.btnValida3.setEnabled(false);
        vInter.jcbOpcion4.setEnabled(false);
        vInter.btnValida4.setEnabled(false);
        vInter.jcbOpcion5.setEnabled(false);
        vInter.btnValida5.setEnabled(false);

        vInter.btnNivel.setEnabled(false);

        //this.vPri.btnComprobar2.setEnabled(false);
    }

    public void llenarCombo() {
        //Seteando las respuestas         
        for (RespuestaVO revo : rdao.consultarR()) {
            System.out.println("Ingresó al for");

            vInter.jcbOpcion1.addItem(revo.getRespuesta());
            vInter.jcbOpcion2.addItem(revo.getRespuesta());
            vInter.jcbOpcion3.addItem(revo.getRespuesta());
            vInter.jcbOpcion4.addItem(revo.getRespuesta());
            vInter.jcbOpcion5.addItem(revo.getRespuesta());
        }
    }

    public void llenarPreguntas() {
        for (PreguntasVO prvo : pdao.consultar()) {
            int r1 = 5;

            if (5 == prvo.getIdPregunta()) {
                vInter.txtPregunta1.setText(prvo.getPregunta());
            }
            if (3 == prvo.getIdPregunta()) {
                vInter.txtPregunta2.setText(prvo.getPregunta());
            }
            if (2 == prvo.getIdPregunta()) {
                vInter.txtPregunta3.setText(prvo.getPregunta());
            }
            if (4 == prvo.getIdPregunta()) {
                vInter.txtPregunta4.setText(prvo.getPregunta());
            }
            if (6 == prvo.getIdPregunta()) {
                vInter.txtPregunta5.setText(prvo.getPregunta());
            }
        }

    }

    public void validar1() {
        if (vInter.jcbOpcion1.getSelectedIndex() == 4) {
            System.out.println("Opción Correcta");
            i = 20;
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta correcta, Total " + i + " puntos");
            vInter.jcbOpcion2.setEnabled(true);
            vInter.btnValida2.setEnabled(true);
            vInter.jcbOpcion1.setEnabled(false);
            vInter.btnValida1.setEnabled(false);
        } else {
            System.out.println("Incorrecto");
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta incorrecta");
        }
    }
    
    public void validar2() {
        if (vInter.jcbOpcion2.getSelectedIndex() == 2) {
            System.out.println("Opción Correcta");
            i = 40;
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta correcta, Total " + i + " puntos");
            vInter.jcbOpcion3.setEnabled(true);
            vInter.btnValida3.setEnabled(true);
            vInter.jcbOpcion2.setEnabled(false);
            vInter.btnValida2.setEnabled(false);
        } else {
            System.out.println("Incorrecto");
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta incorrecta");
        }
    }
    
    public void validar3() {
        if (vInter.jcbOpcion3.getSelectedIndex() == 1) {
            System.out.println("Opción Correcta");
            i = 60;
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta correcta, Total " + i + " puntos");
            vInter.jcbOpcion4.setEnabled(true);
            vInter.btnValida4.setEnabled(true);
            vInter.jcbOpcion3.setEnabled(false);
            vInter.btnValida3.setEnabled(false);
        } else {
            System.out.println("Incorrecto");
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta incorrecta");
        }
    }
    
    public void validar4() {
        if (vInter.jcbOpcion4.getSelectedIndex() == 3) {
            System.out.println("Opción Correcta");
            i = 80;
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta correcta, Total " + i + " puntos");
            vInter.jcbOpcion5.setEnabled(true);
            vInter.btnValida5.setEnabled(true);
            vInter.jcbOpcion4.setEnabled(false);
            vInter.btnValida4.setEnabled(false);
        } else {
            System.out.println("Incorrecto");
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta incorrecta");
        }
    }
    
    public void validar5() {
        if (vInter.jcbOpcion5.getSelectedIndex() == 5) {
            System.out.println("Opción Correcta");
            i = 100;
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta correcta, Total " + i + " puntos");
            
            vInter.jcbOpcion5.setEnabled(false);
            vInter.btnValida5.setEnabled(false);
        } else {
            System.out.println("Incorrecto");
            vInter.jopMensaje.showMessageDialog(vInter, "Respuesta incorrecta");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vInter.btnValida1) {
            if (vInter.jcbOpcion1.getSelectedIndex() != 0) {
                this.validar1();
            }
            else{
            vInter.jopMensaje.showMessageDialog(vInter, "Debe elegir alguna respuesta");
            }
        }
        if (e.getSource() == vInter.btnValida2) {
            if (vInter.jcbOpcion2.getSelectedIndex() != 0) {
                this.validar2();
            }
            else{
            vInter.jopMensaje.showMessageDialog(vInter, "Debe elegir alguna respuesta");
            }
        }
        if (e.getSource() == vInter.btnValida3) {
            if (vInter.jcbOpcion3.getSelectedIndex() != 0) {
                this.validar3();
            }
            else{
            vInter.jopMensaje.showMessageDialog(vInter, "Debe elegir alguna respuesta");
            }
        }
        if (e.getSource() == vInter.btnValida4) {
            if (vInter.jcbOpcion4.getSelectedIndex() != 0) {
                this.validar4();
            }
            else{
            vInter.jopMensaje.showMessageDialog(vInter, "Debe elegir alguna respuesta");
            }
        }
        if (e.getSource() == vInter.btnValida5) {
            if (vInter.jcbOpcion5.getSelectedIndex() != 0) {
                this.validar5();
                this.vInter.btnNivel.setEnabled(true);
            }
            else{
            vInter.jopMensaje.showMessageDialog(vInter, "Debe elegir alguna respuesta");
            }
        }
        if (e.getSource() == vInter.btnRegresa){
            this.vInter.jopMensaje.showMessageDialog(vInter, "Gracias por participar, Total "+i+" puntos");
            vInter.jcbOpcion1.setEnabled(true);
            vInter.btnValida1.setEnabled(true);
           
            
            this.habilitar();
            this.vInter.dispose();
        }
    
    
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.llenarCombo();
        this.llenarPreguntas();
        this.habilitar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
       
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
         i =0;
        this.llenarCombo();
        
       
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.llenarCombo();
        this.llenarPreguntas();

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
