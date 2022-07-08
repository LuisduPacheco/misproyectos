package modelo;

import java.sql.ResultSet;
import conexion.Conector;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class UsuarioDAO implements ConsultasUsuario {

    //VARIABLE GLOBAL PARA EL REPORTE
   public JasperViewer jv;
    
    @Override
    public ArrayList<UsuarioVO> validarLogin(String username, String contrasenia) {
        Conector c = new Conector();

        ArrayList<UsuarioVO> datos = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT username, contrasenia, id_rol_usuario_fk "
                    + "FROM bdjuego.usuario WHERE username = '" + username + "' AND contrasenia = '" + contrasenia + "'";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()) {
                UsuarioVO uvo = new UsuarioVO();
                uvo.setUserName(rs.getString(1));
                uvo.setContrasenia(rs.getString(2));
                uvo.setIdRolUsuarioFk(rs.getInt(3));
                datos.add(uvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error[MValLog]: " + e.getMessage());
            c.desconectar();
        }
        return datos;
    }

    @Override
    public boolean insertar(UsuarioVO u) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO usuario (nombre_usuario, apellido_usuario, edad_usuario, username, contrasenia, id_rol_usuario_fk) VALUES "
                        +"('"+u.getNombreUsuario()+"', '"+u.getApellidoUsuario()
                        +"', "+u.getEdadUsuario()+", '"+u.getUserName()
                        +"', '"+u.getContrasenia()+"', "+u.getIdRolUsuarioFk()+")";
        
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[MInserta]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<UsuarioVO> consultar() {
        Conector c = new Conector ();
        ArrayList<UsuarioVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT id_usuario, nombre_usuario, apellido_usuario, "+
                            "edad_usuario, username, contrasenia, id_rol_usuario_fk "+
                            "FROM bdjuego.usuario";
                            
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
            UsuarioVO uvo = new UsuarioVO();
            uvo.setIdUsuario(rs.getInt(1));
            uvo.setNombreUsuario(rs.getString(2));
            uvo.setApellidoUsuario(rs.getString(3));
            uvo.setEdadUsuario(rs.getInt(4));
            uvo.setUserName(rs.getString(5));
            uvo.setContrasenia(rs.getString(6));
            uvo.setIdRolUsuarioFk(rs.getInt(7));
            info.add(uvo);
            
            }
        } catch (Exception e) {
            System.err.println("Error[MConsul]: "+e.getMessage());
            c.desconectar();        
        }
        return info;
    }

    @Override
    public boolean actualizarU(UsuarioVO u) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdjuego.usuario "  
                    +"SET nombre_usuario = '"+u.getNombreUsuario()+"', "
                    +"apellido_usuario = '"+u.getApellidoUsuario()+"', "
                    +"edad_usuario = "+u.getEdadUsuario()+", "
                    +"username = '"+u.getUserName()+"', "
                    +"contrasenia = '"+u.getContrasenia()+"', "
                    +"id_rol_usuario_fk = "+u.getIdRolUsuarioFk()+" "
                    +"WHERE id_usuario = "+u.getIdUsuario()+"";
                    c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[MActU]: "+e.getMessage());
            c.desconectar();
        }
    c.desconectar();
    return true;
    }

    @Override
    public boolean eliminarU(UsuarioVO u) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "DELETE FROM bdjuego.usuario "+
                            "WHERE id_usuario = "+u.getIdUsuario();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error[MElimina]: "+e.getMessage());
            c.desconectar();
            return false;
        }    
        c.desconectar();
        return true;
    }

    @Override
    public void reporte() { //metodo para generar el reporte
        Conector c = new Conector();
        try {
            c.conectar();
            //Definir una variable que encuentra el reporte
            JasperReport reporte; 
            //Ruta del reporte
            String ruta = "src\\reportes\\reporteJuego.jasper";
            //Asignacion de la ruta
             reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
             JasperPrint jp = JasperFillManager.fillReport(ruta, null, c.connection);
             JasperViewer jv = new JasperViewer(jp, false);
             this.jv = jv;
            
        } catch (Exception e) {
            System.err.println("Error [MReporte]: "+e.getMessage());
        }
  } 

}
