package api.service;

import api.dto.ModelDTO;
import api.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {

    @Autowired
    private final ModelRepository repository;

    public ModelService(ModelRepository repository) {
        this.repository = repository;
    }

    public List<ModelDTO> getModels(){
        return repository.findAll().stream().map(m -> new ModelDTO.Builder()
                        .id(m.getId())
                        .name(m.getName())
                        .build())
          .collect(Collectors.toList());
    }
}