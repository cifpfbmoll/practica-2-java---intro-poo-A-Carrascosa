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
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
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

}
