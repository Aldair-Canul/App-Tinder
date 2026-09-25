package Controladores;

import Modelo.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class ControladorPerfil {

    @FXML private ImageView imgFoto;
    @FXML private TextField txtApodo;
    @FXML private ComboBox<String> cbGenero;
    @FXML private TextArea txtDescripcion;

    @FXML
    private void initialize() {
        cbGenero.getItems().addAll("Hombre", "Mujer", "Otro");
    }

    @FXML
    private void agregarFoto() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg")
        );
        File archivo = chooser.showOpenDialog(imgFoto.getScene().getWindow());
        if (archivo != null) {
            imgFoto.setImage(new Image(archivo.toURI().toString()));
        }
    }

    @FXML
    private void irSiguiente(ActionEvent event) throws IOException {
        System.out.println("Apodo: " + txtApodo.getText());
        System.out.println("Género: " + cbGenero.getValue());
        System.out.println("Descripción: " + txtDescripcion.getText());

        // Marca que se está configurando el perfil por primera vez,
        // así el botón "Atrás" de Intereses queda habilitado
        Sesion.configurandoPerfilNuevo = true;

        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/Intereses.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}