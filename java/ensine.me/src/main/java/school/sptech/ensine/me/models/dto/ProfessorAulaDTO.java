package school.sptech.ensine.me.models.dto;

public class ProfessorAulaDTO {
    private String email;
    private String senha;
    private String materia;
    private String titulo;
    private String dataHora;
    private int qtdAlunos;

    public ProfessorAulaDTO(String email, String senha, String materia, String titulo, String dataHora, int qtdAlunos) {
        this.email = email;
        this.senha = senha;
        this.materia = materia;
        this.titulo = titulo;
        this.dataHora = dataHora;
        this.qtdAlunos = qtdAlunos;
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

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

}
