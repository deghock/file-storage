package ru.amir.storage.mapper;

import org.springframework.stereotype.Component;
import ru.amir.storage.dto.FileDto;
import ru.amir.storage.entity.File;

import java.util.Base64;
import java.util.List;

/**
 * @author Amir Khusnutdinov
 */
@Component
public class FileMapper {

    public File toEntity(FileDto dto) {
        File file = new File();
        file.setFile(fromBase64(dto.getFile()));
        file.setTitle(dto.getTitle());
        file.setCreationDate(dto.getCreationDate());
        file.setDescription(dto.getDescription());
        return file;
    }

    public FileDto toDto(File file) {
        FileDto dto = new FileDto();
        dto.setFile(toBase64(file.getFile()));
        dto.setTitle(file.getTitle());
        dto.setCreationDate(file.getCreationDate());
        dto.setDescription(file.getDescription());
        return dto;
    }

    public List<FileDto> toDtoList(List<File> files) {
        return files.stream().map(this::toDto).toList();
    }

    private String toBase64(byte[] src) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(src);
    }

    private byte[] fromBase64(String src) {
        Base64.Decoder decoder = Base64.getDecoder();
        return decoder.decode(src);
    }
}
