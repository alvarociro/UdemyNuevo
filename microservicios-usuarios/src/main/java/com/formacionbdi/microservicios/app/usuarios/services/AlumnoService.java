package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.Optional;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Alumno;

public interface AlumnoService {

    public Iterable<Alumno> finAll();

    public Optional<Alumno> findById(Long id);

    public Alumno save(Alumno alumno);

    public void deleteById(Long id);
    
    
}
