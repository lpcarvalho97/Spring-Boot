package com.exemplo.springboot.apirest.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exemplo.springboot.apirest.modelo.Empregado;

@Repository
public interface EmpregadoRepositorio extends JpaRepository<Empregado, Long>{

}
