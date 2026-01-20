package com.paycell.intern.scriptgen.model;

/**
 * Veritabanı kolon bilgilerini tutan POJO sınıfı
 * ORTAK ALAN - Tüm stajyerler kullanabilir
 */
public class ColumnInfo {

    private String columnName;
    private String dataType;
    private int columnSize;
    private int decimalDigits;
    private boolean nullable;
    private boolean primaryKey;
    private String defaultValue;
    private String remarks;

    public ColumnInfo() {
        System.out.println("Hello World! - ColumnInfo oluşturuldu.");
    }

    public ColumnInfo(String columnName, String dataType) {
        this();
        this.columnName = columnName;
        this.dataType = dataType;
    }

    // Getter ve Setter metodları
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ColumnInfo{" +
                "columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", columnSize=" + columnSize +
                ", nullable=" + nullable +
                ", primaryKey=" + primaryKey +
                '}';
    }
}
