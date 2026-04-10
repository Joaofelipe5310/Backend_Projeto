package API.Controller;

import API.DTO.ModelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import API.service.ModelService;

import java.util.List;

@RestController
public class ModelController {

    @Autowired
    private ModelService modelsService;

    @GetMapping("/models")

    public List<ModelDTO> getModels() {
        return modelsService.getModelDTO();
    }
}