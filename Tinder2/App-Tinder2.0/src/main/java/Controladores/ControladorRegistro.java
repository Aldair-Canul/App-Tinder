package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class ControladorRegistro {

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtCodigoPostal;
    @FXML private DatePicker dpFecha;
    @FXML private PasswordField pwdContraseña;
    @FXML private PasswordField pwdConfirmar;
    @FXML private CheckBox chkTerminos;

    @FXML
    private void initialize() {
        dpFecha.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate limite18 = LocalDate.now().minusYears(18);
                setDisable(empty || date.isAfter(limite18));
            }
        });
    }

    @FXML
    private void crearCuenta(ActionEvent event) throws IOException {
        if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty()) {
            alertError("Nombre y apellidos son obligatorios.");
            return;
        }
        if (txtCorreo.getText().isEmpty()) {
            alertError("El correo es obligatorio.");
            return;
        }
        if (txtCodigoPostal.getText().isEmpty()) {
            alertError("El código postal es obligatorio.");
            return;
        }
        if (dpFecha.getValue() == null) {
            alertError("Selecciona tu fecha de nacimiento.");
            return;
        }

        int edad = Period.between(dpFecha.getValue(), LocalDate.now()).getYears();
        if (edad < 18) {
            alertError("Debes ser mayor de 18 años para registrarte.");
            return;
        }

        if (!chkTerminos.isSelected()) {
            alertError("Debes aceptar los términos y condiciones.");
            return;
        }
        if (pwdContraseña.getText().isEmpty()) {
            alertError("La contraseña es obligatoria.");
            return;
        }
        if (!pwdContraseña.getText().equals(pwdConfirmar.getText())) {
            alertError("Las contraseñas no coinciden.");
            return;
        }

        System.out.println(" Registro exitoso ");
        System.out.println("Nombre: " + txtNombre.getText() + " " + txtApellidos.getText());
        System.out.println("Correo: " + txtCorreo.getText());
        System.out.println("Código postal: " + txtCodigoPostal.getText());
        System.out.println("Edad: " + edad);

        Alert ok = new Alert(AlertType.INFORMATION);
        ok.setTitle("Éxito");
        ok.setHeaderText(null);
        ok.setContentText("Cuenta creada correctamente.");
        ok.showAndWait();

        // Navega a la vista de Perfil para completarlo por primera vez
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/Perfil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void alertError(String msg) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}