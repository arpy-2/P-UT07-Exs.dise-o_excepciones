package org.ies.tierno.model;

import lombok.Data;
import org.ies.tierno.model.exceptions.BookNotFoundException;
import org.ies.tierno.model.exceptions.MemberNotFoundException;

import java.util.*;

@Data
public class Library {

    private String nombre;
    private Map<String, Book> libros;
    private Map<String, Member> socios;
    private List<Loan> prestamos;

    public Library(String nombre) {
        this.nombre = nombre;
        libros = new HashMap<>();
        socios = new HashMap<>();
        prestamos = new ArrayList<>();
    }

    // Mostrar libros
    public void mostrarLibros() {
        libros.values().forEach(System.out::println);
    }

    // Mostrar socios
    public void mostrarSocios() {
        socios.values().forEach(System.out::println);
    }

    // Obtener libro
    public Book getBook(String isbn) throws BookNotFoundException {

        Book b = libros.get(isbn);

        if (b == null)
            throw new BookNotFoundException(isbn);
        return b;
    }

    // Obtener socio
    public Member getMember(String nif) throws MemberNotFoundException {

        Member m = socios.get(nif);

        if (m == null)
            throw new MemberNotFoundException(nif);
        return m;
    }

    // Comprobar préstamo
    public boolean existePrestamo(String nif, String isbn)
            throws MemberNotFoundException, BookNotFoundException {

        if (!socios.containsKey(nif))
            throw new MemberNotFoundException(nif);

        if (!libros.containsKey(isbn))
            throw new BookNotFoundException(isbn);

        for (Loan l : prestamos) {

            if (l.getNif().equals(nif)
                    && l.getIsbn().equals(isbn)
                    && l.getFechaDevolucion() == null) {

                return true;
            }
        }
        return false;
    }
}