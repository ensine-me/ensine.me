package school.sptech.ensine.me.models;

import java.time.LocalDate;

public class Aluno extends Usuario{
    private String instituicao;

    public Aluno(String nome, String email, String senha, String dataNasc, String instituicao) {
        super(nome, email, senha, dataNasc);
        this.instituicao = instituicao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
