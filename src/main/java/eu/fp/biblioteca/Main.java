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
            Biblioteca biblio = new Biblioteca();
            ArrayList<Libro> listaLibros = new Libro();
            ArrayList<Libro> listaLibros = biblio.getListaLibros();

            switch (opcion) {
                case 1:
                    Libro.anadirLibro(listaLibros);
                    break;
                case 2:
                    Libro.eliminarLibro(listaLibros);
                    break;
                case 3:
                    Libro.buscarPorIsbn(listaLibros);
                    break;
                case 4:
                    Libro.buscarPorTitulo(listaLibros);
                    break;
                case 5:
                    Biblioteca.mostrarLibros(listaLibros);
                    break;
                case 6:
                    Biblioteca.mostrarLibrosDisponibles(listaLibros);
                    break;
            }
        }
    }
}
