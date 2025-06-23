package com.upiiz.examenii.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaController {

    @GetMapping("/departamentos")
    public String vistaDepartamentos() {
        return "listado-departamentos"; // No pongas .html
    }
}
