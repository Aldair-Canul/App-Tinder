package tinder2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Tinder2App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Tinder2App.class.getResource("/fxml/Cambiarporpantallainicial.fxml"));
        scene = new Scene(root);
        scene.getStylesheets().add(Tinder2App.class.getResource("/css/styles.css").toExternalForm());

        stage.setTitle("Tinder2.0");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}