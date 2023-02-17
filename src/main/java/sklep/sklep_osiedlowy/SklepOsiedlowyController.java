package sklep.sklep_osiedlowy;
import java.sql.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class SklepOsiedlowyController {

    @FXML private TextField nazwaField;
    @FXML private TextField cenaField;
    @FXML private ListView<String> produktyList;

    @FXML private Label errorLabel;
    @FXML private Label errorLabel2;
    private String USER;
    private String PASSWORD;

    // Ustawienia bazy danych
    private final String URL = "jdbc:sqlserver://DESKTOP-F80KK31\\MSSQLSERVER:1433;database=sklep_osiedlowy;encrypt=true;trustServerCertificate=true;";
    public void setCredentials(String username, String password) {
        this.USER = username;
        this.PASSWORD = password;
    }

    // Metoda dodająca nowy produkt do bazy danych
    public void dodajProdukt() {
        String nazwa = nazwaField.getText();

        try {
            double cena = Double.parseDouble(cenaField.getText());
            // Nawiązanie połączenia z bazą danych
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Utworzenie zapytania SQL
            String query = "INSERT INTO produkty (nazwa, cena) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nazwa);
            statement.setDouble(2, cena);

            // Wykonanie zapytania
            statement.executeUpdate();

            // Zamknięcie połączenia
            statement.close();
            conn.close();

            // Wyczyszczenie pól tekstowych
            nazwaField.setText("");
            cenaField.setText("");

            // Odświeżenie listy produktów
            wyswietlProdukty();

        } catch (NumberFormatException e) {
            errorLabel.setText("Błędny format ceny");
        } catch (SQLException e) {
            errorLabel2.setText("Błąd: " + e.getMessage());
        }
    }

    // Metoda wyświetlająca listę produktów z bazy danych
    public void wyswietlProdukty() {
        produktyList.getItems().clear();
        try {
            // Nawiązanie połączenia z bazą danych
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Utworzenie zapytania SQL
            String query = "SELECT * FROM produkty";
            Statement statement = conn.createStatement();

            // Wykonanie zapytania
            ResultSet result = statement.executeQuery(query);

            // Dodanie wyników do listy produktów
            while (result.next()) {
                String nazwa = result.getString("nazwa");
                double cena = result.getDouble("cena");
                produktyList.getItems().add(nazwa + " - " + String.format("%.2f", cena));
            }

            // Zamknięcie połączenia
            result.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            errorLabel2.setText("Błąd: " + e.getMessage());
        }
    }

    public void initialize() {
    }
}