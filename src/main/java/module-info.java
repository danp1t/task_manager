module org.example.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens org.example.taskmanager.Collection to com.google.gson;
    opens org.example.taskmanager to javafx.fxml;
    exports org.example.taskmanager;
}