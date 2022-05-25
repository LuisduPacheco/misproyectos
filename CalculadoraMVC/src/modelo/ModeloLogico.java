
package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ModeloLogico {
    
    //VARIABLES 
    private double n1;
    private double n2;
    private double resultado;
    private String ruta;
    private String fecha1;
    
    
    public ModeloLogico() {
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
    //LOGICA
    public void notificaciones (){
    JOptionPane.showMessageDialog(null, "Las funciones se aplican\n al primer valor ingresado");
    }
    
    public double suma (){
    this.resultado = n1+n2;
        return this.resultado;
    }
    
    public double resta(){
    this.resultado = n1-n2;
    return this.resultado;
    }

    public double multiplicacion(){
    this.resultado = n1*n2;
    return this.resultado;
    }
    
    public double division(){
    this.resultado = n1/n2;
        DecimalFormat df = new DecimalFormat("#.0000"); // Mascara 
    return Double.parseDouble(df.format(this.resultado));
    }
    
    public double potencia(){
    this.resultado = Math.pow(n1, n2);
    return this.resultado;
    }
    
    public double residuo(){
    this.resultado = n1%n2;
    return this.resultado;
    }
    
    public double coseno(){
    this.resultado = Math.cos(n1);
    DecimalFormat df = new DecimalFormat("#.0000"); // Mascara 
    return Double.parseDouble(df.format(this.resultado));
    }
    
    public double seno(){
    this.resultado = Math.sin(n1);
    DecimalFormat df = new DecimalFormat("#.0000"); // Mascara 
    return Double.parseDouble(df.format(this.resultado));
    }
    
    public double tangente(){
    this.resultado = Math.tan(n1);
    DecimalFormat df = new DecimalFormat("#.0000"); // Mascara 
    return Double.parseDouble(df.format(this.resultado));
    }
    
    public double absolutoV(){
    this.resultado = Math.abs(this.resultado);
    return this.resultado;
    }
    
    public double redondeo(){
    this.resultado = Math.round(this.resultado);
    return this.resultado;
    }
    
    public void creaArchivo(){
    FileWriter fw;
    PrintWriter pw;
    try{
        //Crea el objeto y el parametro es la ruta
        fw = new FileWriter(this.ruta+".txt");
        //Crea el objeto e imprime en el archivo que fué creado con el FileWriter
        pw = new PrintWriter(fw);
        
        pw.println("El ultimo resultado es: "+this.resultado);
        fw.close();// para que se guarden los cambios
    }catch (Exception ex){
        System.err.print(ex.getMessage());
    }
        
    }
    
   
    
}
