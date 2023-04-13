package school.sptech.ensineme.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.ensineme.models.Aula;
import school.sptech.ensineme.models.AulaRepository;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {
    private AulaRepository aulaRepository;

    @GetMapping
    public ResponseEntity<List<Aula>> getAulas() {
        List<Aula> aulas = aulaRepository.findAll();
        if (aulas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(aulas);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Aula> getAulaPorId(@PathVariable int indice) {
        return ResponseEntity.of(aulaRepository.findById(indice));
    }

//    @GetMapping("/{email}")
//    public ResponseEntity<Aula> getAulaPorEmail(@PathVariable String email) {
//        // getProfessorPorEmail
//        if (profTemp.getEmail.equals(email) && isProfessor == true) {
//            return ResponseEntity.status(302).body(aulasDoProfessor);
//        }
//    }

    @PostMapping
    public ResponseEntity<Aula> criarAula(@RequestBody Aula newAula) {
        Aula aulaCadastrada = aulaRepository.save(newAula);
        return ResponseEntity.status(201).body(aulaCadastrada);
    }



}
