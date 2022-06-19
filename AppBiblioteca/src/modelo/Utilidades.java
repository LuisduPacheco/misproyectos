package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

    
    public static String fechaActual(){
        String fechaActual;
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        fechaActual = sdf.format(fecha.getTime());
        return fechaActual;
    }
    
}
