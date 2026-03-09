package org.ies.tierno.model.exceptions;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(String isbn) {
        super("Libro no encontrado: " + isbn);
    }
}
