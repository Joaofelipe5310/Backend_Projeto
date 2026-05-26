package api.service;

import api.dto.CategoryDTO;
import api.dto.LineDTO;
import api.dto.ModelDTO;
import api.entity.Line;
import api.repository.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService {

    @Autowired
    LineRepository repository;

    public List<LineDTO> getLines() {

        List<Integer> ids = repository.findAllIds();

        List<Line> lines = repository.findAllById(ids);

        return lines.stream()
                .map(line -> new LineDTO.Builder()
                        .name(line.getName())
                        .categories(line.getCategories().stream()
                                .map(category -> new CategoryDTO.Builder()
                                        .name(category.getName())
                                        .models(category.getModel().stream()
                                                .map(model -> new ModelDTO.Builder()
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