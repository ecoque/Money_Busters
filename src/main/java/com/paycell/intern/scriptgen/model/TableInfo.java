package com.paycell.intern.scriptgen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Veritabanı tablo bilgilerini tutan POJO sınıfı
 * ORTAK ALAN - Tüm stajyerler kullanabilir
 */
public class TableInfo {

    private String tableName;
    private String schemaName;
    private List<ColumnInfo> columns;
    private List<String> primaryKeyColumns;

    public TableInfo() {
        this.columns = new ArrayList<>();
        this.primaryKeyColumns = new ArrayList<>();
        System.out.println("Hello World! - TableInfo oluşturuldu.");
    }

    public TableInfo(String tableName) {
        this();
        this.tableName = tableName;
        System.out.println("Hello World! - TableInfo oluşturuldu: " + tableName);
    }

    // Getter ve Setter metodları
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public List<ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnInfo> columns) {
        this.columns = columns;
    }

    public void addColumn(ColumnInfo column) {
        this.columns.add(column);
    }

    public List<String> getPrimaryKeyColumns() {
        return primaryKeyColumns;
    }

    public void setPrimaryKeyColumns(List<String> primaryKeyColumns) {
        this.primaryKeyColumns = primaryKeyColumns;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "tableName='" + tableName + '\'' +
                ", schemaName='" + schemaName + '\'' +
                ", columns=" + columns.size() + " column(s)" +
                '}';
    }
}
