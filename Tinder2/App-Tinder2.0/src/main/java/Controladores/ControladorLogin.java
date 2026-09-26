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

//==================== CONTROLADOR: PANTALLA DE INICIO DE SESIÓN ====================

public class ControladorLogin {

    // ==================== CAMPOS FXML ====================

    @FXML private TextField txtUsuario;
    @FXML private PasswordField pwdContraseña;


    // ==================== ACCIÓN: INICIAR SESIÓN ====================

    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
        if (txtUsuario.getText().isEmpty() || pwdContraseña.getText().isEmpty()) {
            alertError("Usuario y contraseña son obligatorios.");
            return;
        }
        cambiarVista(event, "/Vistas/MainDashboardView.fxml");
    }


    // ==================== ACCIÓN: IR A REGISTRO ====================

    @FXML
    private void irARegistro(ActionEvent event) throws IOException {
        cambiarVista(event, "/Vistas/CrearCuenta1.1.fxml");
    }


    // ==================== UTILIDAD: CAMBIAR DE VISTA ====================

    private void cambiarVista(ActionEvent event, String rutaFXML) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(rutaFXML));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    // ==================== UTILIDAD: ALERTA DE ERROR ====================

    private void alertError(String msg) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}