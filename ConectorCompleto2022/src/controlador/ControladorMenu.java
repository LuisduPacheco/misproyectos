package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInsertar;
import vista.FrmMenu;
import vista.FrmMostrar;

/**
 *
 * @author LUIS
 */
public class ControladorMenu implements ActionListener {

    FrmMenu vMe = new FrmMenu();
    FrmInsertar vIn = new FrmInsertar();
    FrmMostrar vMo = new FrmMostrar();
    FrmEliminar vEl = new FrmEliminar();
    FrmActualizar vAc = new FrmActualizar();
   
    public ControladorMenu(FrmMenu vMe, FrmInsertar vIn, FrmMostrar vMo, FrmEliminar vEl, FrmActualizar vAc) {
        this.vMe = vMe;
        this.vIn = vIn;
        this.vMo = vMo;
        this.vEl = vEl;
        this.vAc = vAc;
        
        this.vMe.btnInsertar.addActionListener(this);
        this.vMe.btnMostrar.addActionListener(this);
        this.vMe.btnEliminar.addActionListener(this);
        this.vMe.btnActualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vMe.btnInsertar) {
            this.vIn.setVisible(true);
            this.vIn.setLocationRelativeTo(vMe);
            this.vIn.setResizable(false);
        }
        if (e.getSource() == this.vMe.btnMostrar) {
            this.vMo.setVisible(true);
            this.vMo.setLocationRelativeTo(vMe);
            this.vMo.setResizable(false);
        }
        if(e.getSource() == this.vMe.btnEliminar){
            this.vEl.setVisible(true);
            this.vEl.setLocationRelativeTo(vMe);
            this.vEl.setResizable(false);
        }
        if(e.getSource() == this.vMe.btnActualizar){
            this.vAc.setVisible(true);
            this.vAc.setLocationRelativeTo(vMe);
            this.vAc.setResizable(false);
        }
        
    }

}
