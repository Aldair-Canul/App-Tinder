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

public class ControladorIntereses {

    @FXML private Button btnAtras;
    @FXML private Button btnSiguiente;

    @FXML private ToggleButton tbConciertos, tbKaraoke, tbProduccionMusical;
    @FXML private ToggleButton tbSeries, tbAnime, tbPeliculas, tbPodcasts;
    @FXML private ToggleButton tbFutbol, tbCiclismo, tbBasquetball, tbNatacion;
    @FXML private ToggleButton tbArte, tbTeatro, tbHistoria, tbDanza;
    @FXML private ToggleButton tbAnimales, tbJardineria, tbGaming;

    @FXML
    private void initialize() {
        boolean esRegistroNuevo = Sesion.configurandoPerfilNuevo;
        btnAtras.setDisable(!esRegistroNuevo);
        btnAtras.setVisible(esRegistroNuevo);
    }

    @FXML
    private void irAtras(ActionEvent event) throws IOException {
        if (!Sesion.configurandoPerfilNuevo) return;

        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/Perfil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void irSiguiente(ActionEvent event) throws IOException {
        List<String> seleccionados = obtenerInteresesSeleccionados();

        Sesion.configurandoPerfilNuevo = false;

        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/MainDashboardView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

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
}