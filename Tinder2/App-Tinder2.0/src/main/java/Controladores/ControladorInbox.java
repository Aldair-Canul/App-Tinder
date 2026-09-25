package Controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class ControladorInbox {

    @FXML private ListView<String> listMensajes;
    @FXML private TextArea txtMensaje;
    @FXML private Button btnAceptar;
    @FXML private Button btnRechazar;
    @FXML private VBox vboxContacto;
    @FXML private Label lblTelefono;
    @FXML private Label lblCorreo;

    @FXML
    public void initialize() {
        // Ocultar los datos de contacto al inicio
        vboxContacto.setVisible(false);

        // Cargar mensajes de prueba
        listMensajes.getItems().addAll("Solicitud de Carlos", "Solicitud de Ana");

        // Evento al seleccionar un elemento de la lista
        listMensajes.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtMensaje.setText("Hola, me gustaría agendar una cita contigo.");
                vboxContacto.setVisible(false); // Ocultar contacto hasta aceptar
            }
        });
    }

    @FXML
    private void onAceptar() {
        // Revelar la información de contacto solo si se acepta la solicitud
        vboxContacto.setVisible(true);
        System.out.println("Solicitud aceptada.");
    }

    @FXML
    private void onRechazar() {
        // Ocultar contacto y limpiar vista
        vboxContacto.setVisible(false);
        txtMensaje.clear();
        System.out.println("Solicitud rechazada.");
    }
}