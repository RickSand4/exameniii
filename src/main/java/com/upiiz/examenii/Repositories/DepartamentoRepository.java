package com.upiiz.examenii.Repositories;

import com.upiiz.examenii.Models.DepartamentoModel;
import java.util.List;

public interface DepartamentoRepository {
    List<DepartamentoModel> findAll();
    DepartamentoModel findById(int idDepartamento);
    void save(DepartamentoModel departamento);
    void update(DepartamentoModel departamento);
    void delete(int idDepartamento);
}
