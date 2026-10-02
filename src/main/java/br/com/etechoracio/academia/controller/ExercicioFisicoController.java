package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    private ExercicioFisicoService exercicioFisicoService;

    public ExercicioFisicoController(
            ExercicioFisicoService exercicioFisicoService) {

        this.exercicioFisicoService = exercicioFisicoService;
    }

    @GetMapping
    public List<ExercicioFisicoResponseDTO> buscarTodos() {
        return exercicioFisicoService.buscarTodos();
    }

}