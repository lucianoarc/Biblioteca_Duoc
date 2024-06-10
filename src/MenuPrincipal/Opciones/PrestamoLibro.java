
package MenuPrincipal.Opciones;

import Libros.Libro;
import librosduoc.LibroYaPrestadoException;


public class PrestamoLibro {
    public void prestarLibro(Libro libro) throws LibroYaPrestadoException {
        if (libro.estaDisponible()) {
            libro.prestar();
        } else {
            throw new LibroYaPrestadoException("El libro '" + libro.getTitulo() + "' ya esta prestado.");
        }
    }
}