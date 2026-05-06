package api.service;

import api.dto.CategoryDTO;
import api.dto.LineDTO;
import api.dto.ModelDTO;
import api.repository.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService {

    @Autowired
    private final LineRepository repository;

    public LineService(LineRepository repository) {

        this.repository = repository;
    }

    public List<LineDTO> getLines() {

        return repository.findAll()
                .stream()
                .map(line -> new LineDTO.Builder()
                        .id(line.getId())
                        .name(line.getName())
                        .categories(line.getCategories().stream().map(category -> new CategoryDTO.Builder()
                                .id(category.getId())
                                .name(category.getName())
                                .models(category.getModel().stream().map(model -> new ModelDTO.Builder()
                                        .id(model.getId())
                                        .name(model.getName())
                                        .build()
                                ).collect(Collectors.toList()))
                                .build()
                        ).collect(Collectors.toList()))
                        .build()
                )
                .collect(Collectors.toList());
    }
}