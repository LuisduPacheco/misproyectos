package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ModeloLogico {

    private String texto;
    private String ruta;

    public ModeloLogico() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    //METODO PARA CREAR UN ARCHIVO
    public void creaArchivo() {

        FileWriter fw;
        PrintWriter pw;
        try {
            //Crea el objeto y el parametro es la ruta en la que creará el archivo
            fw = new FileWriter(this.ruta + ".txt");
            //Crea el objeto e imprime en el archivo que fúe creado con el FileWriter
            pw = new PrintWriter(fw);

            pw.println(this.texto);
            fw.close();//para que se guarden los cambios
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
    }

    public void abrir(){
        File f; // Creando variable tipo file
        FileReader fr; // variable tipo FileReader
        BufferedReader br;
        this.texto = ""; //reseteando la variable texto
        
        try{
            f = new File(this.ruta);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            
            String lineas;
            while ((lineas = br.readLine()) != null){
                this.texto += lineas;
            }
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

}
