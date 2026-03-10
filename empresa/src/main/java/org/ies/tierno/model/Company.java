package org.ies.tierno.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ies.tierno.model.exceptions.DepartmentNotFoundException;
import org.ies.tierno.model.exceptions.EmployeeNotFoundException;

import java.util.*;

@Data
@AllArgsConstructor
@Slf4j
public class Company {

    private String nombre;
    private String cif;
    private Map<String, Department> departamentos;

    public Company(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.departamentos = new HashMap<>();
        log.info("Empresa creada: {} con CIF {}", nombre, cif);
    }

    public void mostrarDepartamentos() {
        log.info("Mostrando todos los departamentos de la empresa {}", nombre);
        departamentos.values().forEach(System.out::println);
    }

    public List<Employee> getEmployeesFromDepartment(String nombre)
            throws DepartmentNotFoundException {

        log.info("Buscando empleados del departamento: {}", nombre);

        Department department = departamentos.get(nombre);

        if (department == null) {
            log.error("Departamento {} no encontrado", nombre);
            throw new DepartmentNotFoundException("Departamento no encontrado");
        }

        log.info("Departamento {} encontrado con {} empleados",
                nombre, department.getEmpleados().size());

        return department.getEmpleados();
    }

    public Department getDepartment(String nombre)
            throws DepartmentNotFoundException {

        log.info("Buscando departamento: {}", nombre);

        Department department = departamentos.get(nombre);

        if (department == null) {
            log.error("Departamento {} no encontrado", nombre);
            throw new DepartmentNotFoundException("no encontrado");
        }

        log.info("Departamento {} encontrado", nombre);
        return department;
    }

    public Employee getEmployeeByNif(String nif)
            throws EmployeeNotFoundException {

        log.info("Buscando empleado con NIF: {}", nif);

        for (Department department : departamentos.values()) {
            for (Employee employee : department.getEmpleados()) {
                if (employee.getNif().equals(nif)) {
                    log.info("Empleado encontrado: {} en departamento {}",
                            employee.getNombre(), department.getNombre());
                    return employee;
                }
            }
        }

        log.error("Empleado con NIF {} no encontrado", nif);
        throw new EmployeeNotFoundException("no encontrado");
    }
}