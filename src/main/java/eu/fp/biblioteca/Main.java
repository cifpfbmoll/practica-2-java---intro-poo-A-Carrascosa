/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca;

import java.util.ArrayList;
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

        while (opcion != 0) {
            System.out.println("    Menú de biblioteca");
            System.out.println("================================================");
            System.out.println(" 1 > Añadir libro");
            System.out.println(" 2 > Eliminar libro");
            System.out.println(" 3 > Buscar libro por ISBN");
            System.out.println(" 4 > Buscar libro por titulo");
            System.out.println(" 5 > Mostrar libros");
            System.out.println(" 6 > Mostrar libros disponibles");
            System.out.println(" 0 > Cerrar programa");

            opcion = lectorTeclado.nextInt();
            lectorTeclado.nextLine(); // Limpiar buffer dentro del input

            switch (opcion) {
                case 1:
                    libroNuevo = Libro.anadirLibro();
                    biblio.getListaLibros().add(libroNuevo);
                    break;
                case 2:
                    int isbn = Libro.eliminarLibro(biblio.getListaLibros());
                    if (isbn != -1) {
                        biblio.getListaLibros().remove(isbn);
                    }
                    break;
                case 3:
                    Libro.buscarPorIsbn(biblio.getListaLibros());
                    break;
                case 4:
                    Libro.buscarPorTitulo(biblio.getListaLibros());
                    break;
                case 5:
                    Biblioteca.mostrarLibros(biblio.getListaLibros());
                    break;
                case 6:
                    Biblioteca.mostrarLibrosDisponibles(biblio.getListaLibros());
                    break;
            }
        }
    }
}
