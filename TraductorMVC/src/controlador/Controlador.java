package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import vista.FrmTraductor;
import modelo.ModeloLogico;
                                    //INTERFAZ
public class Controlador implements ActionListener {

    //OBJETOS
    FrmTraductor vista = new FrmTraductor();
    ModeloLogico modelo = new ModeloLogico();
    
    
    //CONSTRUCTOR ESPECIAL PARA EL PATRÓN MVC
    //Reservando espacio para todo lo que está en el modelo
    public Controlador (FrmTraductor vista, ModeloLogico modelo){
    this.vista = vista;
    this.modelo = modelo;
    //Espacio en memoria para los componentes que realizan una acción
    this.vista.btnTraducir.addActionListener(this);
    //this.vista.jCBPalabras.addActionListener(this);
    }
    
    private void Palabras (){
        
        //this.vista.jCBPalabras.removeAll();
        //this.vista.jCBPalabras.addItem("Hola");
        //this.vista.jCBPalabras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hola", "Item 2", "Item 3", "mundo" }));
    
    modelo.setOpcion(vista.jCBPalabras.getSelectedIndex());
        System.out.println(modelo.getOpcion());
        
        if (modelo.getOpcion() == 0){
            vista.jopTraductor.showMessageDialog(this.vista, modelo.getPalabraUno());
        }else if(modelo.getOpcion() == 1){
            vista.jopTraductor.showMessageDialog(this.vista, modelo.getPalabraDos());
        }else if(modelo.getOpcion() == 2){
            vista.jopTraductor.showMessageDialog(this.vista, modelo.getPalabraTres());
        }else if(modelo.getOpcion() == 3){
            vista.jopTraductor.showMessageDialog(this.vista, modelo.getPalabraCuatro());
        }else{
            vista.jopTraductor.showMessageDialog(this.vista, modelo.getPalabraCinco());
        } 
    
    }
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vista.btnTraducir){
            this.Palabras();
        }
    }


    
}
