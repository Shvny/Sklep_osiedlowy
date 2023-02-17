package sklep.sklep_osiedlowy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SklepOsiedlowy extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Wczytanie pliku FXML
        VBox root = FXMLLoader.load(getClass().getResource("SklepOsiedlowy.fxml"));

        // Utworzenie sceny
        Scene scene = new Scene(root, 600, 400);

        // Ustawienie sceny i wyświetlenie okna
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sklep Osiedlowy");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void show() {
    }
}