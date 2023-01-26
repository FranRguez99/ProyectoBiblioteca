package safa.ad_biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import safa.ad_biblioteca.model.Conexion;


import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladorPrincipal implements Initializable {

    // Elementos JavaFX
    @FXML
    private Button btnDevolDevolver;

    @FXML
    private Button btnDevolucionesLibros;

    @FXML
    private Button btnDevolucionesPrestamos;

    @FXML
    private Button btnDevolucionesPrincipal;

    @FXML
    private Button btnDevolucionesUsuarios;

    @FXML
    private Button btnLibrosBorrar;

    @FXML
    private Button btnLibrosBuscar;

    @FXML
    private Button btnLibrosDevoluciones;

    @FXML
    private Button btnLibrosModificar;

    @FXML
    private Button btnLibrosNuevo;

    @FXML
    private Button btnLibrosPrestamos;

    @FXML
    private Button btnLibrosPrincipal;

    @FXML
    private Button btnLibrosUsuarios;

    @FXML
    private Button btnPrestamosDevoluciones;

    @FXML
    private Button btnPrestamosLibros;

    @FXML
    private Button btnPrestamosPrestar;

    @FXML
    private Button btnPrestamosPrincipal;

    @FXML
    private Button btnPrestamosUsuarios;

    @FXML
    private Button btnPrincipalDevoluciones;

    @FXML
    private Button btnPrincipalLibros;

    @FXML
    private Button btnPrincipalPrestamos;

    @FXML
    private Button btnPrincipalUsuarios;

    @FXML
    private Button btnRegLibREgistrar;

    @FXML
    private Button btnRegLibVolver;

    @FXML
    private Button btnRegUsuarioRegistrar;

    @FXML
    private Button btnRegUsuarioVolver;

    @FXML
    private Button btnUsuariosBorrar;

    @FXML
    private Button btnUsuariosBuscar;

    @FXML
    private Button btnUsuariosDevoluciones;

    @FXML
    private Button btnUsuariosLibros;

    @FXML
    private Button btnUsuariosModificar;

    @FXML
    private Button btnUsuariosNuevo;

    @FXML
    private Button btnUsuariosPrestamos;

    @FXML
    private Button btnUsuariosPrincipal;

    @FXML
    private Pane panelDevoluciones;

    @FXML
    private Pane panelLibros;

    @FXML
    private TextField tfCategoria; // Lo he cambiado a textfield mientras para poder seguir

    @FXML
    private Pane panelPrestamos;

    @FXML
    private Pane panelPrincipal;

    @FXML
    private Pane panelRegistroLibros;

    @FXML
    private Pane panelRegistroUsuarios;

    @FXML
    private Pane panelUsuarios;

    @FXML
    private TextField tfApellidos;

    @FXML
    private TextField tfDNI;

    @FXML
    private TextField tfDomicilio;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfTelefono;

    @FXML
    private TextField tfISBN;

    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfAutor;

    @FXML
    private TextField tfIdioma;

    @FXML
    private TextField tfPaginas;

    @FXML
    private TextField tfEjemplares;

    @FXML
    private Pane panelLibrosPreview;

    @FXML
    private ImageView imageViewLib1;

    @FXML
    private ImageView imageViewLib2;

    @FXML
    private ImageView imageViewLib3;

    @FXML
    private ImageView imageViewLib4;

    @FXML
    private ImageView imageViewLib5;

    @FXML
    private HBox HBoxDatosLibroBuscado;

    @FXML
    private ImageView imgViewLibroBuscado;

    @FXML
    private ListView<String> ListViewDatosLibro;

    @FXML
    private TextField tfBuscarISBN;

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

        public Libro(String titulo, String autor, String paginas) {
            this.titulo = titulo;
            this.autor = autor;
            this.paginas = paginas;
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

    // Atributos
    Conexion conexion = new Conexion();
    Boolean editaUsuario;
    Boolean editaLibro;


    // Métodos

    /* MÉTODOS PESTAÑA LIBROS */

    // Boton aceptar
    @FXML
    void aceptarLibros(ActionEvent event) throws SQLException {
        if (editaLibro){
            actualizarLibro();
        } else {
            insertarLibro();
        } volverLibros();
    }
    // Boton borrar
    @FXML
    void borrarLibro(ActionEvent event) throws SQLException {
        eliminarLibro("77864953V");
        // todo lectura de la tabla para recoger el valor del ISBN de la misma
    }
    // Boton modificar
    @FXML
    void modificarLibro() {
        cambiarVistaFormUsuarioL();
        editaLibro = true;
    }
    // Boton nuevo libro -> cambia de vista al formulario de registro
    @FXML
    void nuevoLibro(ActionEvent event) {
        cambiarVistaFormUsuarioL();
        editaLibro = false;
    }
    // Para mostrar el formulario de registro libros
    void cambiarVistaFormUsuarioL() {
        panelLibros.setVisible(false);
        panelLibrosPreview.setVisible(false);
        panelRegistroLibros.setVisible(true);
    }
    // Para mostrar el panel principal de libros
    void cambiarVistaVolverLibro() {
        panelRegistroLibros.setVisible(false);
        panelLibros.setVisible(true);
        panelLibrosPreview.setVisible(true);
        HBoxDatosLibroBuscado.setVisible(false);
    }

    @FXML
    void volverLibros() {
        cambiarVistaVolverLibro();
        // Vaciar campos formulario libros
        tfISBN.setText("");
        tfTitulo.setText("");
        tfAutor.setText("");
        tfCategoria.setText("");
        tfIdioma.setText("");
        tfPaginas.setText("");
        tfEjemplares.setText("");
        panelPrincipal.setVisible(true);
    }
    public class BookController {

        private TableView<Libro> ListViewDatosLibro;

        public BookController(TableView<Libro> booksList) {
            this.ListViewDatosLibro = ListViewDatosLibro;
        }
    // Mostrar el libro buscado / oculta la preview de libros general y muestra el libro concreto
    void mostrarLibroBuscado() throws SQLException {
        panelLibrosPreview.setVisible(false); // Desactivar el panel de libros de bienvenida
        HBoxDatosLibroBuscado.setVisible(true); // Activar el de la vista de libro buscado

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/biblioteca", "root", "root");
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT titulo, autor, paginas FROM libro");

            ListViewDatosLibro.getItems().clear();
            while(rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String paginas = rs.getString("paginas");

                Libro book = new Libro(titulo, autor, paginas);
                ListViewDatosLibro.getItems().add(book);
            }
            ListViewDatosLibro.refresh();
            conexion.conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        public void initTableView() {
            TableColumn<Libro, String> tituloCol = new TableColumn<>("Titulo");
            tituloCol.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            ListViewDatosLibro.getColumns().add(tituloCol);

            TableColumn<Libro, String> autorCol = new TableColumn<>("Autor");
            autorCol.setCellValueFactory(new PropertyValueFactory<>("autor"));
            ListViewDatosLibro.getColumns().add(autorCol);

            TableColumn<Libro, String> paginasCol = new TableColumn<>("Paginas");
            paginasCol.setCellValueFactory(new PropertyValueFactory<>("paginas"));
            ListViewDatosLibro.getColumns().add(paginasCol);

            ObservableList<Libro> books = FXCollections.observableArrayList();
            ListViewDatosLibro.setItems(books);
        }
    }



    String leerCampoLibro(String nombreCampoL, String texto, String criterioValidacion) {
        if (texto.matches(criterioValidacion)) {
            return texto;
        } else {
            return null;
        }
    }
    ArrayList<Object> leeValoresLibro() {
        ArrayList<Object> libros = new ArrayList<Object>();
        libros.add(leerCampoLibro("ISBN",tfISBN.getText(),".{10,13}"));
        libros.add(leerCampoLibro("Titulo",tfTitulo.getText(),".{1,50}"));
        libros.add(leerCampoLibro("Autor",tfAutor.getText(),".{1,50}"));
        libros.add(leerCampoLibro("Categoria", tfCategoria.getText(),"^\\s*$"));
        libros.add(leerCampoLibro("Idioma",tfIdioma.getText(),".{1,20}"));
        libros.add(leerCampoLibro("Paginas",tfPaginas.getText(),".{1,3}"));
        libros.add(leerCampoLibro("Ejemplares",tfEjemplares.getText(),".{1,3}"));

        return libros;
    }

    private boolean compruebaISBN(String ISBN, StringBuilder mensajeError) {
        if (ISBN == null) {
            mensajeError.append("ISBN (Introduzca un ISBN válido)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaTitulo(String Titulo, StringBuilder mensajeError) {
        if (Titulo == null) {
            mensajeError.append("Titulo (No puede estar vacío. Máximo 50 caracteres)\n");
            return true;
        }
        return false;
    }
    private boolean compruebaAutor(String Autor, StringBuilder mensajeError) {
        if (Autor == null) {
            mensajeError.append("Autor (No puede estar vacío. Máximo 50 caracteres)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaCategoria(String Categoria, StringBuilder mensajeError) {
        if (Categoria == null) {    // if (!cBoxCategoria.getSelectedItem().toString().matches("^\\s*$")) {

            mensajeError.append("Categoría (Escriba una categoría)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaIdioma(String Idioma, StringBuilder mensajeError) {
        if (Idioma == null) {
            mensajeError.append("Idioma (No puede estar vacío. Máximo 20 caracteres)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaPaginas(String Paginas, StringBuilder mensajeError) {
        if(Paginas == null) {
            mensajeError.append("Páginas (No puede estar vacío.)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaEjemplares (String Ejemplares, StringBuilder mensajeError) {
        if(Ejemplares == null) {
            mensajeError.append("Ejemplares (No puede estar vacío.)\n");
            return true;
        }
        return false;
    }

    boolean mensajeErrorLibro(ArrayList<Object>libros ) {
        boolean hayError = false;
        StringBuilder mensajeError = new StringBuilder();

        hayError = compruebaISBN((String) libros.get(0), mensajeError) ? true : hayError;
        hayError = compruebaTitulo((String) libros.get(1), mensajeError) ? true : hayError;
        hayError = compruebaAutor((String) libros.get(2), mensajeError) ? true : hayError;
        hayError = compruebaCategoria((String) libros.get(3), mensajeError) ? true : hayError;
        hayError = compruebaIdioma((String) libros.get(4), mensajeError) ? true : hayError;
        hayError = compruebaPaginas((String) libros.get(5), mensajeError) ? true : hayError;
        hayError = compruebaEjemplares((String) libros.get(6), mensajeError) ? true : hayError;


        if (hayError){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("CAMPOS ERRÓNEOS");
            error.setContentText("Hay error en los siguientes campos: " + mensajeError.toString());
            error.showAndWait();
        }
        return hayError;
    }

    // INSERT
    private void insertarLibro() throws SQLException {
        ArrayList<Object> libros = leeValoresLibro();
        if (!mensajeErrorLibro(libros)) {
            consultaInsertarLibro(libros);
        }
    }

    private void consultaInsertarLibro(ArrayList<Object> libros) throws SQLException {
        String sql = "INSERT INTO libros (ISBN, titulo, autor, categoria, idioma, paginas, ejemplares) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"; // Consulta para insertar libros en la base de datos
        try (PreparedStatement stmt = conexion.conexion.prepareStatement(sql)) {
            int i = 1;
            for (Object valor : libros) {
                stmt.setString(i++, (String) valor);
            }
            stmt.executeUpdate(); // Ejecutar la consulta
        }
    }

    // UPDATE
    private void actualizarLibro() throws SQLException {
        ArrayList<Object> libros = leeValoresLibro();
        if (!mensajeErrorUsuario(libros)) {
            consultaActualizarLibro(libros);
        }
    }

    private void consultaActualizarLibro(ArrayList<Object> libros) throws SQLException {
        String sql = "UPDATE libros SET ISBN=?, titulo=?, autor=?, categoria=?, idioma=?, paginas=?, ejemplares=? WHERE ISBN=?";
        try (PreparedStatement stmt = conexion.conexion.prepareStatement(sql)) {
            int i = 1;
            for (int j=1; j<libros.size(); j++) {
                stmt.setString(i++, (String) libros.get(j));
            }
            stmt.setString(i, (String) libros.get(0));
            stmt.executeUpdate();
        }
    }

    // DELETE
    private void eliminarLibro(String ISBN) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE ISBN = ?";
        try (PreparedStatement stmt = conexion.conexion.prepareStatement(sql)) {
            stmt.setString(1, ISBN);
            stmt.executeUpdate();
        }
    }

    /* MÉTODOS PESTAÑA USUARIO */

    @FXML
    void aceptarUsuarios(ActionEvent event) throws SQLException {
        if (editaUsuario){
            actualizarUsuario();
        } else {
            insertarUsuario();
        }
        volverUsuario();
    }

    @FXML
    void borrarUsuario() throws SQLException {
        eliminarUsuario("77864953V");
        // todo lectura de la tabla para recoger el valor del dni de la misma
    }

    @FXML
    void modificarUsuario() {
        cambiarVistaFormUsuario();
        editaUsuario = true;
    }

    @FXML
    void nuevoUsuario() {
        cambiarVistaFormUsuario();
        editaUsuario = false;
    }

    void cambiarVistaFormUsuario() {
        panelUsuarios.setVisible(false);
        panelRegistroUsuarios.setVisible(true);
    }

    @FXML
    void volverUsuario() {
        verUsuarios();
        tfDNI.setText("");
        tfNombre.setText("");
        tfApellidos.setText("");
        tfDomicilio.setText("");
        tfTelefono.setText("");
        tfEmail.setText("");
    }

    String leerCampo(String nombreCampo, String texto, String criterioValidacion) {
        if (texto.matches(criterioValidacion)) {
            return texto;
        } else {
            return null;
        }
    }

    ArrayList<Object> leerValoresUsuario() {
        ArrayList<Object> valores = new ArrayList<Object>();
        valores.add(leerCampo("DNI", tfDNI.getText(), "[0-9]{8}[A-Za-z]")); // Criterio: Que tenga formato de DNI
        valores.add(leerCampo("Nombre", tfNombre.getText(), ".{1,20}"));
        valores.add(leerCampo("Apellidos", tfApellidos.getText(), ".{1,40}"));
        valores.add(leerCampo("Domicilio", tfDomicilio.getText(), ".{1,40}"));
        valores.add(leerCampo("Telefono", tfTelefono.getText(), "^[0-9]{9}$")); // Criterio: que sean 9 cifras
        valores.add(leerCampo("Email", tfEmail.getText(), "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")); // Criterio: Que tenga formato de email
        return valores;
    }

    private boolean compruebaDNI(String dni, StringBuilder mensajeError) {
        if (dni == null) {
            mensajeError.append("DNI (Introduzca un DNI válido)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaNombre(String nombre, StringBuilder mensajeError) {
        if (nombre == null) {
            mensajeError.append("Nombre (No puede estar vacío. Máximo 20 caracteres)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaApellidos(String apellidos, StringBuilder mensajeError) {
        if (apellidos == null) {
            mensajeError.append("Apellidos (No puede estar vacío. Máximo 40 caracteres)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaDomicilio(String domicilio, StringBuilder mensajeError) {
        if (domicilio == null) {
            mensajeError.append("Domicilio (No puede estar vacío. Máximo 40 caracteres)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaTelefono(String telefono, StringBuilder mensajeError) {
        if (telefono == null) {
            mensajeError.append("Teléfono (9 dígitos)\n");
            return true;
        }
        return false;
    }

    private boolean compruebaEmail(String email, StringBuilder mensajeError) {
        if (email == null) {
            mensajeError.append("Email (Debe tener un formato válido)\n");
            return true;
        }
        return false;
    }

    boolean mensajeErrorUsuario(ArrayList<Object> valores) {
        boolean hayError = false;
        StringBuilder mensajeError = new StringBuilder();

        hayError = compruebaDNI((String) valores.get(0), mensajeError) ? true : hayError;
        hayError = compruebaNombre((String) valores.get(1), mensajeError) ? true : hayError;
        hayError = compruebaApellidos((String) valores.get(2), mensajeError) ? true : hayError;
        hayError = compruebaDomicilio((String) valores.get(3), mensajeError) ? true : hayError;
        hayError = compruebaTelefono((String) valores.get(4), mensajeError) ? true : hayError;
        hayError = compruebaEmail((String) valores.get(5), mensajeError) ? true : hayError;

        if (hayError) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("CAMPOS ERRÓNEOS");
            error.setContentText("Hay error en los siguientes campos: " + mensajeError.toString());
            error.showAndWait();
        }
        return hayError;
    }

    // INSERT
    void insertarUsuario() throws SQLException {
        ArrayList<Object> valores = leerValoresUsuario();
        if (!mensajeErrorUsuario(valores)) {
            consultaInsertarUsuario(valores);
        }
    }

    void consultaInsertarUsuario(ArrayList<Object> valores) throws SQLException {
        String sql = "INSERT INTO usuarios (DNI, nombre, apellidos, domicilio, telefono, email) " +
                "VALUES (?, ?, ?, ?, ?, ?)"; // Consulta para insertar usuarios en la base de datos
        try (PreparedStatement stmt = conexion.conexion.prepareStatement(sql)) {
            int i = 1;
            for (Object valor : valores) {
                stmt.setString(i++, (String) valor);
            }
            stmt.executeUpdate(); // Ejecutar la consulta
        }
    }

    // UPDATE
    void actualizarUsuario() throws SQLException {
        ArrayList<Object> valores = leerValoresUsuario();
        if (!mensajeErrorUsuario(valores)) {
            consultaActualizarUsuario(valores);
        }
    }

    void consultaActualizarUsuario(ArrayList<Object> valores) throws SQLException {
        String sql = "UPDATE usuarios SET nombre=?, apellidos=?, domicilio=?, telefono=?, email=? WHERE DNI=?";
        try (PreparedStatement stmt = conexion.conexion.prepareStatement(sql)) {
            int i = 1;
            for (int j=1; j<valores.size(); j++) {
                stmt.setString(i++, (String) valores.get(j));
            }
            stmt.setString(i, (String) valores.get(0));
            stmt.executeUpdate();
        }
    }

    // DELETE
    void eliminarUsuario(String DNI) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE DNI = ?";
        try (PreparedStatement stmt = conexion.conexion.prepareStatement(sql)) {
            stmt.setString(1, DNI);
            stmt.executeUpdate();
        }
    }



    /* BOTONES DE NAVEGACIÓN */
    @FXML
    void verPrincipal() {
        panelPrincipal.setVisible(true);
        panelLibros.setVisible(false);
        panelPrestamos.setVisible(false);
        panelDevoluciones.setVisible(false);
        panelUsuarios.setVisible(false);
    }

    @FXML
    void verDevoluciones() {
        panelPrincipal.setVisible(false);
        panelLibros.setVisible(false);
        panelPrestamos.setVisible(false);
        panelDevoluciones.setVisible(true);
        panelUsuarios.setVisible(false);
    }

    @FXML
    void verLibros() {
        panelPrincipal.setVisible(false);
        panelLibros.setVisible(true);
        panelPrestamos.setVisible(false);
        panelDevoluciones.setVisible(false);
        panelUsuarios.setVisible(false);
    }

    @FXML
    void verPrestamos() {
        panelPrincipal.setVisible(false);
        panelLibros.setVisible(false);
        panelPrestamos.setVisible(true);
        panelDevoluciones.setVisible(false);
        panelUsuarios.setVisible(false);
    }

    @FXML
    void verUsuarios() {
        panelPrincipal.setVisible(false);
        panelLibros.setVisible(false);
        panelPrestamos.setVisible(false);
        panelDevoluciones.setVisible(false);
        panelUsuarios.setVisible(true);
        panelRegistroUsuarios.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}