package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class ControladorLogin {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField pwdContraseña;

    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
        if (txtUsuario.getText().isEmpty() || pwdContraseña.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Usuario y contraseña son obligatorios.");
            alert.showAndWait();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/MainDashboardView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void irARegistro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/CrearCuenta1.1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}