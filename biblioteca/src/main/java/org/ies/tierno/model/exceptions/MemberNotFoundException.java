package org.ies.tierno.model.exceptions;

public class MemberNotFoundException extends Exception {

    public MemberNotFoundException(String nif) {
        super("Socio no encontrado: " + nif);
    }
}
