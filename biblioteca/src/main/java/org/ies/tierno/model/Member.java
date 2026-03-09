package org.ies.tierno.model;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Member {
    private String nif;
    private String nombre;
    private String apellidos;
    private int numeroSocio;
    private String codigoPostal;
}
