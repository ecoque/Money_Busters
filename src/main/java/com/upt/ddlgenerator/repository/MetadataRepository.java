package com.upt.ddlgenerator.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.upt.ddlgenerator.model.ColumnMetadata;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class MetadataRepository {

    private final JdbcTemplate jdbcTemplate;

    public MetadataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * TASK:
     * SELECT DISTINCT owner FROM all_tables
     */
    public List<String> findSchemas() {
        String sql = """
                SELECT DISTINCT owner
                FROM all_tables
                ORDER BY owner
                """;

        return jdbcTemplate.queryForList(sql, String.class);
    }
    /**
     * TASK:
     * SELECT table_name
     * FROM all_tables
     * WHERE owner = :schema
     * ORDER BY table_name
     */
    public List<String> findTablesBySchema(String schema) {
        String sql = """
                SELECT table_name
                FROM all_tables
                WHERE owner = ?
                ORDER BY table_name
                """;

        return jdbcTemplate.queryForList(sql, String.class, schema);
    }
    public List<ColumnMetadata> findColumns(String schema, String tableName) {

        String sql = """
                SELECT
                    column_name,
                    data_type,
                    data_length,
                    data_precision,
                    data_scale,
                    nullable
                FROM all_tab_columns
                WHERE owner = ?
                  AND table_name = ?
                ORDER BY column_id
                """;

        return jdbcTemplate.query(sql, columnRowMapper(), schema, tableName);
    }

    private RowMapper<ColumnMetadata> columnRowMapper() {
        return (rs, rowNum) -> {
            ColumnMetadata column = new ColumnMetadata();
            column.setColumnName(rs.getString("column_name"));
            column.setDataType(rs.getString("data_type"));
            column.setDataLength(rs.getInt("data_length"));
            column.setDataPrecision(rs.getInt("data_precision"));
            column.setDataScale(rs.getInt("data_scale"));
            column.setNullable(rs.getString("nullable"));
            return column;
        };
    }

}
