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
public class Libro {

    public static Scanner lectorLibro = new Scanner(System.in);

    private static int contadorLibros;
    private int isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int copias;
    private int copiasDisponibles;

    // Constructor vacío
    public Libro() {
        contadorLibros++;
    }

    // Constructor con todos los parametros
    public Libro(int isbn, String titulo, String autor, String editorial, int copias, int copiasDisponibles) {
        contadorLibros++;
        this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setCopias(copias);
        this.setCopiasDisponibles(copiasDisponibles, copias);
    }

    // Constructor copia
    public Libro(Libro copia) {
        contadorLibros++;
        this.setIsbn(copia.getIsbn());
        this.setTitulo(copia.getTitulo());
        this.setAutor(copia.getAutor());
        this.setEditorial(copia.getEditorial());
        this.setCopias(copia.getCopias());
        this.setCopiasDisponibles(copia.getCopiasDisponibles(), copia.getCopias());
    }

    // GETTERS
    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getCopias() {
        return copias;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public static int getContadorLibros() {
        return contadorLibros;
    }

    // SETTERS
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setCopias(int copias) {
        while (copias < 1) {
            System.out.println(">>> No puede haber menos de 1 copia.");
            System.out.println(">>> Vuelve a introducir la cantidad de copias.");
            copias = lectorLibro.nextInt();
            lectorLibro.nextLine(); // Limpiar buffer dentro del input
        }
        this.copias = copias;
    }

    public void setCopiasDisponibles(int copiasDisponibles, int copias) {
        while (copiasDisponibles > copias) {
            System.out.println(">>> No puede haber menos de 1 copia.");
            System.out.println(">>> Vuelve a introducir la cantidad de copias.");
            copiasDisponibles = lectorLibro.nextInt();
            lectorLibro.nextLine(); // Limpiar buffer dentro del input
        }
        this.copiasDisponibles = copiasDisponibles;
    }

    @Override
    public String toString() {
        return "{ " + "ISBN: " + isbn + " | " + "Titulo: " + titulo + " | " + "Autor: " + autor + " | " + "Editorial: " + editorial + " | " + "Copias: " + copias + " | " + "Copias disponibles: " + copiasDisponibles + " }";
    }

    public static Libro anadirLibro() {
        Libro libroNuevo = new Libro();
        System.out.println(">>> Titulo del libro:");
        libroNuevo.setTitulo(lectorLibro.nextLine());
        System.out.println(">>> Autor del libro:");
        libroNuevo.setAutor(lectorLibro.nextLine());
        System.out.println(">>> Editorial del libro:");
        libroNuevo.setEditorial(lectorLibro.nextLine());
        System.out.println(">>> ISBN del libro:");
        libroNuevo.setIsbn(lectorLibro.nextInt());
        System.out.println(">>> Copias del libro:");
        int copias = lectorLibro.nextInt();
        libroNuevo.setCopias(copias);
        System.out.println(">>> Copias disponibles del libro:");
        libroNuevo.setCopiasDisponibles(lectorLibro.nextInt(), copias);
        lectorLibro.nextLine(); // Limpiar buffer dentro del input

        return libroNuevo;
    }

    public static int eliminarLibro(ArrayList<Libro> listaLibros) {
        boolean encontrado = false;
        System.out.println(">>> Introduce el ISBN del libro a eliminar");
        int ISBN = lectorLibro.nextInt();
        lectorLibro.nextLine(); // Limpiar buffer dentro del input
        for (int i = 0; (i < listaLibros.size() && encontrado == false); i++) {
            if (listaLibros.get(i).getIsbn() == ISBN) {
                if (listaLibros.get(i).getCopiasDisponibles() == listaLibros.get(i).getCopias()) {
                    encontrado = true;
                    contadorLibros -= 1;
                    //listaLibros.remove(i);
                    System.out.println(">>> Se ha eliminado el libro con el ISBN '" + ISBN + "'");
                    return i;
                } else {
                    System.out.println(">>> No se ha podido eliminar el libro con el ISBN '" + ISBN + "' por que tiene reservas.");
                }
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningún libro con el ISBN '" + ISBN + "'");
        }
        return -1;
    }

    public static void buscarPorIsbn(ArrayList<Libro> listaLibros) {
        System.out.println(">>> Introduce el ISBN del libro a buscar");
        int ISBN = lectorLibro.nextInt();
        lectorLibro.nextLine(); // Limpiar buffer dentro del input
        boolean encontrado = false;

        for (int i = 0; (i < listaLibros.size() && encontrado == false); i++) {
            if (listaLibros.get(i).getIsbn() == ISBN) {
                encontrado = true;
                System.out.println(">>> El libro con el ISBN '" + ISBN + "' está en la posición '" + i + "'");
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado el libro con el ISBN '" + ISBN + "'");
        }
    }

    public static void buscarPorTitulo(ArrayList<Libro> listaLibros) {
        System.out.println(">>> Introduce el titulo del libro a buscar");
        String busqueda = lectorLibro.nextLine();
        boolean encontrado = false;

        for (int i = 0; (i < listaLibros.size()); i++) {
            if (listaLibros.get(i).getTitulo().contains(busqueda)) {
                encontrado = true;
                System.out.println(listaLibros.get(i).toString());
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ninguna coincidencia con '" + busqueda + "'");
        }
    }
}
