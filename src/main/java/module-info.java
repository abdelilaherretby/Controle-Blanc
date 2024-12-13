module org.example.controle_blanc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.xml.crypto;


    opens org.example.controle_blanc to javafx.fxml;
    exports org.example.controle_blanc;

    opens org.example.controle_blanc.Controller to javafx.fxml;
    exports org.example.controle_blanc.Controller ;

    opens org.example.controle_blanc.Model to javafx.fxml;
    exports org.example.controle_blanc.Model ;

    opens org.example.controle_blanc.Dao to javafx.fxml;
    exports org.example.controle_blanc.Dao ;



}