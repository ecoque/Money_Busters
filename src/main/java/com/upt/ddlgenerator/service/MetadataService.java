package com.upt.ddlgenerator.service;

import com.upt.ddlgenerator.repository.MetadataRepository;
import org.springframework.stereotype.Service;
import com.upt.ddlgenerator.model.ColumnMetadata;

import java.util.List;

@Service
public class MetadataService {

    private final MetadataRepository metadataRepository;

    public MetadataService(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    public List<String> getSchemas() {
        return metadataRepository.findSchemas();
    }
    public List<String> getTablesBySchema(String schema) {
        return metadataRepository.findTablesBySchema(schema);      //Controller direkt database'e inmiyor, iş mantığı ortada olmuş oldu.
    }
    public List<ColumnMetadata> getColumns(String schema, String tableName) {
        return metadataRepository.findColumns(schema, tableName);
    }

}
