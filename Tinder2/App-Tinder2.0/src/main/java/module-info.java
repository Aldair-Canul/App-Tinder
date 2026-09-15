module Tinder2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens Tinder2 to javafx.fxml, javafx.graphics;
    opens Controladores to javafx.fxml;
    opens Modelos to javafx.fxml;

    exports Tinder2;
}