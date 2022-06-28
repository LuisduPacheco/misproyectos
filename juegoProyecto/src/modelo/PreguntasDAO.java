
package modelo;

import java.sql.ResultSet;
import conexion.Conector;
import java.util.ArrayList;

public class PreguntasDAO implements ConsultasPreguntas{

    @Override
    public ArrayList<PreguntasVO> consultar() {
        
        Conector c = new Conector();
        ArrayList<PreguntasVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT id_pregunta, pregunta FROM bdjuego.preguntas ";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()){
            PreguntasVO pvo = new PreguntasVO();
            pvo.setIdPregunta(rs.getInt(1));
            pvo.setPregunta(rs.getString(2));
            info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MConsultaPreg]: "+e.getMessage());
            c.desconectar();
        }
        return info;    
    }

    @Override
    public String consultaP(PreguntasVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT pregunta FROM bdjuego.preguntas WHERE id_pregunta = "+p.getIdPregunta();
            c.consultaDatos(query);
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error[ConPreg]: "+e.getMessage());
            return p.getPregunta();
        }
        return p.getPregunta();
    }

   
    
    
    
}
