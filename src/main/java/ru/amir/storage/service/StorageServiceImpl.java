package ru.amir.storage.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.amir.storage.dto.FileDto;
import ru.amir.storage.entity.File;
import ru.amir.storage.exception.FileNotFoundException;
import ru.amir.storage.mapper.FileMapper;
import ru.amir.storage.repository.StorageRepository;

import java.util.List;

/**
 * @author Amir Khusnutdinov
 */
@Service
public class StorageServiceImpl implements StorageService {

    private final StorageRepository repository;
    private final FileMapper mapper;

    public StorageServiceImpl(StorageRepository repository, FileMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Long create(FileDto fileDto) {
        return repository.save(mapper.toEntity(fileDto)).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public FileDto get(Long id) {
        File file = repository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("The file with id=" + id + " not found."));
        return mapper.toDto(file);
    }

    @Override
    public List<FileDto> getAll(int page, int size, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase("desc") ?
                Sort.by("creationDate").descending() : Sort.by("creationDate").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return mapper.toDtoList(repository.findAll(pageable).getContent());
    }
}
