package org.example.lab9_iweb_20216316;

public class Usuario {

    private int id_usuario;
    private String nombres;
    private String apellidos;
    private String email;
    private String passwordHash;
    private String rol;
    private String estado;

    private Usuario(){

    }
    public Usuario(int id_usuario, String nombres, String apellidos, String email, String passwordHash,String rol, String estado){

        this.id_usuario=id_usuario;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.email=email;
        this.passwordHash=passwordHash;
        this.rol=rol;
        this.estado=estado;

    }


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



}
