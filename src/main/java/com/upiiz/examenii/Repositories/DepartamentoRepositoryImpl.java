package com.upiiz.examenii.Repositories;

import com.upiiz.examenii.Models.DepartamentoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartamentoRepositoryImpl implements DepartamentoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DepartamentoModel> findAll() {
        String sql = "SELECT * FROM departamentos";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DepartamentoModel.class));
    }

    @Override
    public DepartamentoModel findById(int idDepartamento) {
        String sql = "SELECT * FROM departamentos WHERE idDepartamento = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idDepartamento}, new BeanPropertyRowMapper<>(DepartamentoModel.class));
    }

    @Override
    public void save(DepartamentoModel departamento) {
        String sql = "INSERT INTO departamentos (nombre, ubicacion) VALUES (?, ?)";
        jdbcTemplate.update(sql, departamento.getNombre(), departamento.getUbicacion());
    }

    @Override
    public void update(DepartamentoModel departamento) {
        String sql = "UPDATE departamentos SET nombre = ?, ubicacion = ? WHERE idDepartamento = ?";
        jdbcTemplate.update(sql, departamento.getNombre(), departamento.getUbicacion(), departamento.getIdDepartamento());
    }

    @Override
    public void delete(int idDepartamento) {
        String sql = "DELETE FROM departamentos WHERE idDepartamento = ?";
        jdbcTemplate.update(sql, idDepartamento);
    }
}
