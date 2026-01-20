# DDL/TRG Script Generator

Java ve JavaFX kullanılarak geliştirilmiş, veritabanı tabloları için otomatik DDL ve TRG scriptleri üreten masaüstü uygulaması.

## 📁 Proje Yapısı

```
src/
└── main/
    ├── java/com/paycell/intern/scriptgen/
    │   ├── Main.java                    (Uygulamayı başlatan ana dosya)
    │   │
    │   ├── ui/                          (STAJYER A BURADA ÇALIŞACAK)
    │   │   └── MainController.java      (Butona basılınca ne olacağını dinleyen kod)
    │   │
    │   ├── db/                          (STAJYER B BURADA ÇALIŞACAK)
    │   │   ├── DBConnector.java         (Veritabanına login olma kodu)
    │   │   └── TableMetadataReader.java (Tablo metadata okuma kodu)
    │   │
    │   ├── generator/                   (STAJYER B BURADA ÇALIŞACAK)
    │   │   ├── FileExporter.java        (Hazır metni .ddl/.trg dosyasına çeviren kod)
    │   │   └── TemplateEngine.java      (İçine %TABLO% yazılan şablonları dolduran kod)
    │   │
    │   └── model/                       (ORTAK ALAN)
    │       ├── TableInfo.java           (Tablo adı ve kolon listesini tutan veri taşıyıcı)
    │       └── ColumnInfo.java          (Kolon bilgilerini tutan veri taşıyıcı)
    │
    └── resources/                       (STAJYER A BURADA ÇALIŞACAK)
        ├── fxml/
        │   └── main_view.fxml           (SceneBuilder ile çizilen ekran tasarımı)
        └── styles/
            └── style.css                (Uygulamanın renkleri/fontları)
```

## 🚀 Başlangıç

### Gereksinimler
- Java 17 veya üzeri
- Gradle 8.x

### Uygulamayı Çalıştırma
```bash
./gradlew run
```

### Derleme
```bash
./gradlew build
```

## 📦 Paket Açıklamaları

| Paket | Sorumlu | Açıklama |
|-------|---------|----------|
| `ui` | Stajyer A | JavaFX Controller sınıfları ve arayüz kodları |
| `db` | Stajyer B | JDBC bağlantısı ve veritabanı sorguları |
| `generator` | Stajyer B | SQL text üretimi ve dosya yazma işlemleri |
| `model` | Ortak | POJO nesneleri (TableInfo, ColumnInfo) |

## 🔧 Teknolojiler
- Java 17
- JavaFX 21
- Gradle
- JDBC
