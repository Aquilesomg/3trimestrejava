package Biblioteca;
public class Libros {
    private int codigo;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libros(int codigo, String titulo, String autor, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }
        public int getCodigo() {
            return codigo;
        }
    
        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }    
    
        public String getTitulo() {
            return titulo;
        }
        public void setTitulo(String nombre) {
            this.titulo = nombre;
        }
    
        public String getAutor() {
            return autor;
        }
        public void setAutor(String autor) {
            this.autor = autor;
        }
    
        public boolean getDisponible() {
            return disponible;
        }
        public void setDisponible(boolean disponible) {
            this.disponible = disponible;
        }

}
