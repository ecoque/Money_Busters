package com.paycell.intern.scriptgen.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Ana ekran için JavaFX Controller sınıfı
 * STAJYER A burada çalışacak
 */
public class MainController implements Initializable {

    @FXML
    private Label helloLabel;

    private int clickCount = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Hello World! - MainController initialized.");
    }

    /**
     * Butona basıldığında çalışacak metot
     */
    @FXML
    private void onButtonClick() {
        clickCount++;
        System.out.println("Hello World! - Butona tıklandı! (" + clickCount + ". kez)");
        helloLabel.setText("Hello World! - " + clickCount + ". tıklama");
    }
}
