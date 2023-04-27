package com.usc.crud.controller;

import com.usc.crud.model.Empleado;
import com.usc.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private  UserService service;


    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> filtrar(@PathVariable Empleado empleado){

        return ResponseEntity.ok(service.finByUser(empleado));

    }


    // create employee rest api
    @PostMapping("/guardar")
    public Empleado createEmployee(@RequestBody Empleado empleado) {
        return service.guardarUser(empleado);
    }

    @GetMapping("/consultarAll")
    public ResponseEntity<?> consultarByUser(){

        return ResponseEntity.ok(service.buscarTdoso()
        );
    }

    // update employee rest api
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Empleado empleado){
        Optional<Empleado> empleadoregistrado = service.findById(id);
        if(empleadoregistrado.isPresent()){
            Empleado emp_act = empleadoregistrado.get();
            emp_act.setNombre(empleado.getNombre());
            emp_act.setEmail(empleado.getEmail());
            emp_act.setPassword(empleado.getPassword());
            service.guardarUser(emp_act);
            return ResponseEntity.ok(emp_act);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete employee rest api
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
       String msj = service.eliminarUser(id);
        return ResponseEntity.ok(msj);
    }

}
