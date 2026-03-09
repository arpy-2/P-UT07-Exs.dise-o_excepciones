package org.ies.tierno.readers;

import org.ies.tierno.model.Book;

import java.util.*;

public class BookReader {

    public static Book read() {

        Scanner sc = new Scanner(System.in);

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Géneros separados por coma: ");
        String[] generosInput = sc.nextLine().split(",");

        List<String> generos = Arrays.asList(generosInput);

        return new Book(isbn, titulo, autor, generos);
    }
}
