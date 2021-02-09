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
public class Persona {

    public static Scanner lectorPersona = new Scanner(System.in);

    private String nombre;
    private String apellidos;
    private String nif;
    private String passwd;

    // Constructor vacío
    public Persona() {
    }

    // Constructor con todos los parametros
    public Persona(String nombre, String apellidos, String nif, String passwd) {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setNif(nif);
        this.setPasswd(passwd);
    }

    // Constructor copia
    public Persona(Persona copia) {
        this.setNombre(copia.getNombre());
        this.setApellidos(copia.getApellidos());
        this.setNif(copia.getNif());
        this.setPasswd(copia.getPasswd());
    }

    // toString
    @Override
    public String toString() {
        return "{ " + "Nombre: " + nombre + " | " + "Apellidos: " + apellidos + " | " + "NIF: " + nif + " }";
    }

    // GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        if (passwd.length() < 8) {
            System.out.println(">>> La contraseña es demasiado corta, por favor introduce al menos 8 caracteres");
            passwd = lectorPersona.nextLine();
        }

        this.passwd = passwd;
    }

    public static Persona anadirPersonal() {
        Persona trabajadorNuevo = new Persona();
        System.out.println(">>> Nombre:");
        trabajadorNuevo.setNombre(lectorPersona.nextLine());
        System.out.println(">>> Apellidos:");
        trabajadorNuevo.setApellidos(lectorPersona.nextLine());
        System.out.println(">>> NIF:");
        trabajadorNuevo.setNif(lectorPersona.nextLine());
        System.out.println(">>> Contraseña:");
        trabajadorNuevo.setPasswd(lectorPersona.nextLine());

        return trabajadorNuevo;
    }

    public static int eliminarPersonal(ArrayList<Persona> listaPersonal) {
        boolean encontrado = false;
        System.out.println(">>> Introduce el NIF del trabajador a eliminar");
        String NIF = lectorPersona.nextLine();
        for (int i = 0; (i < listaPersonal.size() && encontrado == false); i++) {
            if (listaPersonal.get(i).getNif().equals(NIF)) {
                encontrado = true;
                System.out.println(">>> Se ha eliminado al trabajador con NIF '" + NIF + "'");
                return i;
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningún trabajador con el NIF '" + NIF + "'");
        }
        return -1;
    }

    public static void mostrarListaPersonal(ArrayList<Persona> listaPersonal) {
        System.out.println(">>> Enseñando todos los trabajadores de la biblioteca");
        boolean encontrado = false;

        for (int i = 0; (i < listaPersonal.size()); i++) {
            System.out.println(listaPersonal.get(i).toString());
            encontrado = true;
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningun trabajador en la biblioteca");
        }
    }

}
