package ru.amir.storage.service;

import ru.amir.storage.dto.FileDto;

import java.util.List;

/**
 * @author Amir Khusnutdinov
 */
public interface StorageService {

    public Long create(FileDto fileDto);

    public FileDto get(Long id);

    public List<FileDto> getAll(int page, int size, String sort);

}
