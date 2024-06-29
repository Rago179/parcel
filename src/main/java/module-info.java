module org.example.coursework2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.coursework2 to javafx.fxml;
    exports org.example.coursework2;
}