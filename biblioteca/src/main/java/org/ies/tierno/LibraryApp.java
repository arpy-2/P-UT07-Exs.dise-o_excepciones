package org.ies.tierno;

import org.ies.tierno.model.Library;
import org.ies.tierno.model.exceptions.BookNotFoundException;
import org.ies.tierno.model.exceptions.MemberNotFoundException;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library("Biblioteca Central");

        int option;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Mostrar socios");
            System.out.println("3. Ver libro");
            System.out.println("4. Ver socio");
            System.out.println("5. Existe préstamo");
            System.out.println("0. Salir");

            option = sc.nextInt();
            sc.nextLine();

            try {
                switch (option) {

                    case 1:
                        library.mostrarLibros();
                        break;

                    case 2:
                        library.mostrarSocios();
                        break;

                    case 3:
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.println(library.getBook(isbn));
                        break;

                    case 4:
                        System.out.print("NIF: ");
                        String nif = sc.nextLine();
                        System.out.println(library.getMember(nif));
                        break;

                    case 5:
                        System.out.print("NIF: ");
                        String n = sc.nextLine();

                        System.out.print("ISBN: ");
                        String i = sc.nextLine();

                        boolean existe = library.existePrestamo(n, i);

                        System.out.println("¿Existe préstamo? " + existe);
                        break;
                }
            } catch (MemberNotFoundException | BookNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (option != 0);
    }
}