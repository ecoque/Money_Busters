package com.paycell.intern.scriptgen.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Veritabanı bağlantı yönetici sınıfı
 * STAJYER B burada çalışacak
 */
public class DBConnector {

    private String url;
    private String username;
    private String password;
    private Connection connection;

    public DBConnector() {
        System.out.println("Hello World! - DBConnector oluşturuldu.");
    }

    /**
     * Veritabanı bağlantı bilgilerini ayarlar
     */
    public void setConnectionInfo(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Veritabanına bağlantı kurar
     * @return Connection nesnesi
     * @throws SQLException bağlantı hatası durumunda
     */
    public Connection connect() throws SQLException {
        System.out.println("Hello World! - Veritabanına bağlanılıyor...");

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Bağlantı başarılı!");
        }

        return connection;
    }

    /**
     * Veritabanı bağlantısını kapatır
     */
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Hello World! - Bağlantı kapatıldı.");
            }
        } catch (SQLException e) {
            System.err.println("Bağlantı kapatılırken hata: " + e.getMessage());
        }
    }

    /**
     * Bağlantı durumunu kontrol eder
     */
    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    // Getter metodları
    public Connection getConnection() {
        return connection;
    }
}
