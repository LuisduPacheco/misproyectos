package appbiblioteca;

import conexion.Conector;
import controlador.ControladorActAutor;
import controlador.ControladorActLibro;
import controlador.ControladorElimiinaLibro;
import controlador.ControladorEliminaAutor;
import controlador.ControladorInsertaAutor;
import controlador.ControladorInsertaLibro;
import controlador.ControladorMenu;
import controlador.ControladorMostAutor;
import controlador.ControladorMostLibros;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmActAutor;
import vista.FrmActLibro;
import vista.FrmEliminaAutor;
import vista.FrmEliminaLibro;
import vista.FrmInsertaAutor;
import vista.FrmInsertaLibro;
import vista.FrmMenu;
import vista.FrmMostrarAutor;
import vista.FrmMostrarLibro;

public class AppBiblioteca {

    public static void main(String[] args) {

        //Prueba de conexión
        //Conector c = new Conector();
        //c.conectar();
        
        
        //Objetos de Vistas
        FrmMenu vMnu = new FrmMenu();
        FrmInsertaAutor vInA = new FrmInsertaAutor();
        FrmActAutor vActA = new FrmActAutor();
        FrmMostrarAutor vMostA = new FrmMostrarAutor();
        FrmEliminaAutor vElimA = new FrmEliminaAutor();
        
        FrmInsertaLibro vInL = new FrmInsertaLibro();
        FrmMostrarLibro vMostL = new FrmMostrarLibro();
        FrmEliminaLibro vElimL = new FrmEliminaLibro();
        FrmActLibro vActL = new FrmActLibro();
        
        //Modelo
        AutorDAO adao = new AutorDAO();
        AutorVO avo = new AutorVO();
        
        LibroDAO ldao = new LibroDAO();
        LibroVO lvo = new LibroVO();
        
        //Controladores
        ControladorMenu cMnu = new ControladorMenu (vMnu, vInA, vActA, vMostA, vElimA, vInL, vMostL, vElimL, vActL);
        ControladorInsertaAutor cInA = new ControladorInsertaAutor (vInA, avo, adao);
        ControladorActAutor cActA = new ControladorActAutor (vActA, avo, adao);
        ControladorMostAutor cMostA = new ControladorMostAutor (vMostA, adao, avo );
        ControladorEliminaAutor cElimA = new ControladorEliminaAutor( vElimA, adao, avo);
        
        ControladorInsertaLibro cInL = new ControladorInsertaLibro(vInL, ldao, lvo, avo, adao);
        ControladorMostLibros cMostL = new ControladorMostLibros(vMostL, ldao, lvo);
        ControladorElimiinaLibro cElimL = new ControladorElimiinaLibro(vElimL, ldao, lvo, adao, avo);
        ControladorActLibro cActL = new ControladorActLibro(vActL, ldao, lvo, adao, avo);
        
//Iniciando la ventana
        vMnu.setVisible(true);
        vMnu.setResizable(false);
        vMnu.setLocationRelativeTo(null);
        
        
    }

}
