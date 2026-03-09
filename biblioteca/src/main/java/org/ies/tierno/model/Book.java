package org.ies.tierno.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
public class Book {
    private String isbn;
    private String titulo;
    private String autor;
    private List<String> generos;
}
