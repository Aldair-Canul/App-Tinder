package Controladores;

import Modelo.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//==================== CONTROLADOR: PANTALLA DE INTERESES ====================
public class ControladorIntereses {

    // ==================== CAMPOS FXML: NAVEGACIÓN ====================

    @FXML private Button btnAtras;
    @FXML private Button btnSiguiente;


    // ==================== CAMPOS FXML: INTERESES POR CATEGORÍA ====================

    @FXML private ToggleButton tbConciertos, tbKaraoke, tbProduccionMusical;
    @FXML private ToggleButton tbSeries, tbAnime, tbPeliculas, tbPodcasts;
    @FXML private ToggleButton tbFutbol, tbCiclismo, tbBasquetball, tbNatacion;
    @FXML private ToggleButton tbArte, tbTeatro, tbHistoria, tbDanza;
    @FXML private ToggleButton tbAnimales, tbJardineria, tbGaming;


    // ==================== INICIALIZACIÓN ====================

    @FXML
    private void initialize() {
        boolean esRegistroNuevo = Sesion.configurandoPerfilNuevo;
        btnAtras.setDisable(!esRegistroNuevo);
        btnAtras.setVisible(esRegistroNuevo);
    }


    // ==================== ACCIÓN: VOLVER A PERFIL ====================

    @FXML
    private void irAtras(ActionEvent event) throws IOException {
        if (!Sesion.configurandoPerfilNuevo) return;
        cambiarVista(event, "/Vistas/Perfil.fxml");
    }


    // ==================== ACCIÓN: CONTINUAR AL DASHBOARD ====================

    @FXML
    private void irSiguiente(ActionEvent event) throws IOException {
        List<String> seleccionados = obtenerInteresesSeleccionados();

        finalizarConfiguracionDePerfil();
        cambiarVista(event, "/Vistas/MainDashboardView.fxml");
    }


    // ==================== UTILIDAD: RECOLECTAR INTERESES ====================

    private List<String> obtenerInteresesSeleccionados() {
        List<String> lista = new ArrayList<>();
        ToggleButton[] todos = {
                tbConciertos, tbKaraoke, tbProduccionMusical,
                tbSeries, tbAnime, tbPeliculas, tbPodcasts,
                tbFutbol, tbCiclismo, tbBasquetball, tbNatacion,
                tbArte, tbTeatro, tbHistoria, tbDanza,
                tbAnimales, tbJardineria, tbGaming
        };
        for (ToggleButton tb : todos) {
            if (tb.isSelected()) {
                lista.add(tb.getText());
            }
        }
        return lista;
    }


    // ==================== UTILIDAD: CERRAR ESTADO DE SESIÓN ====================

    private void finalizarConfiguracionDePerfil() {
        Sesion.configurandoPerfilNuevo = false;
    }


    // ==================== UTILIDAD: CAMBIAR DE VISTA ====================

    private void cambiarVista(ActionEvent event, String rutaFXML) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(rutaFXML));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}