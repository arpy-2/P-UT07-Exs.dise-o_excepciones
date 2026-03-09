package org.ies.tierno.readers;

import org.ies.tierno.model.Member;

import java.util.Scanner;

public class MemberReader {

    public static Member read() {

        Scanner sc = new Scanner(System.in);

        System.out.print("NIF: ");
        String nif = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();

        System.out.print("Número socio: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.print("Código postal: ");
        String cp = sc.nextLine();

        return new Member(nif, nombre, apellidos, numero, cp);
    }
}
