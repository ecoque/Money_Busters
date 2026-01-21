package com.upt.ddlgenerator.controller;

import com.upt.ddlgenerator.service.MetadataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.upt.ddlgenerator.model.ColumnMetadata;

import java.util.List;

@RestController
@RequestMapping("/api/metadata")
public class MetadataController {

    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @GetMapping("/schemas")
    public List<String> getSchemas() {
        return metadataService.getSchemas();
    }

    @GetMapping("/{schema}/tables")
    public List<String> getTablesBySchema(@PathVariable String schema) {
        return metadataService.getTablesBySchema(schema);
    }

    @GetMapping("/{schema}/tables/{tableName}/columns")
    public List<ColumnMetadata> getColumns(
            @PathVariable String schema,
            @PathVariable String tableName
    ) {
        return metadataService.getColumns(schema, tableName);
    }

}
