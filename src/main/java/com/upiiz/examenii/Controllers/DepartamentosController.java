package com.upiiz.examenii.Controllers;

import com.upiiz.examenii.Models.DepartamentoModel;
import com.upiiz.examenii.Services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "*") // Permitir peticiones desde cualquier origen (opcional según configuración CORS)
public class DepartamentosController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/departamentos")
    public String listadoDepartamentos(){
        return "listado-departamentos";
    }
    // Obtener todos los departamentos
    @GetMapping()
    public List<DepartamentoModel> getAllDepartamentos() {
        return departamentoService.findAll();
    }

    // Obtener un departamento por ID
    @GetMapping("/{id}")
    public DepartamentoModel getDepartamentoById(@PathVariable int id) {
        return departamentoService.findById(id);
    }

    // Crear nuevo departamento
    @PostMapping
    public DepartamentoModel crearDepartamento(@RequestBody DepartamentoModel departamento) {
        departamentoService.save(departamento);
        return departamento;
    }

    // Editar departamento existente
    @PutMapping("/{id}")
    public DepartamentoModel actualizarDepartamento(@PathVariable int id, @RequestBody DepartamentoModel departamento) {
        departamento.setIdDepartamento(id);
        departamentoService.update(departamento);
        return departamento;
    }

    // Eliminar departamento
    @DeleteMapping("/{id}")
    public void eliminarDepartamento(@PathVariable int id) {
        departamentoService.delete(id);
    }
}
