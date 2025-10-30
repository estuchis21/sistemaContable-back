/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Models;

/**
 *
 * @author esteb
 */
public class Usuario {
    private int id_usuario;
    private int dni;
    private String nombres;
    private String apellido;
    private String mail;
    private String username;
    private String contrasena;
    private int idRol;

    public Usuario(){}

    // Constructor con parámetros
    public Usuario(int id_usuario, int dni, String nombres, String apellido, String mail, String username, String contrasena, int idRol) {
        this.id_usuario = id_usuario;
        this.dni = dni;
        this.nombres = nombres;
        this.apellido = apellido;
        this.mail = mail;
        this.username = username;
        this.contrasena = contrasena;
        this.idRol = idRol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    // Getters y Setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
}

