package api.service;

import api.dto.ModelDTO;
import api.entity.Model;
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

        List<Model> model = repository.findByNameIsNotNull();

        return model
                .stream()
                .map(m -> new ModelDTO.Builder()
                        .name(m.getName())
                        .build())
          .collect(Collectors.toList());
    }
}