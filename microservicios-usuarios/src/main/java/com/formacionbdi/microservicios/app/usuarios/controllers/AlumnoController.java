package com.formacionbdi.microservicios.app.usuarios.controllers;

import java.util.Optional;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.services.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.QAbstractAuditable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {
    @Autowired
    private AlumnoService service;
    
    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.finAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<Alumno> o = service.findById(id);
        if(o.isEmpty());{
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }
    
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){
        Alumno alumnodb =service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnodb)
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable Long id)
}
// esto es lo ultimo