package api.Controller;

import api.dto.ModelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import api.service.ModelService;
import java.util.List;

@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/models")
    public List<ModelDTO> getModels() {
        return modelService.getModels();
    }
}