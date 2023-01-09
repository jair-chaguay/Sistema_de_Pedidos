module com.mycompany.proyecto2p.chaguay.cruz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto2p.chaguay.cruz to javafx.fxml;
    exports com.mycompany.proyecto2p.chaguay.cruz;
}
