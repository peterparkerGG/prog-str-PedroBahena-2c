package com.example.demolistviewfile.controllers;

import com.example.demolistviewfile.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtedad;
    @FXML
    private Label lblMsge;


    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service= new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldValue,newValue) ->{
                    if(newValue!=null){
                        String[] parts= newValue.split(" - ");
                        txtNombre.setText(parts[0]);
                        txtEmail.setText(parts[1]);
                        txtedad.setText(parts[2]);
                    }


                }
        );
        loadFromFile();
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onAddPerson() {
        try {
            String edadt = txtedad.getText();
            String name = txtNombre.getText();
            String email = txtEmail.getText();
            service.addPerson(name, email, edadt);
            lblMsg.setText("Usuario Creado correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtNombre.clear();
            txtEmail.clear();
            txtedad.clear();
            loadFromFile();
        } catch (IOException e) {
            lblMsg.setText("Error de archivo" + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("Error de datos" + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onUpdate(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String age = txtedad.getText();
            String name = txtNombre.getText();
            String email = txtEmail.getText();

            service.updatePerson(index, name, email, age);
            loadFromFile();
            txtNombre.clear();
            txtEmail.clear();
            txtedad.clear();
            lblMsg.setText("Se actualizo el registro correctame");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("Hubo un error con con los datos"+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onDelete(){
        try {
        int index = listView.getSelectionModel().getSelectedIndex();
        service.delete(index);
        loadFromFile();
        txtNombre.clear();
        txtEmail.clear();
        txtedad.clear();
        lblMsg.setText("Se elimino  el registro correctame");
        lblMsg.setStyle("-fx-text-fill: green");
    } catch (IOException e) {
        lblMsg.setText("Hubo un error con el archivo");
        lblMsg.setStyle("-fx-text-fill: red");
    } catch (IllegalArgumentException e) {
        lblMsg.setText("Hubo un error con con los datos"+e.getMessage());
        lblMsg.setStyle("-fx-text-fill: red");
    }
    }
    private void loadFromFile(){
        try{
            List<String> items = service.loadForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Error: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}
