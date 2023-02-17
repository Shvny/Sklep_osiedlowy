module sklep.sklep_osiedlowy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens sklep.sklep_osiedlowy to javafx.fxml;
    exports sklep.sklep_osiedlowy;
}