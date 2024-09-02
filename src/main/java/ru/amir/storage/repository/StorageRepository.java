package ru.amir.storage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.amir.storage.entity.File;

/**
 * @author Amir Khusnutdinov
 */
@Repository
public interface StorageRepository extends PagingAndSortingRepository<File, Long>,
CrudRepository<File, Long> {

}
