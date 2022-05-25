package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloLogico;
import vista.FrmCalculadora;

public class Controlador implements ActionListener {

    public Controlador() {
    }

    //OBJETOS
    FrmCalculadora vista = new FrmCalculadora();
    ModeloLogico modelo = new ModeloLogico();

    //CONSTRUCTOR PARA PATRÓN MVC
    public Controlador(FrmCalculadora vista, ModeloLogico modelo) {
        this.vista = vista;
        this.modelo = modelo;
        //ESPACIO EN MEMORIA PARA LOS COMPONENTES QUE REALIZAN UNA ACCIÓN
        this.vista.btnSuma.addActionListener(this);
        this.vista.btnResta.addActionListener(this);
        this.vista.btnProducto.addActionListener(this);
        this.vista.btnDivision.addActionListener(this);
        this.vista.btnAbsoluto1.addActionListener(this);
        this.vista.btnPotencia.addActionListener(this);
        this.vista.btnCos.addActionListener(this);
        this.vista.btnSin.addActionListener(this);
        this.vista.btnTan.addActionListener(this);
        this.vista.mnuiRedondeo.addActionListener(this);
        this.vista.mnuiGuardar.addActionListener(this);

    }
    
   

    private void Suma() {
        this.modelo.setN1(Double.parseDouble(this.vista.txtNum1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtNum2.getText()));
        this.vista.txtReultado.setText(String.valueOf(this.modelo.suma()));
    }

    private void Resta() {
        this.modelo.setN1(Double.parseDouble(this.vista.txtNum1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtNum2.getText()));
        this.vista.txtReultado.setText(String.valueOf(this.modelo.resta()));
    }

    private void Multiplicacion() {
        this.modelo.setN1(Double.parseDouble(this.vista.txtNum1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtNum2.getText()));
        this.vista.txtReultado.setText(String.valueOf(this.modelo.multiplicacion()));
    }

    private void Division() {
        this.modelo.setN1(Double.parseDouble(this.vista.txtNum1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtNum2.getText()));
        this.vista.txtReultado.setText(String.valueOf(this.modelo.division()));
    }
    
    private void Potencia(){
    this.modelo.setN1(Double.parseDouble(this.vista.txtNum1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtNum2.getText()));
        this.vista.txtReultado.setText(String.valueOf(this.modelo.potencia()));
    }
    
    private void Coseno(){
    this.modelo.notificaciones();
    this.modelo.setN1(Double.parseDouble(this.vista.txtNum1.getText()));
    this.vista.txtNum2.enableInputMethods(false);
    //this.modelo.setN2(Double.parseDouble(this.vista.txtNum2.getText()));
    this.vista.txtReultado.setText(String.valueOf(this.modelo.coseno()));
    }
    
    private void Seno(){
    this.modelo.notificaciones();
    this.modelo.setN1(Double.parseDouble(this.vista.txtNum1.getText()));
    this.vista.txtNum2.enableInputMethods(false);
    //this.modelo.setN2(Double.parseDouble(this.vista.txtNum2.getText()));
    this.vista.txtReultado.setText(String.valueOf(this.modelo.seno()));
    }
    private void Tangente(){
    this.modelo.notificaciones();
    this.modelo.setN1(Double.parseDouble(this.vista.txtNum1.getText()));
    this.vista.txtNum2.enableInputMethods(false);
    //this.modelo.setN2(Double.parseDouble(this.vista.txtNum2.getText()));
    this.vista.txtReultado.setText(String.valueOf(this.modelo.tangente()));
    }
    
    private void Redondeo(){
        this.vista.txtReultado.setText(String.valueOf(this.modelo.redondeo()));
    }
    
    private void valorAbs(){
        this.vista.txtReultado.setText(String.valueOf(this.modelo.absolutoV()));
    }
    
    private void Guardar(){
    //Muestra la ventana FileChooser
    vista.fcArchivos.showSaveDialog(vista);
    //Agraga el texto escrito a la variable resultado
    modelo.setResultado(Double.parseDouble(vista.txtReultado.getText()));
    //Agrega valor a la variable ruta para poder guardar el archivo
    modelo.setRuta(vista.fcArchivos.getSelectedFile().toString());
    modelo.creaArchivo();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnSuma) {
            this.Suma();
        }
        if (e.getSource() == vista.btnResta) {
            this.Resta();
        }
        if (e.getSource() == vista.btnProducto) {
            this.Multiplicacion();
        }
        if (e.getSource() == vista.btnDivision) {
            this.Division();
        }
        if (e.getSource() == vista.btnPotencia){
            this.Potencia();
        }
        if (e.getSource() == vista.mnuiRedondeo) {
            this.Redondeo();
        }
        if(e.getSource() == vista.btnAbsoluto1){
            this.valorAbs();
        }
        if (e.getSource() == vista.btnCos) {
            this.Coseno();
        }
        if (e.getSource() == vista.btnSin) {
            this.Seno();            
        }
        if (e.getSource() == vista.btnTan) {
            this.Tangente();
        }
        if (e.getSource() == vista.mnuiGuardar){
            this.Guardar();
        }
        

    }

}
