package api.service;

import api.dto.CategoryDTO;
import api.dto.LineDTO;
import api.dto.ModelDTO;
import api.repository.LineRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService {

    private final LineRepository repository;

    public LineService(LineRepository repository) {

        this.repository = repository;
    }

    @Transactional
    public List<LineDTO> getLines() {

        return repository.findAll()
                .stream()
                .map(l -> new LineDTO(
                        l.getId(),
                        l.getName(),
                        l.getCat().stream().map(c -> new CategoryDTO(
                                c.getId(),
                                c.getName(),
                                c.getModel().stream().map(m -> new ModelDTO(
                                        m.getId(),
                                        m.getName()
                                ))
                                  .collect(Collectors.toList())
                        ))
                          .collect(Collectors.toList())
                ))
                  .collect(Collectors.toList());
    }
}