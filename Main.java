/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca;

import java.util.Scanner;

/**
 *
 * @author Karina
 */
public class Main {

    public static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 99;
        Biblioteca biblio = new Biblioteca();
        Libro libroNuevo;
        Persona trabajadorNuevo;

        while (opcion != 0) {
            clearScreen();
            System.out.println("    Menú de biblioteca");
            System.out.println("================================================");
            System.out.println(" 1 > Gestionar Libros");
            System.out.println(" 2 > Gestionar Reservas");
            System.out.println(" 3 > Gestionar Personal");
            System.out.println(" 4 > Gestionar Biblioteca");
            System.out.println(" "); 
            System.out.println(" 0 > Cerrar programa");

            opcion = lectorTeclado.nextInt();
            lectorTeclado.nextLine(); // Limpiar buffer dentro del input
            int opcion2 = 99;

            switch (opcion) {
                case 1:
                    clearScreen();
                    System.out.println("    Gestionar Libros");
                    System.out.println("================================================");
                    System.out.println(" 1 > Añadir libro");
                    System.out.println(" 2 > Eliminar libro");
                    System.out.println(" 3 > Buscar libro por ISBN");
                    System.out.println(" 4 > Buscar libro por titulo");
                    System.out.println(" 5 > Mostrar libros");
                    System.out.println(" 6 > Mostrar libros disponibles");
                    System.out.println(" "); 
                    System.out.println(" 0 > Volver al menú principal");

                    opcion2 = lectorTeclado.nextInt();
                    lectorTeclado.nextLine(); // Limpiar buffer dentro del input

                    switch (opcion2) {
                        case 1: // Añadir libros
                            libroNuevo = Libro.anadirLibro();
                            biblio.getListaLibros().add(libroNuevo);
                            break;
                        case 2: // Eliminar libros
                            int isbn = Libro.eliminarLibro(biblio.getListaLibros());
                            if (isbn != -1) {
                                biblio.getListaLibros().remove(isbn);
                            }
                            break;
                        case 3: // Buscar libro por ISBN y devolver la posicion
                            Libro.buscarPorIsbn(biblio.getListaLibros());
                            break;
                        case 4: // Buscar libro por titulo
                            Libro.buscarPorTitulo(biblio.getListaLibros());
                            break;
                        case 5: // Mostrar todos los libros
                            Biblioteca.mostrarLibros(biblio.getListaLibros());
                            break;
                        case 6: // Mostrar los libros disponibles
                            Biblioteca.mostrarLibrosDisponibles(biblio.getListaLibros());
                            break;
                    }
                    break;

                case 2:
                    clearScreen();
                    System.out.println("    Gestionar Reservas");
                    System.out.println("================================================");
                    System.out.println(" 1 > Añadir reserva");
                    System.out.println(" 2 > Eliminar reserva");
                    System.out.println(" 3 > Ver libros con reservas");
                    System.out.println(" 4 > Ver libros disponibles");
                    System.out.println(" "); 
                    System.out.println(" 0 > Volver al menú principal");

                    opcion2 = lectorTeclado.nextInt();
                    lectorTeclado.nextLine(); // Limpiar buffer dentro del input
                    break;

                case 3:
                    clearScreen();
                    System.out.println("    Gestionar Personal");
                    System.out.println("================================================");
                    System.out.println(" 1 > Añadir trabajador");
                    System.out.println(" 2 > Eliminar trabajador");
                    System.out.println(" 3 > Mostrar trabajadores registrados");
                    System.out.println(" "); 
                    System.out.println(" 0 > Volver al menú principal");

                    opcion2 = lectorTeclado.nextInt();
                    lectorTeclado.nextLine(); // Limpiar buffer dentro del input

                    switch (opcion2) {
                        case 1: // Añadir una persona al personal
                            trabajadorNuevo = Persona.anadirPersonal();
                            biblio.getListaPersonal().add(trabajadorNuevo);
                            break;
                        case 2: // Eliminar un trabajador del personal
                            int nif = Persona.eliminarPersonal(biblio.getListaPersonal());
                            if (nif != -1) {
                                biblio.getListaPersonal().remove(nif);
                            }
                            break;
                        case 3: // Consultar lista del personal
                            Persona.mostrarListaPersonal(biblio.getListaPersonal());
                            break;
                    }
                    break;
                    
                case 4:
                    clearScreen();
                    System.out.println("    Gestionar Biblioteca");
                    System.out.println("================================================");
                    System.out.println(" "); 
                    System.out.println(" 0 > Volver al menú principal");

                    opcion2 = lectorTeclado.nextInt();
                    lectorTeclado.nextLine(); // Limpiar buffer dentro del input
                    break;
                    
            }

        }
    }
    
    public static void clearScreen() {
        for(int i = 0 ; i < 10 ; i++) {
            System.out.println(" "); 
        }
    }
    
}
