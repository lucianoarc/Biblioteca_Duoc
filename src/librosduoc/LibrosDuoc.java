
package librosduoc;

import Biblioteca.Biblioteca;
import Libros.Libro;
import MenuPrincipal.Menu;
import MenuPrincipal.Opciones.DevolucionLibro;
import MenuPrincipal.Opciones.PrestamoLibro;
import java.util.ArrayList;
import java.util.Scanner;


public class LibrosDuoc {
    

   
    public static void main(String[] args) {
        System.out.println("Bienvenido a la Biblioteca DUOC-UC");
        System.out.println("");
        Scanner Teclado = new Scanner(System.in);
        
        Libro libro1 = new Libro("Harry Potter", "J.K. Rowling");
        Libro libro2 = new Libro("La soledad", "Gabriel Garcia Marquez");
        Libro libro3 = new Libro("El principito", "Antoine de Saint-Exupery");
        Libro libro4 = new Libro("1984", "George Orwell");
        Libro libro5 = new Libro("los anillos", "J.R.R. Tolkien");

        
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        PrestamoLibro prestamoLibro = new PrestamoLibro();
        DevolucionLibro devolucionLibro = new DevolucionLibro();

        // Mostrar libros disponibles
        System.out.println("Libros disponibles:");
        System.out.println("");
        ArrayList<Libro> librosDisponibles = biblioteca.obtenerLibrosDisponibles();
        for (Libro libro : librosDisponibles) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor());
        }
        System.out.println("");
       Menu.mostrarMenu(Teclado, biblioteca, prestamoLibro, devolucionLibro);
    
    }
}
