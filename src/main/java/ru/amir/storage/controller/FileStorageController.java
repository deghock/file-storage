package ru.amir.storage.controller;

import org.springframework.web.bind.annotation.*;
import ru.amir.storage.dto.FileDto;
import ru.amir.storage.service.StorageService;

import java.util.List;

/**
 * @author Amir Khusnutdinov
 */
@RestController
@RequestMapping(value = "/storage")
public class FileStorageController {

    private final StorageService service;

    public FileStorageController(StorageService service) {
        this.service = service;
    }

    @PostMapping
    public Long create(@RequestBody FileDto fileDto) {
        return service.create(fileDto);
    }

    @GetMapping("/{id}")
    public FileDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<FileDto> getAll(@RequestParam(defaultValue = "0", required = false) int page,
                             @RequestParam(defaultValue = "10", required = false) int size,
                             @RequestParam(defaultValue = "desc", required = false) String sort) {
        return service.getAll(page, size, sort);
    }
}
