package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class ControladorDashboard {

    @FXML
    private TextField txtEdad;
    @FXML
    private ComboBox<String> comboIntereses;
    @FXML
    private VBox tarjetaPerfilEjemplo;
    @FXML
    private VBox tarjetaPerfil2;
    @FXML
    private VBox tarjetaPerfil3;

    @FXML
    public void initialize() {
        comboIntereses.getItems().addAll("Música", "Series", "Café", "Karaoke", "Peliculas", "Animales", "Futbol", "Gaming", "Anime");
    }

    @FXML
    private void filtrarPerfiles(ActionEvent event) {

        String edadTexto = txtEdad.getText();
        String interes = comboIntereses.getValue();

        // Si no escribe edad, no filtramos por edad
        int edad = 0;

        if (!edadTexto.isEmpty()) {
            edad = Integer.parseInt(edadTexto);
        }

        // PERFIL 1 - Sexybyte
        boolean mostrar1 =
                (edad == 0 || edad == 22) &&
                        (interes == null ||
                                interes.equals("Música") ||
                                interes.equals("Series") ||
                                interes.equals("Café"));

        // PERFIL 2
        boolean mostrar2 =
                (edad == 0 || edad == 25) &&
                        (interes == null ||
                                interes.equals("Karaoke") ||
                                interes.equals("Películas") ||
                                interes.equals("Animales"));

        // PERFIL 3 - Leo Mentes
        boolean mostrar3 =
                (edad == 0 || edad == 40) &&
                        (interes == null ||
                                interes.equals("Fútbol") ||
                                interes.equals("Gaming") ||
                                interes.equals("Anime"));

        tarjetaPerfilEjemplo.setVisible(mostrar1);
        tarjetaPerfilEjemplo.setManaged(mostrar1);

        tarjetaPerfil2.setVisible(mostrar2);
        tarjetaPerfil2.setManaged(mostrar2);

        tarjetaPerfil3.setVisible(mostrar3);
        tarjetaPerfil3.setManaged(mostrar3);
    }
    @FXML
    private void irABandeja(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/InboxView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void irAContacto(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/Vistas/ContactFormView.fxml")
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void irAmiperfil(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/Vistas/Perfil.fxml")
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}