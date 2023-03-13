package school.sptech.ensine.me.models;


import school.sptech.ensine.me.controllers.id.IdControllerUsuario;

import java.time.LocalDate;

public abstract class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String dataNasc;

    public Usuario(String nome, String email, String senha, String dataNasc) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.id = IdControllerUsuario.generateId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}
