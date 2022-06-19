
package modelo;

public class LibroVO {
    
    private int idIsbn;
    private String tituloLibro;
    private String noPaginas;
    private String autorLibro;
    private String editoLibro;
    private String fechaInLibro;
    private String fechaActLibro;
    private int idAutorFk;

    public LibroVO() {
    }

    public int getIdIsbn() {
        return idIsbn;
    }

    public void setIdIsbn(int idIsbn) {
        this.idIsbn = idIsbn;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(String noPaginas) {
        this.noPaginas = noPaginas;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    

    public String getEditoLibro() {
        return editoLibro;
    }

    public void setEditoLibro(String editoLibro) {
        this.editoLibro = editoLibro;
    }

    public String getFechaInLibro() {
        return fechaInLibro;
    }

    public void setFechaInLibro(String fechaInLibro) {
        this.fechaInLibro = fechaInLibro;
    }

    public String getFechaActLibro() {
        return fechaActLibro;
    }

    public void setFechaActLibro(String fechaActLibro) {
        this.fechaActLibro = fechaActLibro;
    }

    public int getIdAutorFk() {
        return idAutorFk;
    }

    public void setIdAutorFk(int idAutorFk) {
        this.idAutorFk = idAutorFk;
    }
    
    
    
    
    
    
}
