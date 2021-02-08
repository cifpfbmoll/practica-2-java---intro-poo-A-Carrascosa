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
public class Biblioteca {

    public static Scanner lectorLibro = new Scanner(System.in);

    private String nombreBiblioteca;
    private ArrayList<Libro> listaLibros = new ArrayList();
    private ArrayList<Persona> listaPersonal = new ArrayList();

    // Constructor vacio
    public Biblioteca() {
    }

    // Constructor con todos los parametros
    public Biblioteca(String nombreBiblioteca, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonal) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.listaLibros = listaLibros;
        this.listaPersonal = listaPersonal;
    }
    
    // Constructor copia
    public Biblioteca(Biblioteca copia) {
        this.setNombreBiblioteca(copia.getNombreBiblioteca());
        this.setListaLibros(copia.getListaLibros());
        this.setListaPersonal(copia.getListaPersonal());
    }

    // GETTERS Y SETTERS
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca.substring(0, 1).toUpperCase() + nombreBiblioteca.substring(1);
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    @Override
    public String toString() {
        return "{ " + "Biblioteca: " + nombreBiblioteca + " | " + "Titulos: " + listaLibros.size() + "Tamaño personal: " + listaPersonal.size() + " }";
    }

    public static void mostrarLibros(ArrayList<Libro> listaLibros) {
        System.out.println(">>> Enseñando todos los libros de la biblioteca");
        boolean encontrado = false;

        for (int i = 0; (i < listaLibros.size()); i++) {
            encontrado = true;
            System.out.println(listaLibros.get(i).toString());
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningun libro en la biblioteca");
        }
    }

    public static void mostrarLibrosDisponibles(ArrayList<Libro> listaLibros) {
        System.out.println(">>> Enseñando todos los libros de la biblioteca");
        boolean encontrado = false;

        for (int i = 0; (i < listaLibros.size()); i++) {
            if (listaLibros.get(i).getCopiasDisponibles() > 0) {
                encontrado = true;
                System.out.println(listaLibros.get(i).toString());
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningun libro disponible en la biblioteca");
        }
    }
}
