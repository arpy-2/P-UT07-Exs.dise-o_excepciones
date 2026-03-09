package org.ies.tierno.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import org.ies.tierno.model.exceptions.DepartmentNotFoundException;
import org.ies.tierno.model.exceptions.EmployeeNotFoundException;

import java.util.*;

@Data
@AllArgsConstructor
public class Company {

    private String nombre;
    private String cif;
    private Map<String, Department> departamentos;

    public Company(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.departamentos = new HashMap<>();
    }

    public void mostrarDepartamentos() {
        departamentos.values().forEach(System.out::println);
    }

    public List<Employee> getEmployeesFromDepartment(String nombre)
            throws DepartmentNotFoundException {

        Department d = departamentos.get(nombre);

        if (d == null)
            throw new DepartmentNotFoundException("Departamento no encontrado");

        return d.getEmpleados();
    }

    public Department getDepartment(String nombre)
            throws DepartmentNotFoundException {

        Department d = departamentos.get(nombre);

        if (d == null)
            throw new DepartmentNotFoundException("Departamento no encontrado");

        return d;
    }

    public Employee getEmployeeByNif(String nif)
            throws EmployeeNotFoundException {

        for (Department d : departamentos.values()) {
            for (Employee e : d.getEmpleados()) {
                if (e.getNif().equals(nif))
                    return e;
            }
        }

        throw new EmployeeNotFoundException("Empleado no encontrado");
    }

}