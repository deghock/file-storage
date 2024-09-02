package ru.amir.storage.exception;

/**
 * @author Amir Khusnutdinov
 */
public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String message) {
        super(message);
    }

}
