package school.sptech.ensine.me.models.dto;

import school.sptech.ensine.me.models.Professor;

public class ProfessorSimplesDTO {

    private int id;
    private String nome;
    private String email;

    public ProfessorSimplesDTO(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
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
}
