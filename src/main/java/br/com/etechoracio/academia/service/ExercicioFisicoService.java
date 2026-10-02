package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class ExercicioFisicoService {

    private ExercicioFisicoRepository exercicioFisicoRepository;
    private ExercicioFisicoMapper exercicioFisicoMapper;

    public ExercicioFisicoService(
            ExercicioFisicoRepository exercicioFisicoRepository,
            ExercicioFisicoMapper exercicioFisicoMapper) {

        this.exercicioFisicoRepository = exercicioFisicoRepository;
        this.exercicioFisicoMapper = exercicioFisicoMapper;
    }

    public List<ExercicioFisicoResponseDTO> buscarTodos() {
        return exercicioFisicoMapper.toResponseDTOList(
                exercicioFisicoRepository.findByAprovadoTrue()
        );
    }

    public Optional<ExercicioFisicoResponseDTO> buscarPorId(Long id) {
        return exercicioFisicoRepository.findByIdAndAprovadoTrue(id)
                .map(exercicioFisicoMapper::toResponseDTO);
    }

}