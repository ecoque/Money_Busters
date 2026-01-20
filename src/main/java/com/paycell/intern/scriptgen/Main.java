package com.paycell.intern.scriptgen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * DDL ve TRG Script Üretici Uygulaması
 * Ana uygulama başlatıcı sınıfı
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // FXML dosyasını yükle
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main_view.fxml"));
        Parent root = loader.load();

        // Sahneyi oluştur ve stil dosyasını ekle
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());

        // Pencere ayarları
        primaryStage.setTitle("DDL/TRG Script Generator");
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println("Hello World! - Uygulama başlatıldı.");
    }

    public static void main(String[] args) {
        System.out.println("Hello World! - Main.java");
        launch(args);
    }
}
