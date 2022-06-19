
package modelo;

public class UsuarioVO {

    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private int edadUsuario;
    private String userName;
    private String contrasenia;
    private int idRolUsuarioFk;

    public UsuarioVO() {
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public int getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdRolUsuarioFk() {
        return idRolUsuarioFk;
    }

    public void setIdRolUsuarioFk(int idRolUsuarioFk) {
        this.idRolUsuarioFk = idRolUsuarioFk;
    }
    
    
    
}
