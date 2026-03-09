package org.ies.tierno.model;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Employee {

    private String nif;
    private String nombre;
    private String apellidos;
    private String puesto;
}
