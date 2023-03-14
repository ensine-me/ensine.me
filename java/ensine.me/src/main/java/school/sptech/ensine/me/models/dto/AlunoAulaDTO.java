package school.sptech.ensine.me.models.dto;

public class AlunoAulaDTO {
    private String email;
    private String senha;

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

    public AlunoAulaDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
