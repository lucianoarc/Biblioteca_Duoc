
package MenuPrincipal;


import Biblioteca.Biblioteca;
import Libros.Libro;
import MenuPrincipal.Opciones.PrestamoLibro;
import MenuPrincipal.Opciones.DevolucionLibro;
import java.util.InputMismatchException;
import java.util.Scanner;
import librosduoc.LibroNoEncontradoException;
import librosduoc.LibroYaPrestadoException;


public class Menu {
    
    
    public static void mostrarMenu(Scanner teclado, Biblioteca biblioteca, PrestamoLibro prestamoLibro, DevolucionLibro devolucionLibro) {
        int opciones = 0;
        boolean salir = false;
        
        while (!salir) {
            try {
                System.out.println("1. Prestar libro");
                System.out.println("2. Devolver libro");
                System.out.println("3. Salir del programa");
                System.out.print("Seleccione una opcion: ");
                opciones = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer de entrada

                switch (opciones) {
                    case 1:
                        System.out.println("Ingrese el titulo del libro a prestar:");
                        String tituloPrestar = teclado.nextLine();
                        try {
                            Libro libroPrestar = biblioteca.buscarLibroPorTitulo(tituloPrestar);
                            prestamoLibro.prestarLibro(libroPrestar);
                            System.out.println("El libro '" + tituloPrestar + "' se ha prestado correctamente.");
                        } catch (LibroNoEncontradoException e) {
                            System.out.println("No se encontro el libro especificado: " + e.getMessage());
                        } catch (LibroYaPrestadoException e) {
                            System.out.println("El libro especificado ya esta prestado: " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese el titulo del libro a devolver:");
                        String tituloDevolver = teclado.nextLine();
                        try {
                            Libro libroDevolver = biblioteca.buscarLibroPorTitulo(tituloDevolver);
                            devolucionLibro.devolverLibro(libroDevolver);
                            System.out.println("El libro '" + tituloDevolver + "' se ha devuelto correctamente.");
                        } catch (LibroNoEncontradoException e) {
                            System.out.println("No se encontro el libro especificado: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("!Hasta Luego!");
                        salir = true;
                        break;
                    default:
                        System.out.println("!Opcion Invalida!");
                        System.out.println("");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Por favor, ingrese un numero.");
                teclado.next(); // Limpiar la entrada incorrecta
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
                throw e; // Relanza la excepción para que pueda ser manejada 
            }
        }
    }
}
    

