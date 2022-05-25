package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmOperaciones;
import modelo.ModeloLogico;
                                    //INTERFAZ 
public class Controlador implements ActionListener { //ActinoListener es un escuchador, clicks etx

//OBJETOS 
FrmOperaciones vista = new FrmOperaciones();
ModeloLogico modelo = new ModeloLogico();

    //CONSTRUCTOR ESPECIAL PARA ESTE PATRÓN MVC
    //Reservando espacio para todo lo que está en el modelo
    public Controlador (FrmOperaciones vista, ModeloLogico modelo){
    this.vista = vista;
    this.modelo = modelo;
    //Esparcio en memoria para los componentes que realizan una acción
    this.vista.btnSuma.addActionListener(this);
    this.vista.btnResta.addActionListener(this); 
    }    
    //FUNCIONAMIENTO DEL CONTROLADOR
    // metodo privado porque solo acá va a funcionar 
    private void sum(){
        //SETT para mandarle una variable a este metodo encapsulado
        //proceso del contolador para trasladar los datos al modelo
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        //Proceso del controlador de recibir y trasladar la respuesta a la vista
        vista.jopResultado.showMessageDialog(this.vista, modelo.suma());
    }
    private void rest(){
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        vista.jopResultado.showMessageDialog(this.vista, modelo.resta());
    }
    @Override //METODO ABSTRACTO 
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()== vista.btnSuma){
        this.sum();
    }if( e.getSource() == vista.btnResta){
        this.rest();
    }
    }
}
