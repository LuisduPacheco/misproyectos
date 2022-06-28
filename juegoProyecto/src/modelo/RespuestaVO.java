
package modelo;

public class RespuestaVO {

private int idRespuesta;
private String respuesta;
private int idPreguntaFk;

    public RespuestaVO() {
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getIdPreguntaFk() {
        return idPreguntaFk;
    }

    public void setIdPreguntaFk(int idPreguntaFk) {
        this.idPreguntaFk = idPreguntaFk;
    }
    
    
}
