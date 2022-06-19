
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.Utilidades;
import vista.FrmInsertaAutor;

public class ControladorInsertaAutor implements ActionListener, WindowListener {

   
    FrmInsertaAutor vIn = new FrmInsertaAutor();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
   
    
    public ControladorInsertaAutor(FrmInsertaAutor vIn, AutorVO avo, AutorDAO adao) {
        this.vIn = vIn;
        this.adao = adao;
        this.avo = avo;
        
        this.vIn.btnCancel.addActionListener(this);
        this.vIn.btnRegistrar.addActionListener(this);
    }
    
    private void InsertaAutor(){
        this.avo.setNombreAutor(this.vIn.txtNombreAutor.getText());
        this.avo.setApellidoAutor(this.vIn.txtApellidoAutor.getText());
        this.avo.setNacionalidadAutor(this.vIn.txtNacionalidad.getText());
        this.avo.setFechaInAutor(Utilidades.fechaActual());
    
    if(adao.insertar(avo) == true ){
        vIn.jopMensaje.showMessageDialog(vIn, "Datos Registrados correctamente");
        this.vIn.txtNombreAutor.setText("");
        this.vIn.txtApellidoAutor.setText("");
        this.vIn.txtNacionalidad.setText("");
        
    }else{
        vIn.jopAlerta.showMessageDialog(vIn, "Error, datos no registrados");
        this.vIn.txtNombreAutor.setText("");
        this.vIn.txtApellidoAutor.setText("");
        this.vIn.txtNacionalidad.setText("");
        
    }
       
    
    
}
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vIn.btnRegistrar){
            if(!this.vIn.txtNombreAutor.getText().equals("") && !this.vIn.txtApellidoAutor.getText().equals("") && !this.vIn.txtNacionalidad.getText().equals("")){
            this.InsertaAutor();
            }else{
                this.vIn.jopMensaje.showMessageDialog(vIn, "Debe llenar todos los campos");
            }            
        }
        if(e.getSource() == vIn.btnCancel){
            this.vIn.txtNombreAutor.setText("");
            this.vIn.txtApellidoAutor.setText("");
            this.vIn.txtNacionalidad.setText("");
            vIn.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.vIn.txtNombreAutor.setText("");
        this.vIn.txtApellidoAutor.setText("");
        this.vIn.txtNacionalidad.setText("");
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
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
