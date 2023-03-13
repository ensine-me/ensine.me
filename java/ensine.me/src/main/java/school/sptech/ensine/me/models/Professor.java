package school.sptech.ensine.me.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario{
    private String descricao;
    private List<String> diasTrabalho;
    private List<String> competencias;


    public Professor(String nome, String email, String senha, String dataNasc, String descricao, List<String> diasTrabalho, List<String> competencias) {
        super(nome, email, senha, dataNasc);
        this.descricao = descricao;
        this.diasTrabalho = diasTrabalho;
        this.competencias = competencias;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public List<String> getDiasTrabalho() {
        return diasTrabalho;
    }

    public void setDiasTrabalho(List<String> diasTrabalho) {
        this.diasTrabalho = diasTrabalho;
    }

    public List<String> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<String> competencias) {
        this.competencias = competencias;
    }
}
