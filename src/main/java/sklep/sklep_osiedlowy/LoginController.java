package sklep.sklep_osiedlowy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class LoginController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    // Metoda wywoływana po kliknięciu przycisku "Zaloguj"

    public void handleLogin(ActionEvent event)  throws IOException{

            String username = loginField.getText();
            String password = passwordField.getText();

            // Sprawdzenie danych logowania
            if (username.equals("java") && password.equals("java12")) {

            // Przejście do głównego widoku
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SklepOsiedlowy.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Pobranie kontrolera interfejsu sklepu osiedlowego i wywołanie metody inicjalizującej
            SklepOsiedlowyController controller = loader.getController();
            controller.initialize();
            controller.setCredentials(username, password);

            // Ustawienie nowej sceny
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(scene);

            // Wyświetlenie sceny
            stage.show();

        } else  {
                // Wyświetlenie komunikatu o błędnych danych logowania
                errorLabel.setText("Błędne dane logowania");
        }
    }
}