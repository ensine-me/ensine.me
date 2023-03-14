package school.sptech.ensine.me.models;

import school.sptech.ensine.me.controllers.id.IdControllerAula;
import school.sptech.ensine.me.models.dto.UsuarioSimplesDTO;

import java.util.ArrayList;
import java.util.List;

public class Aula {
    private int id;
    private Professor professor;
    private String titulo;
    private String materia;
    private String dataHora;
    private int qtdAlunos;
    private List<Aluno> alunos;

    public Aula(Professor professor, String titulo, String materia, String dataHora, int qtdAlunos) {
        this.professor = professor;
        this.titulo = titulo;
        this.materia = materia;
        this.dataHora = dataHora;
        this.qtdAlunos = qtdAlunos;
        this.id = IdControllerAula.generateId();
        alunos = new ArrayList<>();
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public UsuarioSimplesDTO getProfessor() {
        UsuarioSimplesDTO professorDTO = new UsuarioSimplesDTO(professor);
        return professorDTO;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public List<UsuarioSimplesDTO> getAlunos() {
        List<UsuarioSimplesDTO> usuarioSimplesDTO = new ArrayList<>();
        for (Aluno a:
             alunos) {
            usuarioSimplesDTO.add(new UsuarioSimplesDTO(a));
        }
        return usuarioSimplesDTO;
    }

    public List<Aluno> listarAlunosCompleto() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void addAluno(Aluno aluno){
        if (aluno != null){
            alunos.add(aluno);
        }
    }
}
