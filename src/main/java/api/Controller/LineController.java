package api.Controller;

import api.dto.LineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import api.service.LineService;
import java.util.List;

@RestController
public class LineController {

    @Autowired
    private LineService lineService;

    @GetMapping("/lines")
    public List<LineDTO> getLines() {

        return lineService.getLines();
    }
}