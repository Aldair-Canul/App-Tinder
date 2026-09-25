package Tinder2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ProbarVistasMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // =========================================================================
        // SELECCIONA LA VISTA QUE DESEAS PROBAR:
        // =========================================================================



        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/ContactFormView.fxml"));
        stage.setTitle("Prueba - Formulario de Contacto");



        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}