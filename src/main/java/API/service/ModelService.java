package API.service;

import API.DTO.ModelDTO;
import API.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {


    private final ModelRepository repository;

    public ModelService(ModelRepository repository) {

        this.repository = repository;
    }

    public List<ModelDTO> getModelDTO(){

        return repository.findAll().stream().map(u -> new ModelDTO(
                u.getId(),
                u.getName())).collect(Collectors.toList());
    }
}