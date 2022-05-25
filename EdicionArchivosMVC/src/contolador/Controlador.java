package contolador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogico;
import vista.FrmPrincipal;

public class Controlador implements ActionListener {

    FrmPrincipal vista = new FrmPrincipal();
    ModeloLogico modelo = new ModeloLogico();

//CONSTRUCTOR ESPECIAL PARA EL PATRÓN MVC
    public Controlador(FrmPrincipal vista, ModeloLogico modelo) {
        this.vista = vista;
        this.modelo = modelo;
//Espacio en memoria para los componentes que realizan una acción
        this.vista.mnuiGuardar.addActionListener(this);
        this.vista.mnuiAbrir.addActionListener(this);

    }

    //FUNCIONAMIENTO DEL CONTROLADOR
    private void guardar() {
        //proceso del controlador para guardar el archivo txt
        //Muestra la ventana de FileChooser
        vista.fcArchivos.showSaveDialog(vista);
        //Agrega el texto escrito a la variable "texto"
        modelo.setTexto(vista.txtArea1.getText());
        //Agrega valor a la variable rutam para poder guardar el archivo
        modelo.setRuta(vista.fcArchivos.getSelectedFile().toString());
        //llamando al metodo que va a crear el archivo
        modelo.creaArchivo();
    }

    private void abrir() {
        int cierre = vista.fcArchivos.showOpenDialog(vista);
        if (cierre != vista.fcArchivos.CANCEL_OPTION) {
            modelo.setRuta(vista.fcArchivos.getSelectedFile().toString());
            modelo.abrir();
            vista.txtArea1.setText(modelo.getTexto());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.mnuiGuardar) {
            this.guardar();
        }
        if (e.getSource()== vista.mnuiAbrir){
        this.abrir();
        }
    }

}
