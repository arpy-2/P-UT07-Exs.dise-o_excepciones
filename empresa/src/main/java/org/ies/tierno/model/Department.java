package org.ies.tierno.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Department {

    private String nombre;
    private List<Employee> empleados;

    public Department(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
}