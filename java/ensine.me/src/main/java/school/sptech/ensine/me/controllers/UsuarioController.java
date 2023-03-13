package school.sptech.ensine.me.controllers;

import org.springframework.web.bind.annotation.*;
import school.sptech.ensine.me.controllers.id.IdControllerUsuario;
import school.sptech.ensine.me.models.Aluno;
import school.sptech.ensine.me.models.Aula;
import school.sptech.ensine.me.models.Professor;
import school.sptech.ensine.me.models.Usuario;
import school.sptech.ensine.me.models.dto.ProfessorAulaDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    List<Usuario> usuarios;
    List<Aula> aulas;

    public UsuarioController() {
        usuarios = new ArrayList<>();
        aulas = new ArrayList<>();
        //temp
        List<String> materias = new ArrayList<>();
        materias.add("Matematica");
        materias.add("Portugues");
        usuarios.add(new Aluno("Cleiton", "cleitinho@gmail.com", "clei123",
                "10/04/1997",    "João Pinheiro"));
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarios;
    }

    @GetMapping("professores")
    public List<Usuario> listarProfessores(){
        List<Usuario> professores = new ArrayList<>();
        for (Usuario u:
                usuarios) {
            if(u instanceof Professor){
                professores.add(u);
            }
        }
        return professores;
    }
    @GetMapping("alunos")
    public List<Usuario> listarAlunos(){
        List<Usuario> alunos = new ArrayList<>();
        for (Usuario u:
                usuarios) {
            if(u instanceof Aluno){
                alunos.add(u);
            }
        }
        return alunos;
    }

    @PostMapping("alunos")
    public String cadastrarAluno(@RequestBody Aluno aluno){
        if(aluno.getEmail().length() <= 8){
            return "Cadastro não efetuado! Email deve possuir mais de 8 caracteres";
        }else if(aluno.getInstituicao().length() <= 3){
            return "Cadastro não efetuado! Institução deve possuir mais de 3 caracteres";
        }else if(aluno.getNome().length() <= 5){
            return "Cadastro não efetuado! Nome deve possuir mais de 5 caracteres";
        }else if(aluno.getSenha().length() <= 7){
            return "Cadastro não efetuado! Senha deve possuir mais de 7 caracteres";
        }else if(aluno.getDataNasc().length() != 10){
            return "Cadastro não efetuado! Insira uma data de nascimento válida (dd/mm/yyyy)";
        }else{
            for (Usuario u:
                 usuarios) {
                if(u.getEmail().equals(aluno.getEmail())){
                    return String.format("Cadastro não efetuado! %s já está cadastrado no sistema", u.getEmail());
                }
            }
            usuarios.add(aluno);
            return String.format("Aluno %s cadastrado com sucesso. id: %d", aluno.getNome(), aluno.getId());
        }
    }

    @PostMapping("professores")
    public String cadastrarProfessor(@RequestBody Professor professor){
        if(professor.getEmail().length() <= 8){
            return "Cadastro não efetuado! Email deve possuir mais de 8 caracteres";
        }else if(professor.getNome().length() <= 5){
            return "Cadastro não efetuado! Nome deve possuir mais de 5 caracteres";
        }else if(professor.getSenha().length() <= 7){
            return "Cadastro não efetuado! Senha deve possuir mais de 7 caracteres";
        }else if(professor.getDataNasc().length() != 10){
            return "Cadastro não efetuado! Insira uma data de nascimento válida (dd/mm/yyyy)";
        }else if(professor.getDescricao().length() != 0 &&
            professor.getDescricao().length() <= 10){
            return "Cadastro não efetuado! Descrição deve possuir mais de 10 caracteres ou estar vazia";
        }
        for (String competencias:
             professor.getCompetencias()) {
            if(competencias.length() <= 5){
                return "Cadastro não efetuado! As materias devem possuir mais de 5 caracteres";
            }
        }
        for (String dias:
             professor.getDiasTrabalho()) {
            if(dias.length() != 16){
                return "Cadastro não efetuado! Insira uma data/hora válida (dd/mm/yyyy hh:MM)";
            }
        }
        for (Usuario u:
             usuarios) {
            if (u.getEmail().equals(professor.getEmail())){
                return String.format("Cadastro não efetuado! %s já está cadastrado no sistema", u.getEmail());
            }
        }
        usuarios.add(professor);
        return String.format("Professor %s cadastrado com sucesso. id: %d", professor.getNome(), professor.getId());
    }
    @GetMapping("aulas")
    public List<Aula> listarAulas(){
        return aulas;
    }
    @PostMapping("aulas")
    public String cadastrarAula(@RequestBody ProfessorAulaDTO professorAulaDTO){
        if (professorAulaDTO.getEmail().length() <= 8){
            return "Cadastro não efetuado! Email deve possuir mais de 8 caracteres";
        }else if(professorAulaDTO.getSenha().length() <= 7){
            return "Cadastro não efetuado! Senha deve possuir mais de 7 caracteres";
        }else if(professorAulaDTO.getDataHora().length() != 16){
            return "Cadastro não efetuado! Insira uma data/hora válida (dd/mm/yyyy hh:MM)";
        }else if(professorAulaDTO.getMateria().length() <= 5){
            return "Cadastro não efetuado! Materia deve possuir mais de 5 caracteres";
        }else if(professorAulaDTO.getTitulo().length() <= 5){
            return "Cadastro não efetuado! Titulo deve possuir mais de 5 caracteres";
        }else if(professorAulaDTO.getQtdAlunos() < 1){
            return "Cadastro não efetuado! Quantidade minima de alunos é 1";
        }
        for (Usuario u:
             usuarios) {
            if(u instanceof Professor){
                if(professorAulaDTO.getEmail().equals(u.getEmail())){
                    if(professorAulaDTO.getSenha().equals(u.getSenha())){
                        for (String materia:
                             ((Professor) u).getCompetencias()) {
                            if (professorAulaDTO.getMateria().equals(materia)){
                                Aula aula = new Aula((Professor) u, professorAulaDTO.getTitulo(),professorAulaDTO.getMateria(),
                                        professorAulaDTO.getDataHora(),professorAulaDTO.getQtdAlunos());
                                aulas.add(aula);
                                return "Aula cadastrada com sucesso!";
                            }
                        }
                        return "Cadastro não efetuado! Professor não pode dar essa materia";
                    }else{
                        return "Cadastro não efetuado! email e/ou senha incorretos";
                    }
                }
            }
        }
        return "Cadastro não efetuado! email e/ou senha incorretos";
    }

    @PatchMapping("aulas/{id}")
    public String entrarNaAula(){

        return "";
    }

}
