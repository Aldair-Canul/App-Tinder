package Controladores;

import javafx.event.ActionEvent; // IMPORTANTE
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader; // IMPORTANTE
import javafx.scene.Node; // IMPORTANTE
import javafx.scene.Parent; // IMPORTANTE
import javafx.scene.Scene; // IMPORTANTE
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage; // IMPORTANTE
import java.io.IOException; // IMPORTANTE

public class ControladorContacto {

    @FXML private TextArea txtMensaje;
    @FXML private ComboBox<String> cbMedioContacto;
    @FXML private Button btnEnviar;
    @FXML private Button btnCancelar;

    @FXML
    public void initialize() {
        cbMedioContacto.getItems().addAll("En persona", "Por teléfono", "Por correo");
    }

    @FXML
    private void onEnviar(ActionEvent event) throws IOException {
        String mensaje = txtMensaje.getText();
        String medio = cbMedioContacto.getValue();

        if (mensaje.isEmpty() || medio == null) {
            System.out.println("Por favor llena todos los campos.");
            return;
        }

        System.out.println("Mensaje enviado: " + mensaje);
        System.out.println("Medio preferido: " + medio);

        // --- CAMBIAR A LA BANDEJA DE ENTRADA (InboxView.fxml) ---
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/InboxView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void onCancelar() {
        txtMensaje.clear();
        cbMedioContacto.getSelectionModel().clearSelection();
    }
}