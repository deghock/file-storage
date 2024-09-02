package ru.amir.storage.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.amir.storage.exception.FileNotFoundException;

/**
 * @author Amir Khusnutdinov
 */
@ControllerAdvice
public class FileStorageControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handleException(FileNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
