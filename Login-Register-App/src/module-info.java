module LoginJava {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
	requires javafx.base;

    opens sample to javafx.graphics, javafx.fxml, javafx.controls, java.sql;
}