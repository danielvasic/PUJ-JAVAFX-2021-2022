module ba.sum.fsre.puj.pujjavafx20212022 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens ba.sum.fsre.puj.pujjavafx20212022 to javafx.fxml;
    exports ba.sum.fsre.puj.pujjavafx20212022;
    exports ba.sum.fsre.puj.pujjavafx20212022.controller;
    opens ba.sum.fsre.puj.pujjavafx20212022.controller to javafx.fxml;
}