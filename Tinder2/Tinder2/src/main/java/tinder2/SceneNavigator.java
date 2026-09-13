package tinder2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneNavigator {

    private static Stage stagePrincipal;

    public static void setStage(Stage stage) {
        stagePrincipal = stage;
    }

    public static void cambiarPantalla(String rutaFxml) throws IOException {
        Parent root = FXMLLoader.load(SceneNavigator.class.getResource(rutaFxml));
        Scene escenaActual = stagePrincipal.getScene();

        if (escenaActual == null) {
            escenaActual = new Scene(root);
            escenaActual.getStylesheets().add(SceneNavigator.class.getResource("/css/styles.css").toExternalForm());
            stagePrincipal.setScene(escenaActual);
        } else {
            escenaActual.setRoot(root);
        }
    }
}