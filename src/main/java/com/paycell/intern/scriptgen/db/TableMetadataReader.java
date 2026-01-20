package com.paycell.intern.scriptgen.db;

import com.paycell.intern.scriptgen.model.ColumnInfo;
import com.paycell.intern.scriptgen.model.TableInfo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Veritabanından tablo ve kolon metadata bilgilerini okuyan sınıf
 * STAJYER B burada çalışacak
 */
public class TableMetadataReader {

    private final Connection connection;

    public TableMetadataReader(Connection connection) {
        this.connection = connection;
        System.out.println("Hello World! - TableMetadataReader oluşturuldu.");
    }

    /**
     * Belirtilen tablonun bilgilerini okur
     * @param tableName tablo adı
     * @return TableInfo nesnesi
     */
    public TableInfo readTableInfo(String tableName) throws SQLException {
        System.out.println("Hello World! - Tablo bilgileri okunuyor: " + tableName);

        TableInfo tableInfo = new TableInfo(tableName);
        List<ColumnInfo> columns = readColumns(tableName);
        tableInfo.setColumns(columns);

        return tableInfo;
    }

    /**
     * Tablonun kolon bilgilerini okur
     */
    private List<ColumnInfo> readColumns(String tableName) throws SQLException {
        List<ColumnInfo> columns = new ArrayList<>();
        DatabaseMetaData metaData = connection.getMetaData();

        try (ResultSet rs = metaData.getColumns(null, null, tableName, null)) {
            while (rs.next()) {
                ColumnInfo column = new ColumnInfo();
                column.setColumnName(rs.getString("COLUMN_NAME"));
                column.setDataType(rs.getString("TYPE_NAME"));
                column.setColumnSize(rs.getInt("COLUMN_SIZE"));
                column.setNullable(rs.getInt("NULLABLE") == DatabaseMetaData.columnNullable);
                columns.add(column);
            }
        }

        return columns;
    }

    /**
     * Veritabanındaki tüm tablo isimlerini listeler
     */
    public List<String> listAllTables() throws SQLException {
        System.out.println("Hello World! - Tüm tablolar listeleniyor...");

        List<String> tables = new ArrayList<>();
        DatabaseMetaData metaData = connection.getMetaData();

        try (ResultSet rs = metaData.getTables(null, null, "%", new String[]{"TABLE"})) {
            while (rs.next()) {
                tables.add(rs.getString("TABLE_NAME"));
            }
        }

        return tables;
    }
}
