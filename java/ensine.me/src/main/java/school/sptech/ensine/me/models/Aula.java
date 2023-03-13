package school.sptech.ensine.me.models;

import school.sptech.ensine.me.controllers.id.IdControllerAula;

import java.util.ArrayList;
import java.util.List;

public class Aula {
    private Professor professor;
    private String titulo;
    private String materia;
    private String dataHora;
    private int qtdAlunos;
    private List<Aluno> alunos;
    private int id;

    public Aula(Professor professor, String titulo, String materia, String dataHora, int qtdAlunos) {
        this.professor = professor;
        this.titulo = titulo;
        this.materia = materia;
        this.dataHora = dataHora;
        this.qtdAlunos = qtdAlunos;
        this.id = IdControllerAula.generateId();
        alunos = new ArrayList<>();
    }


}
