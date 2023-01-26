package safa.ad_biblioteca.model;

import javafx.scene.image.ImageView;

// Clase Libro
public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String categoria;
    private String idioma;
    private String paginas;
    private String ejemplares;
    private ImageView imagen;


    public Libro(String ISBN, String titulo, String autor, String categoria, String idioma, String paginas, String ejemplares, ImageView imagen) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.idioma = idioma;
        this.paginas = paginas;
        this.ejemplares = ejemplares;
        this.imagen = imagen;
    }

    public ImageView getimagen() { return imagen; }

    public void setimagen(ImageView imagen) {  this.imagen = imagen;  }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(String ejemplares) {
        this.ejemplares = ejemplares;
    }

}