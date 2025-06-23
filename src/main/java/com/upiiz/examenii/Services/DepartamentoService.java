package com.upiiz.examenii.Services;

import com.upiiz.examenii.Models.DepartamentoModel;
import com.upiiz.examenii.Repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoModel> findAll() {
        return departamentoRepository.findAll();
    }

    public DepartamentoModel findById(int id) {
        return departamentoRepository.findById(id);
    }

    public void save(DepartamentoModel departamento) {
        departamentoRepository.save(departamento);
    }

    public void update(DepartamentoModel departamento) {
        departamentoRepository.update(departamento);
    }

    public void delete(int id) {
        departamentoRepository.delete(id);
    }
}
