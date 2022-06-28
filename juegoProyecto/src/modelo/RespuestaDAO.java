
package modelo;

import java.sql.ResultSet;
import conexion.Conector;
import java.util.ArrayList;

public class RespuestaDAO implements ConsultaRespuesta{

    @Override
    public ArrayList<RespuestaVO> consultarR() {
    
    Conector c = new Conector();
        ArrayList<RespuestaVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT id_respuesta, respuesta, id_pregunta_fk FROM bdjuego.respuestas ";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()){
            RespuestaVO rvo = new RespuestaVO();
            rvo.setIdRespuesta(rs.getInt(1));
            rvo.setRespuesta(rs.getString(2));
            rvo.setIdPreguntaFk(rs.getInt(3));
            info.add(rvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MConsultaRes]: "+e.getMessage());
            c.desconectar();
        }
        return info;    
    
    }


    
}
