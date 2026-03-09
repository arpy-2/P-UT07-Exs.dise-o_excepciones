package org.ies.tierno.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Loan {
    private String isbn;
    private LocalDate fechaPrestamo;
    private String nif;
    private LocalDate fechaDevolucion;
}
