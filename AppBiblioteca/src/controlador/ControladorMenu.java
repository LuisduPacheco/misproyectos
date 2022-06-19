package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmActAutor;
import vista.FrmActLibro;
import vista.FrmEliminaAutor;
import vista.FrmEliminaLibro;
import vista.FrmInsertaAutor;
import vista.FrmInsertaLibro;
import vista.FrmMenu;
import vista.FrmMostrarAutor;
import vista.FrmMostrarLibro;

public class ControladorMenu implements ActionListener {

    FrmMenu vMe = new FrmMenu();
    FrmInsertaAutor vIa = new FrmInsertaAutor();
    FrmActAutor vAct = new FrmActAutor();
    FrmMostrarAutor vMostA = new FrmMostrarAutor();
    FrmEliminaAutor vElimA = new FrmEliminaAutor();
    
    FrmInsertaLibro vInL = new FrmInsertaLibro();
    FrmMostrarLibro vMostL = new FrmMostrarLibro();
    FrmEliminaLibro vElimL = new FrmEliminaLibro();
    FrmActLibro vActL = new FrmActLibro();
    
    public  ControladorMenu(FrmMenu vMe, FrmInsertaAutor vIa, FrmActAutor vAct,FrmMostrarAutor vMostA,FrmEliminaAutor vElimA,
                            FrmInsertaLibro vInL, FrmMostrarLibro vMostL, FrmEliminaLibro vElimL, FrmActLibro vActL) {
        //Botones MenuItem para Autor
        this.vMe = vMe;
        this.vIa = vIa;
        this.vAct = vAct;
        this.vMostA = vMostA;
        this.vElimA = vElimA;
        
        
        this.vInL = vInL;
        this.vMostL = vMostL;
        this.vElimL = vElimL;
        this.vActL = vActL;
        
        this.vMe.mnuAutor.addActionListener(this);
        this.vMe.mnuiInsert.addActionListener(this);
        this.vMe.mnuiAct.addActionListener(this);
        this.vMe.mnuiMostrar.addActionListener(this);
        this.vMe.mnuiEliminar.addActionListener(this);
        //Botones MenuItem para Libros
        this.vMe.mnuLibro.addActionListener(this);
        this.vMe.mnuiInsertL.addActionListener(this);
        this.vMe.mnuiActL.addActionListener(this);
        this.vMe.mnuiMostrarL.addActionListener(this);
        this.vMe.mnuiEliminarL.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vMe.mnuiInsert){
            this.vIa.setVisible(true);
            this.vIa.setLocationRelativeTo(vMe);
            this.vIa.setResizable(false);
        }
        if (e.getSource() == this.vMe.mnuiAct){
        this.vAct.setVisible(true);
        this.vAct.setLocationRelativeTo(vMe);
        this.vAct.setResizable(false);
        }
        if (e.getSource()== this.vMe.mnuiMostrar){
        this.vMostA.setVisible(true);
        this.vMostA.setResizable(false);
        this.vMostA.setLocationRelativeTo(vMe);
        }
        if (e.getSource() == this.vMe.mnuiEliminar){
        this.vElimA.setVisible(true);
        this.vElimA.setResizable(false);
        this.vElimA.setLocationRelativeTo(vMe);
        }
        if(e.getSource() == this.vMe.mnuiInsertL){
        this.vInL.setVisible(true);
        this.vInL.setLocationRelativeTo(vMe);
        this.vInL.setResizable(false);
        }
        if(e.getSource() == this.vMe.mnuiMostrarL){
        this.vMostL.setVisible(true);
        this.vMostL.setResizable(false);
        this.vMostL.setLocationRelativeTo(vMe);
        }
        if(e.getSource() == this.vMe.mnuiEliminarL){
        this.vElimL.setVisible(true);
        this.vElimL.setResizable(false);
        this.vElimL.setLocationRelativeTo(vMe);
        }
        if(e.getSource() == this.vMe.mnuiActL){
        this.vActL.setVisible(true);
        this.vActL.setLocationRelativeTo(vMe);
        this.vActL.setResizable(false);
        }
        
    }

}
