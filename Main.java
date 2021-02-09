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
            System.out.println("    Menú de biblioteca");
            System.out.println("================================================");
            System.out.println(" 1 > Añadir libro");
            System.out.println(" 2 > Eliminar libro");
            System.out.println(" 3 > Buscar libro por ISBN");
            System.out.println(" 4 > Buscar libro por titulo");
            System.out.println(" 5 > Mostrar libros");
            System.out.println(" 6 > Mostrar libros disponibles");
            System.out.println(" 7 > Añadir trabajador");
            System.out.println(" 8 > Eliminar trabajador");
            System.out.println(" 9 > Mostrar trabajadores registrados");
            System.out.println(" 0 > Cerrar programa");

            opcion = lectorTeclado.nextInt();
            lectorTeclado.nextLine(); // Limpiar buffer dentro del input

            switch (opcion) {
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
                case 7: // Añadir una persona al personal
                    trabajadorNuevo = Persona.anadirPersonal();
                    biblio.getListaPersonal().add(trabajadorNuevo);
                    break;
                case 8: // Eliminar un trabajador del personal
                    int nif = Persona.eliminarPersonal(biblio.getListaPersonal());
                    if (nif != -1) {
                        biblio.getListaPersonal().remove(nif);
                    }
                    break;
                case 9: // Consultar lista del personal
                    Persona.mostrarListaPersonal(biblio.getListaPersonal());
                    break;
            }
        }
    }
}
