package Controladores;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import java.time.Period;

public class ControladorRegistro {
    
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtEdad;
    @FXML private TextField txtCodigoPostal;
    @FXML private DatePicker dpFecha;
    @FXML private ComboBox<String> cbGenero;
    @FXML private PasswordField pwdContraseña;
    @FXML private PasswordField pwdConfirmar;
    @FXML private CheckBox chkTerminos;

    @FXML
    private void initialize() {
        // Opciones del ComboBox
        cbGenero.getItems().addAll("Hombre", "Mujer", "otro");

        dpFecha.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || !date.isBefore(LocalDate.now()));
            }
        });

        // Listener: auto-calcular edad al elegir fecha
        dpFecha.valueProperty().addListener((obs, old, newDate) -> {
            if (newDate != null) {
                int edad = Period.between(newDate, LocalDate.now()).getYears();
                txtEdad.setText(String.valueOf(edad));
            }
        });
    }

    @FXML
    private void crearCuenta() {
        // Validaciones
        if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty()) {
            alertError("Nombre y apellidos son obligatorios.");
            return;
        }
        if (txtCorreo.getText().isEmpty()) {
            alertError("El correo es obligatorio.");
            return;
        }
        if (dpFecha.getValue() == null) {
            alertError("Selecciona tu fecha de nacimiento.");
            return;
        }
        if (txtCodigoPostal.getText().isEmpty()) {
            alertError("El código postal es obligatorio.");
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
        System.out.println("Edad: " + txtEdad.getText());
        System.out.println("Código postal: " + txtCodigoPostal.getText());
        System.out.println("Género: " + cbGenero.getValue());

        Alert ok = new Alert(AlertType.INFORMATION);
        ok.setTitle("Éxito");
        ok.setHeaderText(null);
        ok.setContentText("Cuenta creada correctamente.");
        ok.showAndWait();
    }

    private void alertError(String msg) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}