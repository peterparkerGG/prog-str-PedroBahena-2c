package com.example.examencontactos;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AppContactos extends Application {

    // 2. Lista para almacenar datos (CRUD en memoria)
    private ArrayList<Contacto> listaContactos = new ArrayList<>();
    private ObservableList<Contacto> itemsListView = FXCollections.observableArrayList();

    // Controles de la interfaz
    private TextField txtNombre = new TextField();
    private TextField txtTelefono = new TextField();
    private ComboBox<String> cbParentesco = new ComboBox<>();
    private ListView<Contacto> lvContactos = new ListView<>(itemsListView);

    // 3. Arreglo para cargar opciones de parentesco
    private String[] opcionesParentesco = {
            "Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"
    };

    @Override
    public void start(Stage primaryStage) {
        // Cargar el ComboBox con el arreglo
        cbParentesco.getItems().addAll(opcionesParentesco);

        // Layout y Diseño
        GridPane formulario = new GridPane();
        formulario.setHgap(10); formulario.setVgap(10);
        formulario.setPadding(new Insets(15));

        formulario.add(new Label("Nombre:"), 0, 0); formulario.add(txtNombre, 1, 0);
        formulario.add(new Label("Teléfono (10 dígitos):"), 0, 1); formulario.add(txtTelefono, 1, 1);
        formulario.add(new Label("Parentesco:"), 0, 2); formulario.add(cbParentesco, 1, 2);

        // Botones
        Button btnAgregar = new Button("Agregar");
        Button btnBuscar = new Button("Buscar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        HBox acciones = new HBox(10, btnAgregar, btnBuscar, btnActualizar, btnEliminar, btnLimpiar);
        VBox root = new VBox(20, formulario, acciones, new Label("Contactos Registrados:"), lvContactos);
        root.setPadding(new Insets(15));

        // Eventos
        btnAgregar.setOnAction(e -> agregarContacto());
        btnBuscar.setOnAction(e -> buscarContacto());
        btnActualizar.setOnAction(e -> actualizarContacto());
        btnEliminar.setOnAction(e -> eliminarContacto());
        btnLimpiar.setOnAction(e -> limpiarCampos());

        primaryStage.setTitle("Registro de Contactos de Emergencia");
        primaryStage.setScene(new Scene(root, 500, 550));
        primaryStage.show();
    }

    // --- MÉTODOS DE LÓGICA (CRUD) ---

    private void agregarContacto() {
        String nombre = txtNombre.getText().trim();
        String tel = txtTelefono.getText().trim();
        String par = cbParentesco.getValue();

        if (validarDatos(nombre, tel, par)) {
            // Validar si ya existe el nombre
            if (listaContactos.stream().anyMatch(c -> c.getNombre().equalsIgnoreCase(nombre))) {
                mostrarAlerta("Error", "Ya existe un contacto con ese nombre.");
                return;
            }
            Contacto nuevo = new Contacto(nombre, tel, par);
            listaContactos.add(nuevo);
            refrescarLista();
            limpiarCampos();
        }
    }

    private void buscarContacto() {
        String nombreABuscar = txtNombre.getText().trim();
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombreABuscar)) {
                txtTelefono.setText(c.getTelefono());
                cbParentesco.setValue(c.getParentesco());
                return;
            }
        }
        mostrarAlerta("Búsqueda", "Contacto no encontrado.");
    }

    private void actualizarContacto() {
        String nombre = txtNombre.getText().trim();
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                if (validarDatos(nombre, txtTelefono.getText(), cbParentesco.getValue())) {
                    c.setTelefono(txtTelefono.getText());
                    c.setParentesco(cbParentesco.getValue());
                    refrescarLista();
                    mostrarAlerta("Éxito", "Contacto actualizado correctamente.");
                }
                return;
            }
        }
        mostrarAlerta("Error", "Para actualizar, primero busca un nombre existente.");
    }

    private void eliminarContacto() {
        String nombre = txtNombre.getText().trim();
        boolean eliminado = listaContactos.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            refrescarLista();
            limpiarCampos();
            mostrarAlerta("Éxito", "Contacto eliminado.");
        } else {
            mostrarAlerta("Error", "No se encontró el contacto para eliminar.");
        }
    }

    // --- MÉTODOS AUXILIARES ---

    private boolean validarDatos(String n, String t, String p) {
        if (n.isEmpty() || t.isEmpty() || p == null) {
            mostrarAlerta("Validación", "Todos los campos son obligatorios.");
            return false;
        }
        if (t.length() != 10 || !t.matches("\\d+")) {
            mostrarAlerta("Validación", "El teléfono debe tener exactamente 10 dígitos numéricos.");
            return false;
        }
        return true;
    }

    private void refrescarLista() {
        itemsListView.setAll(listaContactos);
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}